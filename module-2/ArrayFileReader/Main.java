package ArrayFileReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*Colton Stone, April 5, 2026, Module 2.2 Assignment

In this program I will write two arrays which store random integers and double values,
then write the data to a new file before then creating a second program which will read the file.*/


public class Main {

    public static void main(String[] args) throws java.io.IOException {
        List<String> datafile = Files.readAllLines(Path.of("Coltondatafile.dat"));
        for (String numbers : datafile) {
            System.out.println(numbers);
        }

    }

}




