package ColtonStoneThreeThreads;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/* Colton Stone, May 2, 2026, Module 8.2 Assignment

In this program I will use three different threads to output letters, numbers, and special characters.*/

class letterThread extends Thread {
    private int range;

    letterThread(int range) {
        this.range = range;

    }

    public void run() {
        System.out.println("Thread 1: ");
        System.out.println();
        ThreadLocalRandom.current().ints(range, 'A', 'Z' + 1).
                forEach(x -> System.out.println((char) x));
        }
}


class numThread extends Thread {
        private int range;
        int min = 0;
        int max = 9;



    numThread(int range) {
            this.range = range;
        }

        public void run() {
            System.out.println("Thread 2: ");
            System.out.println();
            ThreadLocalRandom.current().ints(range, 0, 9 + 1).
                    forEach(y -> System.out.println(y));
        }
    }



class symbolThread extends Thread {
    private int range;

    symbolThread(int range) {
        this.range = range;

    }

    public void run() {
        char[] symbols = {'!', '@', '#', '$', '%', '^', '&', '*'};
        System.out.println("Thread 3: ");
        System.out.println();
        for (char z = 0; z < range; z++) {
            int symbolPrint = ThreadLocalRandom.current().nextInt(symbols.length);
            System.out.println(symbols[symbolPrint]);
        }
    }
}



public class Main {
        public static void main(String[] args) {
            Thread T1 = new letterThread(10000);
            T1.start();

            Thread T2 = new numThread(10000);
            //T2.start();

            Thread T3 = new symbolThread(10000);
            //T3.start();
        }
    }


