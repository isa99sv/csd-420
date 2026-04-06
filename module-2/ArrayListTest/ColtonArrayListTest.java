package ArrayListTest;

import java.util.*;

/*Colton Stone, February 19, 2026, Module 8.2 Assignment

In this program I will write a test ArrayList class which will contain methods that hold user inputted integers
and then use a method to find the highest value among the array*/



class ColtonArrayListTest {

    public static void intArray(ArrayList<Integer> intList) {
        Scanner scanner = new Scanner(System.in);
        int numList;
        int loopList;

        do {
            System.out.println("\nEnter numbers for your arraylist: ");
            numList = 1;


        for (int i = 0; i <numList; i++) {
            loopList = scanner.nextInt();
            intList.add(loopList);
            System.out.println("\nYou added a number to the list.");
            scanner.nextLine();
        }

    }
        while(!intList.contains(0));
        scanner.close();
        System.out.println();
        int listChecker = intList.get(0);
        if(listChecker == 0) {
            intList.clear();
        }
        System.out.println("\nYou entered 0 and have exited inputting data into the list.");
        System.out.println("\nYour final arraylist is: " + intList);
    }

    public static Integer max (ArrayList<Integer>intList) {

        int maxValue = 0;

        if(!intList.isEmpty()) {
            maxValue = intList.get(0);
            for (int j = 1; j < intList.size(); j++) {
                if (maxValue < intList.get(j))
                    maxValue = intList.get(j);
            }

            System.out.println("\nThe largest value in this Arraylist is: " + maxValue);


        }

        else if(intList.isEmpty()) {
            System.out.println("\nThis Arraylist is empty and holds a value of: " + maxValue);
            return 0;
        }

        return maxValue;
    }



    public static Integer min (ArrayList<Integer>intList) {

        int minValue = 0;

        if(!intList.isEmpty()) {
            minValue = intList.get(0);
            for (int j = 1; j < intList.size(); j++) {
                if (minValue > intList.get(j))
                    minValue = intList.get(j);
            }

            System.out.println("\nThe smallest value in this Arraylist is: " + minValue);


        }

        else if(intList.isEmpty()) {
            System.out.println("\nThis Arraylist is empty and holds a value of: " + minValue);
            return 0;
        }

        return minValue;
    }


    public static Integer avg (ArrayList<Integer>intList) {

        int avgValue = 0;
        int average = 0;

        if(!intList.isEmpty()) {
            avgValue = intList.get(0);
            for (int avg : intList) {
               avgValue += avg;
            }

            average = avgValue / intList.toArray().length;

            System.out.println("\nThe average value in this Arraylist is: " + average);


        }

        else if(intList.isEmpty()) {
            System.out.println("\nThis Arraylist is empty and holds a value of: " + average);
            return 0;
        }

        return average;
    }




    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();

        intArray(intList);
        max(intList);
        min(intList);
        avg(intList);
    }



}