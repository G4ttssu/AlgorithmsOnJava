package com.company;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

/**
 *  The {@code BinarySearch} class provides a static method for binary
 *  searching for an integer in a sorted array of integers.
 *  <p>
 *  The <em>indexOf</em> operations takes logarithmic time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class BinarySearch {

    //Рекурсивная версия
    public static int depth = 1;
    public static int rank(int key, int[] massive, int low, int high)
    {
        if(low > high)
            return -1;
        int mid = low + (high - low)/2;
        if(key < massive[mid]) {
            depth++;
            return rank(key, massive, low, mid - 1);
        }
        else if(key > massive[mid]) {
            depth++;
            return rank(key, massive, mid + 1, high);
        }
        else
            return mid;
    }

    public static void randomСomparisons(int T)
    {
        for(int i = 0; i < T; ++i)
        {
            StdOut.println("Тест №" + (i+1) +"\n----------------------------------------");
            test();
        }

    }

    private static void test()
    {
        for(int size = 1000; size <= 1000000; size*=10)
        {
            int[] firstArray = new int[size];
            int[] secondArray = new int[size];
            arrayFill(firstArray);
            arrayFill(secondArray);
            int count = 0;
            for(int index = 0; index < firstArray.length; ++index)
                if(rank(firstArray[index],secondArray) != -1)
                    count+=1;
            StdOut.print("Количество элементов: " + size + " .Одинаковых элементов в двух массивах: " + count);
        }
    }

    private static void arrayFill(int[] array)
    {
        Random random = new Random();
        for(int index = 0; index < array.length; ++index)
            array[index] = random.nextInt(100000,1000000);
    }

    public static int rank2(int key, int[] array)
    {
        int lo = 0;
        int hi = array.length - 1;
        int mid = lo + (hi - lo) / 2;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            if      (key < array[mid]) hi = mid - 1;
            else if (key > array[mid]) lo = mid + 1;
            else return mid-1;
        }
        return mid-1;
    }

    public static int count(int key, int[] array)
    {
        int count = 0;
        int[] temp = array;
        int buffer = indexOf(temp,0);
        while(buffer != -1)
        {
            count+=1;
            temp[buffer] = -1;
            buffer = indexOf(temp,0);
        }
        return count;
    }

    /**
     * This class should not be instantiated.
     */
    private BinarySearch() { }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param  a the array of integers, must be sorted in ascending order
     * @param  key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * Returns the index of the specified key in the specified array.
     * This function is poorly named because it does not give the <em>rank</em>
     * if the array has duplicate keys or if the key is not in the array.
     *
     * @param  key the search key
     * @param  a the array of integers, must be sorted in ascending order
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     * @deprecated Replaced by {@link #indexOf(int[], int)}.
     */
    @Deprecated
    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    }

    /**
     * Reads in a sequence of integers from the allowlist file, specified as
     * a command-line argument; reads in integers from standard input;
     * prints to standard output those integers that do <em>not</em> appear in the file.
     *
     * @param args the command-line arguments
     */

    //public static void removeDuplicate(int[] allowlist)

    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] allowlist = in.readAllInts();
        in = new In(args[1]);

        //Если отрицательное - выводить элементы, которые присутствуют там, если положителен, то те, которые отсутствуют там
        int mode = in.readInt();

        // sort the array
        Arrays.sort(allowlist);

        // read integer key from standard input; print if not in allowlist
        if(mode >= 0)
        {
            while (!StdIn.isEmpty()) {
                int key = StdIn.readInt();
                if (BinarySearch.indexOf(allowlist, key) == -1)
                    StdOut.println(key);
            }
        }
        else
        {
            while (!StdIn.isEmpty()) {
                int key = StdIn.readInt();
                if (BinarySearch.indexOf(allowlist, key) != -1)
                    StdOut.println(key);
            }
        }
    }
}


