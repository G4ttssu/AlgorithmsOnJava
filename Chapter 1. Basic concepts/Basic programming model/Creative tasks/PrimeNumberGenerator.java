package com.company;
import java.util.Arrays;

public class PrimeNumberGenerator {
    /** Класс генеририует массив простых чисел до указзанно максимального значения
     * по алгоритму Решета Эратосфена
     * Есть массив целых чисел, начиная с 2. По алгоритму вычеркивам из него все числа кратные данному числу.
     * Данный алгоритм повторятся пока не будут вычеркнуты все числа до указанному максимума.
     */

    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatePrimeNumbers(int maxValue)
    {
        if(maxValue < 2)
            return new int[0];
        else
        {
            uncrossIntegerUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void uncrossIntegerUpTo(int maxValue)
    {
        crossedOut = new boolean[maxValue + 1];
        Arrays.fill(crossedOut,false);
    }

    private static void crossOutMultiples()
    {
        int limit = determineIterationLimit();
        for (int index = 2; index <= limit; ++index)
            if(notCrossed(index))
                crossOutMultiplesOf(index);
    }

    private static int determineIterationLimit()
    {
        //Каждое кратное в массиве имеет простой множитель, больший либо равный квадратному корню из размера массив.
        //Следовательно, вычеркивать элементы, кратные числам, превышающих квадратныей корень, не нужно
        double iterationLimit = Math.sqrt(crossedOut.length);
        return (int) iterationLimit;
    }

    private static void crossOutMultiplesOf(int i)
    {
        for(int multiple = 2*i; multiple < crossedOut.length; multiple+=i)
            crossedOut[multiple] = true;
    }

    private  static boolean notCrossed(int index)
    {
        return !crossedOut[index];
    }

    private static void putUncrossedIntegersIntoResult()
    {
        result = new int[numberOfUncrossedIntegers()];
        for(int j = 0, index = 2; index < crossedOut.length; ++index)
            if(notCrossed(index))
                result[j++] = index;

    }

    private static int numberOfUncrossedIntegers()
    {
        int count = 0;
        for(int index = 2; index < crossedOut.length; ++index)
            if(notCrossed(index))
                count++;
        return count;
    }
}
