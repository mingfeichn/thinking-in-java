#线程
多线程开发的主要两个问题：
- 竞争：线程安全问题（共享内存导致竞态条件和内存可见性问题）
- 协作：协作机制

## 解决线程安全问题的解决方案：
- synchronized
- 显式锁
- volatile
- 原子变量和CAS
- 写时复制
- ThreadLocal

### synchronized
作用: 解决竞态条件和内存可见性问题
使用方法：
synchronized保护的是对象，不是代码块
- 修饰方法
    - 实例方法：保护的对象为this
    - 静态方法：保护的对象为类对象（类.class）
- 代码块：指定对象
由于每个对象都有一个锁和等待队列，所以也可以用任意对象作为锁对象
缺点：
- 不能尝试获取锁
- 不响应中断
- 死锁
优点：
- 使用简单
- JVM不断优化，优先使用

### 显示锁
需要自己创建锁，调用相关接口
主要接口是Lock, 主要实现类是ReentrantLock

### volatile
作用：解决内存可见性问题
由于锁的成本：获取不到锁要等待；线程上下文切换开销。
如果共享的对象只有一个，操作也只是简单的get/set，set也不依赖之前的值，不存在竞态条件，只有内存可见性问题，这时，在变量的声明上加上volatile即可

### 原子变量和CAS
包含了一些以原子方式实现组合操作的方法
如果set依赖于旧值，并且同步的代码比较简单，可以考虑使用原子变量
对于并发环境中的计数，产生序列号等需求考虑使用原子变量而非锁

原子变量的基础：CAS，一般计算机系统在硬件层次上直接支持CAS指令
思想：通过循环CAS方法实现原子更新
CAS是JUC中锁、同步工具和各种容器的基础

对比synchronize?
- 乐观
- 非阻塞
- 高效

### 写时复制
什么是写时复制？
将共享对象变为只读 - 写时加锁（确保只有一个线程写） - 新建对象并修改 - 原子性地修改共享对象，让其指向新对象

### ThreadLocal
每个线程对同一个变量都有一份自己的副本，实际访问的对象是自己的

## 协作机制(解决协作问题)
协作的场景
- 生产者消费者模式
- 主从模式
- 同时开始
- 集合点

协作机制
- wait/notify
- 显示条件
- 线程的中断
- 协作工具类
- 阻塞队列
- Future/FutureTask

### wait/notify
每个对象都有一把锁和两个等待队列：
- 锁等待队列：放等待获取锁的线程
- 条件等待队列：放等待条件的线程

wait/notify和synchronize配合使用是基本协作机制
wait将自己加入条件等待队列，notify从等待队列上移除一个线程并唤醒，notify移除所有线程并唤醒
wait/notify只能在synchronized代码块内被调用
调用wait释放对象锁，进入等待队列 - 被notify唤醒，进入blocked状态竞争对象锁 - 获取到锁从wait调用中返回，并重新检查等待的条件（等待条件不一定成立）

局限性：不知道wait什么，也不知道notify什么，并且只能有一个等待队列

### 显示条件
显示条件与显示锁配合使用
支持多个等待队列，代码更易读，更高效
signal/signalAll

### 线程的中断
取消或终止线程的使用中断
中断是一种协作机制，给线程传递一个取消信号，由线程决定如何及何时退出
线程在不同的状态和IO操作时对中断的反应不同
实现一个线程应该提供明确的取消或关闭线程的方法，调用时使用该方法而不是贸然使用interrupt

### 协作工具类
除了基本的显示锁和条件，JUC针对常见的协作场景提供了多个处理协作的工具：
- 信号量类Semaphore: 限制对资源的并发访问数
- 倒计时问栓CountdownLatch: 主要用于不同角色线程的同步，如裁判/运动员模式，主从模式（主线程等待从线程的结果）
- 循环栅栏CyclicBarrier: 主要用于同一角色线程的协调，先到达栅栏的线程等待其他线程到达，所有线程都到达后一起通过，它是循环的，可用作重复的同步

### 阻塞队列
可用于生产者消费者模式

### Future/FutureTask
可用于主从模式，主线程等待从线程的执行结果，常使用异步任务执行服务，只要提交任务，提交后会返回一个Future（接口，实现类是FutureTask）
Future封装了主线程和执行线程的执行状态和结果的同步，主线程可以通过Future获取执行线程的状态、结果和取消执行线程，无需考虑同步和协作

由于管理竞争和协作的复杂,Java为提供了高级服务：
- 线程安全的容器
- 任务执行服务

## 线程安全的容器
- 同步容器
- 并发容器

### 同步容器
给普通容器加上synchronized实现线程安全的容器
性能比较低
复合操作和迭代需要手动使用synchronized同步（注意不要同步错对象）

### 并发容器
转为并发设计，线程安全、并发度高、迭代不会抛出ConcurrentModificationException，使用原子方式支持复合操作
- CopyOnWriteArrayList和CopyOnWriteArraySet
- ConcurrentHashMap
- 基于SkipList的Map和Set
- 各种队列

