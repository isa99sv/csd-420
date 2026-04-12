package NewArrayList;

import java.util.*;

/*Colton Stone, April 11, 2026, Module 3.2 Assignment

In this program I will write a static method that returns a new ArrayList*/

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> oList = new ArrayList<>();
        oriList(oList);
        removeDuplicates(oList);

    }

    public static <E> ArrayList<Integer> oriList(ArrayList<Integer> list) {
        int total = 50;
        int min = 1;
        int max = 20;
        Random rand = new Random();

        for (int i = 0; i < total; i++) {
            list.add(rand.nextInt(max - min + 1) + min);
        }

        System.out.println("Original List: ");
        System.out.println(list);
        System.out.println();
        return list;
    }

    public static <E> ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {

        LinkedHashSet<Integer> newList = new LinkedHashSet<>(list);

        System.out.println("New List: ");
        System.out.println(newList);
        return new ArrayList<>(newList);
    }

}

