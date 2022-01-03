package com.company;

public class Binominal {

    public static double binominal(int N, int k, double p)
    {
        if(N == 0 && k == 0)
            return 1.0;
        if(N < 0.1 || k < 0)
            return 0.0;
        return (1.0 - p)*binominal(N-1,k,p) + p*binominal(N-1,k-1,p);
    }
}
