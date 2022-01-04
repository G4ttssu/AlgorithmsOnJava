package com.company;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdDraw;

public class Main {

    public static void main(String[] args) {
        RightTriangle.rightTriangle();
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
    private static int factorial(int number)
    {
        if(number<= 1)
            return 1;
        return factorial(number-1) * number;
    }
    public static double ln(int number)
    {
        return Math.log((double) factorial(number));
    }

    //1.1.30
    public static void logicMatrix(boolean[][] matrix)
    {
        for(int row = 0; row < matrix.length; ++row)
            Arrays.fill(matrix[row],false);
        for(int row = 0; row < matrix.length; ++row)
            for(int column = 0; column < matrix[row].length; ++column)
                if(gcd(row,column) == 1)
                    matrix[row][column] = true;
    }

    static public int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

}