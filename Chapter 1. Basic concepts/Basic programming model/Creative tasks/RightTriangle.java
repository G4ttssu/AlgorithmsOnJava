package com.company;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Random;

public class RightTriangle {
    public static void rightTriangle()
    {
        Random random = new Random();
        StdDraw.setXscale(0,100);
        StdDraw.setYscale(0,100);
        int x1 = random.nextInt(70);
        int y1 = random.nextInt(70);
        int x2 = random.nextInt(70);
        int y3 = random.nextInt(70);
        StdDraw.line(x1,y1,x2,y1);
        StdDraw.line(x1,y1,x1,y3);
        StdDraw.line(x2,y1,x1,y3);

        double radius = 0.5*(Math.sqrt(Math.pow(Math.abs(x1-x2),2)+Math.pow(Math.abs(y1-y3),2)));
        System.out.println(radius);
        StdDraw.circle((x1+x2)/2, (y1+y3)/2, radius);
    }
}
