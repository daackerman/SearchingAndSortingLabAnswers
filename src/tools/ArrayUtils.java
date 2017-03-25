package tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Adapted from Java Concepts Early Objects 8th Edition
 * @author Cay Horstmann
 *
 * This program is a utility class for working with arrays of integers. It has static methods that swap elements
 * as well as methods that build random arrays.
 *
 * TODO implement both swap methods and both isSorted methods.
 */
public class ArrayUtils {
    private static Random generator = new Random();
    /**
     * Builds and returns a random array of length integers with values from 0 to n - 1.
     * @param length the number of integers in the array.
     * @param n the number of possible random values.
     * @return an array of length length with values from 0 to n - 1 inclusive.
     */
    public static int[] randomIntArray(int length, int n) {
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = generator.nextInt(n);
        }
        return a;
    }

    public static List<String> randomStringList(int length, String file) {
        Scanner scanner = null;
        List<String> text = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        boolean textStarted = false;
        try {
            scanner = new Scanner(new FileInputStream("res/" + file));
        } catch (IOException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        while (scanner.hasNextLine()) {
            while(!textStarted) {
                String line = scanner.nextLine();
                if (line.startsWith("***")) {
                    textStarted = true;
                }
            }
            String line = scanner.nextLine();
            if (!line.startsWith("***")) {
                line = line.replaceAll("[^a-zA-Z ]", " ");
                String[] words = line.split(" ");
                for (String w : words) {
                    if (w.length() != 0) {
                        text.add(w);
                    }
                }
            }
        }

        for (int i = 0; i < length; i++) {
            result.add(text.get(generator.nextInt(text.size())));
        }
        return result;
    }

    /**
     * Swaps the values of the passed array at index i and index j.
     * @param a the array
     * @param i one of the indexes to swap
     * @param j the other index to swap
     */
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Swaps the values of the passed List at index i and index j.
     * @param list the list
     * @param i one of the indexes to swap
     * @param j the other inde to swap
     */
    public static void swap(List<String> list, int i, int j) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * Determines if an array of integers is sorted or not.
     * @param a an array of integers.
     * @return true if sorted
     *         false otherwise.
     */
    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines if a List of Strings is sorted or not.
     * @param list a list of Strings.
     * @return true if sorted
     *         false otherwise.
     */
    public static boolean isSorted(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i+1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