#### CopyOnWriteArrayList和CopyOnWriteArraySet
CopyOnWriteArrayList基于数组实现List接口
CopyOnWriteArraySet基于CopyOnWriteArrayList实现Set接口

以优化读操作为目标，牺牲了写性能，适用于读远多于写（修改不频繁），集合不大的场景

#### ConcurrentHashMap
HashMap线程不安全，在并发更新的情况下，HashMap的链表结构可能形成环，造成死循环，占满CPU
ConcurrentHashMap是并发版的HashMap,通过细粒度锁和其他并发技术实现高并发，读完全并行，写在一定程度并行
以原子方式支持一些复合操作，迭代不用加锁，不会抛出ConcurrentModificationException

#### 基于SkipList的Map和Set
TreeMap和TreeSet支持排序但线程不安全，ConcurrentHashMap线程安全但不支持排序
ConcurrentSkipListMap和ConcurrentSkipListSet对应TreeMap和TreeSet的并发版
使用SkipList而不是Tree是由于跳表更易实现高效并发算法

ConcurrentSkipListMap没有使用锁，包括写操作都是并行的，迭代不会抛出ConcurrentModificationException,弱一致性，支持一些原子操作

#### 各种队列
- ConcurrentLinkedQueue: 先进先出，实现Queue接口
- ConcurrentLinkedDeque：双端队列，实现Deque接口

都是基于链表实现，没有限制大小，无界，实现原理是循环CAS，没有用锁


## 任务执行服务
将任务提交和任务执行分离，简化了异步任务，主要涉及接口：
- Runnable和Callable
- Executor和ExecutorService
- Future

主要实现方式：
- 线程池
- 定时任务

### 线程池
线程池是任务执行服务的主要实现机制，实现类是ThreadPoolExecutor
线程池包含：阻塞任务队列和工作者线程（循环从任务队列中接收任务并执行）
线程池参数：


### 定时任务
两种实现方式：
- Timer和TimeTask
    - 一个Timer对象背后只有一个Timer线程，意味着定时任务不能好事太长或无线循环
    - 在执行r一个任务run方法时，如果run抛出异常，Timer退出，其他定时任务被取消
- ScheduledExecutorService
    - 基于线程池，可以有多个线程执行任务
    - 主要实现类是：ScheduleThreadPoolExecutor
    - 没有Timer的问题，建议使用


## 线程基础

### 什么是线程？
线程有自己的程序计数器和栈
同类的多个线程共享一块内存空间和一组资源，是线程间通信比进程更有效、更容易
共享内存会有两个问题：
- 竞态条件
- 内存可见性

## 为什么需要多线程？

## 线程的状态有哪些？
### 创建
### 就绪
### 运行
### 消亡
### 阻塞
    1. join
    2. yield
    3. sleep

## 如何创建线程？
1. 继承Thread类

2. 实现Runnable接口

3. 通过Callable和Future创建线程

4. 通过线程池创建线程

### 创建线程的三种方式对比
由于单继承多实现，采用实现Runnable或Callable接口的方式创建多线程时，还可以继承其他类

### 线程池分类
- newFixedThreadPool(int nThreads)
创建固定数目线程的线程池，可控制线程最大并发数，超出的线程会在队列中等待

- newSingleThreadExecutor()
创建一个单线程化的Executor，保证所有的任务按照指定的顺序（FIFO,LIFO,优先级）执行

- newCachedThreadPool()
创建一个可缓存的线程池，调用execute将重用以前构造的线程（如果线程可用），如果现有线程没有可用的则创建一个新线程添加到线程池中。
终止并从缓存中移除那些已有60秒未被使用的线程

- newScheduledThreadPool(int corePoolSize)
创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来代替Timer类

### 使用线程池的好处？
不使用线程池的弊端：
- 每次new Thread新建对象性能差
- 缺乏统一的线程管理，可能无限制新建线程，导致宕机和OOM
- 缺乏更多的功能，如定时执行、线程中断

使用线程池的好处：
- 重用存在的线程，减少对象创建、消亡的开销，性能好
- 可有效控制最大并发线程数，提高系统资源的利用率
- 提供定时执行、单线程、并发数控制

## 线程安全
### 不共享数据


### 共享数据
解决数据不一致问题：synchronized

#### synchronized
- 修饰方法或代码块，保证在同一时刻只有一个线程执行该方法或代码块
- 当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
- 然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。
- 尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
- 第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
- 以上规则对其它对象锁同样适用.

## 中断线程
interrupter

## 线程优先级
优先级代表概率，并非先后顺序

## 线程同步
并发线程访问同一资源，保证资源安全 --> 线程安全
synchronized，锁定范围过大导致访问资源效率低，过小导致锁无效
1. 同步块
synchronized(引用类型|this|类.class) {

}
2. 同步方法

##　死锁
解决死锁的方法：生产者消费者模式
    1. 信号灯法
    2. 管程法

## 任务调度
Time
TimeTask
Quartz








