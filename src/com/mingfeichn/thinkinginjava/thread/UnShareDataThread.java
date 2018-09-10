package com.mingfeichn.thinkinginjava.thread;

public class UnShareDataThread extends  Thread {
    private int count = 5;

    public UnShareDataThread(String name){
        super();
        this.setName(name);
    }

    @Override
    public void run(){
        super.run();
        while(count > 0){
            count --;
            System.out.println(UnShareDataThread.currentThread().getName() + ":" + count );
        }
    }

    public static void main(String[] args) {
        UnShareDataThread unShareDataThread01 = new UnShareDataThread("A");
        UnShareDataThread unShareDataThread02 = new UnShareDataThread("B");
        UnShareDataThread unShareDataThread03 = new UnShareDataThread("C");
        unShareDataThread01.start();
        unShareDataThread02.start();
        unShareDataThread03.start();

    }
}
