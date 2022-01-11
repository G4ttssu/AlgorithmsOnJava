package com.company;

import edu.princeton.cs.algs4.StdDraw;

public class Histogram {
    public static void histogram()
    {
        int N = 10;
        double l = 10;
        double r = 20;
        double interval = (l-r)/N;
        StdDraw.setXscale(-100,100);
        StdDraw.setYscale(-100,100);
        StdDraw.line(-100,0,100,0);
        double x = interval;
        double y = interval;
        double rw = 10;
        double rh = interval/2.0;
        StdDraw.filledRectangle(x,y,rw,rh);
    }
}
