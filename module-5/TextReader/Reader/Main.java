package Reader;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/*Colton Stone, April 17, 2026, Module 5.2 Assignment

For this program I will write a program that reads words from a text file and display it first in ascending order and then in descending order.*/


public class Main {

    public static void main(String[] args) {

        String wordCollect = "TextReader/collection_of_words.txt";

            try {
                List<String> list = Files.readAllLines(Path.of(wordCollect));
                TreeSet<String> set = new TreeSet<>(list);
                Set<String> reversedSet = set.descendingSet();

                System.out.println("Ascending Order: ");
                System.out.println(set);
                System.out.println();
                System.out.println("Descending Order: ");
                System.out.println(reversedSet);
        }

        catch (IOException e) {
            e.printStackTrace();
        }


    }


}
