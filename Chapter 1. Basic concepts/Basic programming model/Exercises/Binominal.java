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

    public static double[][] binominalMassive(int N, int k, double p)
    {
        double[][] massive = new double[N+1][k+1];

        // base cases
        for (int i = 0; i <= N; i++)
            massive[i][0] = Math.pow(1.0 - p, i);
        massive[0][0] = 1.0;

        // recursive formula
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                massive[i][j] = p * massive[i-1][j-1] + (1.0 - p) *massive[i-1][j];
            }
        }
        return massive;
    }
}
