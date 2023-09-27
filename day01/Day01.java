package AoC2015.day01;

import java.io.*;
import java.util.*;

public class Day01 {
    public static void main (String[] args) {
        try {
            Scanner data = new Scanner(new File("AoC2015/day01/input.txt"));
            int floor = 0;
            int counter = 0;
            boolean isSecondFound = false;
            String s = data.next();
            for (int i=0; i < s.length(); i++) {
                if (floor < 0 && !isSecondFound) {
                    isSecondFound = true;
                    System.out.println("Result 2: " + counter);
                }
                counter++;
                if (s.charAt(i) == "(".charAt(0)) {
                    floor++;
                } else {
                    floor--;
                }
            }
            System.out.println("Result 1: " + floor);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}