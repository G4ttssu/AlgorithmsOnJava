package com.company;

import java.util.Random;

public class DiceModel {
    public static void model()
    {
        final int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for(int i = 1; i <= SIDES; ++i)
            for(int j = 1; j <= SIDES; ++j)
                dist[i+j] += 1.0;
        for(int k = 2; k <= 2 * SIDES; ++k)
            dist[k] /= 36.0;
        for(int i = 0; i < dist.length; ++i)
            System.out.println(dist[i]);
    }

    public static void testModel(int N)
    {
        Random random = new Random();
        final int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for(int i = 0; i < N; ++i)
        {
            int first = random.nextInt(7);
            int second = random.nextInt(7);
            while(first == 0)
                first = random.nextInt(7);
            while (second == 0)
                second = random.nextInt(7);
            dist[first+second] += 1.0;
        }
        for(int k = 2; k <= 2 * SIDES; ++k)
            dist[k] /= N;
        for(int i = 0; i < dist.length; ++i)
            System.out.println(dist[i]);
    }
}
