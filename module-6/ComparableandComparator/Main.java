package ComparableandComparator;

import java.util.*;

/* Colton Stone, April 24, 2026, Module 6.2 Assignment

For this program I will write two generic methods using a bubble sort with the first one making use of the comparable interface
and the second making using of comparator.*/

public class Main {

    public static <E extends Comparable<E>> void bSort(E[] bList) {
        boolean switched = true;

        for(int x = 1; x < bList.length && switched; ++x) {
            switched = false;
            for (int y = 0; y < bList.length - x; ++y) {
                if(bList[y].compareTo(bList[y + 1]) > 0) {
                    E temp = bList[y];
                    bList[y] = bList[y + 1];
                    bList[y + 1] = temp;
                    switched = true;
                }
            }
        }

    }



    public static <E> void bSort(E[] bList, Comparator<? super E> comparator) {
        boolean switched = true;

        for(int x = 1; x < bList.length && switched; ++x) {
            switched = false;
            for (int y = 0; y < bList.length - x; ++y) {
                if(comparator.compare(bList[y], bList[y + 1]) > 0) {
                    E temp = bList[y];
                    bList[y] = bList[y + 1];
                    bList[y + 1] = temp;
                    switched = true;
                }
            }
        }
    }



    public static void printArray(Object[] arrayList) {
        for (int y = 0; y < 1; y++)
        System.out.println(Arrays.toString(arrayList));
        System.out.println();
    }



    public static void main(String[] args) {
        Integer[] testValues = {30, 20, 45, 50, 15, 5, 10, 35, 25, 40};

        System.out.println("Original ArrayList: " + "\n" + Arrays.toString(testValues));
        System.out.println();
        System.out.println("Sorted ArrayList: ");
        bSort(testValues);
        printArray(testValues);
    }
}
