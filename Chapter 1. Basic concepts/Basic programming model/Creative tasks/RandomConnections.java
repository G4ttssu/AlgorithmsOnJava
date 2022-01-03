package com.company;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Random;

public class RandomConnections {

    public static void circle()
    {
        Random random = new Random();
        StdDraw.setXscale(-50,50);
        StdDraw.setYscale(-50,50);
        double p = 0.5;
        int N = 30;
        double radius = 25;
        double[][] points = new double[N][2];
        for(int index = 0; index < points.length; ++index)
        {
            double theta = (double)(index * (360.0/N) * Math.PI / 180);
            points[index][0] = radius * Math.cos(theta);
            points[index][1] = radius * Math.sin(theta);
        }
        for(int index = 0; index < points.length; ++index)
            StdDraw.point(points[index][0],points[index][1]);
        StdDraw.setPenColor(StdDraw.GRAY);
        for(int index = 0; index < points.length; ++index)
            for(int j = 0; j < points.length; ++j)
            {
                int randProbability = random.nextInt(101);
                if(randProbability < p*100 && p != 0)
                    StdDraw.line(points[index][0],points[index][1],points[j][0],points[j][1]);
            }


    }
}
