package com.company;

import java.util.Random;

public class Sattolo {

    public static void main(Object[] str)
    {
        for(int i = 0; i < str.length; ++i)
            System.out.println(str[i]);
        Random random = new Random();
        for(int index = 0; index < str.length; ++index)
        {
            int j = random.nextInt(index+1);
            if( j != index)
            {
                Object swap = str[j];
                str[j] = str[index];
                str[index] = swap;
            }
        }
        System.out.println();
        for(int i = 0; i < str.length; ++i)
            System.out.println(str[i]);
    }
}
