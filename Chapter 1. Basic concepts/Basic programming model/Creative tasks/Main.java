package com.company;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdDraw;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println(factorial(3));
        int[] primes = PrimeNumberGenerator.generatePrimeNumbers(30);
        final int M = 10;
        final int N = 10;
        double[][] a = {{-1,-1},{2,0},{3,0}};
        double[][] b = {{1,1},{2,0}};
        double[][] c = Matrix.mult(a,b);
        Matrix.printMatrix(a);
    }
    //1.1.13
    public static int[][] transpos(int [][]a, int N, int M){
        int temp;
        for(int i = 0; i < N; ++i){
            for(int j = i; j < M; ++j){
                temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        return a;
    }

    //1.1.14
    public static int lg(int n){
        if(n > 0){
            int i = 0;
            while(n >> 1 != 0) {
                i++;
                n = n >> 1;
            }
            return i;
        }
        else
            return 0;
    }
    //1.1.15
    public static int[] histogram(int[] a, int M){
        int[] temp = new int[M];
        for(int i = 0; i < M; ++i) {
            int count = 0;
            for (int j = 0; j < M; ++j) {
                if (i == a[j])
                    count++;
            }
            temp[i] = count;
        }
        return temp;
    }

    public static int sumMas(int[] a, int M){
        int sum = 0;
        for(int i = 0; i < M; ++i)
            sum+=a[i];
        return sum;
    }

    //1.1.16
    public static String exR1(int n)
    {
        if(n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    //1.1.20
    public static double factorial(int n)
    {
        if(n <= 1)
            return 1;
        return Math.log(factorial(n-1)) + Math.log((double) n);
    }

    /*
    public static double ln(int n)
    {

    }

     */
    //1.1.21

    //1.1.30
    public static void logicMatrix(boolean[][] matrix)
    {
        for(int raw = 0; raw < matrix.length; ++raw)
            Arrays.fill(matrix[raw],false);
        for(int raw = 0; raw < matrix.length; ++raw)
            for(int column = 0; column < matrix[raw].length; ++column)

    }

    private static boolean IsPrimeIndex(int value, int[] massive)
    {
        boolean flag = false;
        for(int index = 0; index < massive.length; ++index)
            if(value == massive[])
    }

}