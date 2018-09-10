package com.mingfeichn.thinkinginjava.thread.bounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450; //窗口宽
    private static final int DEFAULT_HEIGHT = 350; //窗口高

    private List<Ball> balls = new ArrayList<>(); //窗口中的小球

    /**
     * 增加小球
     * @param b Ball对象
     */
    public void add(Ball b) {
        balls.add(b);
    }

    /**
     * 绘制小球
     * @param g 笔刷对象
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //擦除背景
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    /**
     * 获取预定义的尺寸
     * @return 定义的尺寸对象
     */
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
