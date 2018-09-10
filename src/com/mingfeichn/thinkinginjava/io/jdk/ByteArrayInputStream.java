package com.mingfeichn.thinkinginjava.io.jdk;

import java.io.IOException;
import java.io.InputStream;

/**
 * ByteArrayInputStream在内存中创建一个字节数组缓冲区，从输入流读取的数据保存在该缓冲区中
 * read方法提供了一个计数器用来追踪下一个读取的字节
 * 关闭ByteArrayInputStream是无效的，即使关闭了该输入流，在接收到IOException前，该类中的方法仍可以调用
 */
public class ByteArrayInputStream extends InputStream {

    protected byte buf[];
    protected int pos;
    protected int mark = 0;
    protected int count;
    public ByteArrayInputStream(byte buf[]){
        this.buf = buf;
        this.pos = 0;
        this.count = buf.length;
    }
    public ByteArrayInputStream(byte buf[], int offset, int length) {
        this.buf = buf;
        this.pos = offset;
        this.count = Math.min(offset + length, buf.length);
        this.mark = offset;
    }
    @Override
    public int read() throws IOException {
        return 0;
    }
}
