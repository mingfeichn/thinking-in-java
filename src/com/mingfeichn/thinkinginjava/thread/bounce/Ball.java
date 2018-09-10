package com.mingfeichn.thinkinginjava.thread.bounce;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0; //初始化X轴位置
    private double y = 0; //初始化Y轴位置
    private double dx = 1; //X轴移动步长
    private double dy = 1; //Y轴移动步长

    /**
     * ball的移动方法
     * @param bounds
     */
    public void move(Rectangle2D bounds) {
        x += dx;
        y += dy;
        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }

        if (x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }

        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }

        if (y + YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() -YSIZE;
            dy = -dy;
        }
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}
