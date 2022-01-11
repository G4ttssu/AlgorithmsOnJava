package com.company;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix {

    public static double dot(double[] firstVector, double[] secondVector)
    {
        double result = 0.0;
        if(compareVector(firstVector,secondVector) && threeOrLessDimensionalVector(secondVector) && threeOrLessDimensionalVector(firstVector))
            for(int demension = 0; demension < firstVector.length; ++demension)
                result += firstVector[demension]*secondVector[demension];
        return result;
    }

    public static double[][] createNewJaggedMatrix(int rows)
    {
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[rows][];
        for(int index = 0; index < matrix.length; ++index)
        {
            StdOut.print("Enter the number of rows for the" + (index +1) + " column");
            int columns = scanner.nextInt();
            matrix[index] = new double[columns];
        }
        return matrix;
    }


    public static double[][] createNewMatrix(int rows, int columns)
    {
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[rows][columns];
        for(int row = 0; row < rows; ++row)
            for(int column = 0; column < columns; ++column)
                matrix[row][column] = scanner.nextDouble();
        return matrix;
    }

    public static double[][] createNewRandomMatrix(int rows, int columns)
    {
        Random random = new Random();
        double[][] matrix = new double[rows][columns];
        for(int row = 0; row < rows; ++row)
            for(int column = 0; column < columns; ++column)
                matrix[row][column] = (double)(random.nextInt() % 100) + ((double)(random.nextInt() % 100))/100;
        return matrix;
    }

    private static void fill(double[][] matrix)
    {
        for (double[] row : matrix) Arrays.fill(row, 0);
    }

    public static void printMatrix(double[][] matrix)
    {
        System.out.println();
        for(int row = 0; row < matrix.length; ++row)
        {
            for (int column = 0; column < matrix[row].length; ++column)
                if(matrix[row][column] > 0)
                    System.out.print(" " + matrix[row][column] + "  ");
                else
                    System.out.print(matrix[row][column] + " ");
            System.out.println();
        }
    }

    private static boolean threeOrLessDimensionalVector (double[] vector)
    {
        return vector.length < 4;
    }

    public static double[][] mult(double[][] firstMatrix, double[][] secondMatrix)
    {
        double[][] resultMatrix = new double[firstMatrix.length][secondMatrix[0].length];
        fill(resultMatrix);
        if(satisfiedConditionForMultiplicationMatrix(firstMatrix,secondMatrix))
        {
            for(int row = 0; row < firstMatrix.length; ++row)
                for(int column = 0; column < secondMatrix[0].length; ++column)
                    for(int index = 0; index < firstMatrix[0].length; ++index)
                        resultMatrix[row][column] += firstMatrix[row][index] * secondMatrix[index][column];
        }
        return resultMatrix;
    }

    public static double[][] transpose(double[][] matrix)
    {
        if(squareMatrix(matrix))
        {
            double buff;
            for(int row = 0; row < matrix.length; ++row)
                for(int column = row; column < matrix.length; ++column)
                {
                    buff = matrix[row][column];
                    matrix[row][column] = matrix[column][row];
                    matrix[column][row] = buff;
                }
        }
        return matrix;
    }

    private static boolean satisfiedConditionForMultiplicationMatrix(double[][] firstMatrix, double[][] secondMatrix)
    {
        boolean conditionMultiplicationMatrix = false;
        if(NotJaggedMatrix(firstMatrix) && NotJaggedMatrix(secondMatrix))
        {
            if(firstMatrix[0].length == secondMatrix.length)
                conditionMultiplicationMatrix = true;
        }
        return conditionMultiplicationMatrix;
    }

    private static  boolean NotJaggedMatrix(double [][] matrix)
    {
        int columns = matrix[0].length;
        boolean jaggedMatrix = false;
        int row = 1;
        while(!jaggedMatrix && row < matrix.length)
        {
            if(columns != matrix[row].length)
                jaggedMatrix = true;
            ++row;
        }
        return !jaggedMatrix;
    }

    private static boolean squareMatrix(double[][] matrix)
    {
        int row = matrix.length;
        int index = 0;
        boolean squareMatrix = true;
        while(squareMatrix && index < row)
        {
            if(matrix[index].length != row)
                squareMatrix = false;
            ++index;
        }
        return squareMatrix;
    }

    public static double[] mult(double[][] matrix, double[] vector)
    {
        double[] result = new double[matrix.length];
        Arrays.fill(result,0);
        if(satisfiedConditionForMultiplicationVectorMatrix(matrix,vector) && NotJaggedMatrix(matrix))
        {
            for(int row = 0; row < matrix.length; ++row)
                for(int column = 0; column < matrix[row].length; ++column)
                    result[row] += matrix[row][column] * vector[column];
        }
        return result;
    }

    private static boolean satisfiedConditionForMultiplicationVectorMatrix(double[][] matrix, double[] vector)
    {
        return matrix.length == vector.length;
    }

    private static boolean compareVector(double[] firstVector, double[] secondVector)
    {
        return firstVector.length == secondVector.length;
    }

    public static double[] mult(double[] vector, double[][] matrix)
    {
        double[] result = new double[matrix.length];
        Arrays.fill(result,0);
        if(satisfiedConditionForMultiplicationVectorMatrix(matrix,vector) && NotJaggedMatrix(matrix))
        {
            for(int row = 0; row < matrix.length; ++row)
                for(int column = 0; column < matrix[row].length; ++column)
                    result[row] += matrix[row][column] * vector[column];
        }
        return result;
    }

}
