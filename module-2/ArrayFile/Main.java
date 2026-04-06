package ArrayFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*Colton Stone, April 5, 2026, Module 2.2 Assignment

In this program I will write two arrays which store random integers and double values,
then write the data to a new file before then creating a second program which will read the file.*/


public class Main {

    public static void integers (ArrayList<Integer> randInt) {
        int[] integers = new int[5];
        Random rand = new Random();
        for (int x = 0; x < integers.length; x++) {
            integers[x] = rand.nextInt(50);
            randInt.add(integers[x]);
        }
    }



public static void doubles (ArrayList<Double> randDouble) {
    double[] doubles = new double[5];
    Random rand = new Random();
    for (double x = 0; x < doubles.length; x++) {
        doubles[(int) x] = rand.nextInt(50);
        randDouble.add(doubles[(int) x]);

    }
}


public static void main(String[] args) throws java.io.IOException {
    ArrayList<Integer> randInt = new ArrayList<>();
    ArrayList<Double> randDouble = new ArrayList<>();
    integers(randInt);
    doubles(randDouble);

    try (java.io.PrintWriter output = new java.io.PrintWriter(new java.io.FileOutputStream("Coltondatafile.dat", true))) {
       output.print("Random Integers:" + "\n");
       output.println(randInt);
       output.print("Random Doubles:" + "\n");
        output.println(randDouble);
        output.flush();


    }

    catch (java.io.IOException e) {
        e.printStackTrace();
    }

    }

}

