package LinkedList;

import java.util.*;

/*Colton Stone, April 12, 2026, Module 4.2 Assignment

In this program I will write a test program that stores 50,000 integers in a LinkedList
and then test the time it takes to run through the list using an iterator vs. using the get(index) method*/

/* In my observation the iterator method is slightly faster than the "get(index)" especially when displaying a large abundance of numbers like with the 50,000 loop*/

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        fiftyTIterate(list);
        //fiftyTIndex(list);
        //fivehundredTIterate(list);
        //fivehundredTIndex(list);
    }


    // Iterator Method for the 50,000 loop
    public static void fiftyTIterate(ArrayList<Integer> list) {
        LinkedList<Integer> array = new LinkedList<>();

        for (int x = 0; x < 50000; x++) {
            list.add(x);
        }

        Iterator<Integer> IT = list.iterator();
        while (IT.hasNext()) {
            Integer sum = IT.next();
            System.out.println(sum);
        }
    }


    // Index Method for the 50,000 loop
    public static void fiftyTIndex(ArrayList<Integer> list) {
        LinkedList<Integer> array = new LinkedList<>();

        for (int x = 0; x < 50000; x++) {
            list.add(x);
            int element = list.get(x);
            System.out.println(element);
            System.out.println();
        }

    }



    // Iterator Method for the 500,000 loop
    public static void fivehundredTIterate(ArrayList<Integer> list) {
        LinkedList<Integer> array = new LinkedList<>();

        for (int x = 0; x < 500000; x++) {
            list.add(x);
        }

        Iterator<Integer> IT = list.iterator();
        while (IT.hasNext()) {
            Integer sum = IT.next();
            System.out.println(sum);
        }
    }


    // Index Method for the 500,000 loop
    public static void fivehundredTIndex(ArrayList<Integer> list) {
        LinkedList<Integer> array = new LinkedList<>();

        for (int x = 0; x < 500000; x++) {
            list.add(x);
            int element = list.get(x);
            System.out.println(element);
            System.out.println();
        }

    }

}


