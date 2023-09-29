package AoC2015.day05;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Day05 {

    public static void main(String[] args) throws IOException {
        Scanner data = new Scanner(new FileReader("AoC2015/day05/input.txt"));
        Pattern p1 = Pattern.compile("(.)\\1");
        Pattern p2 = Pattern.compile("cd|ab|pq|xy");
        Pattern p3 = Pattern.compile("(.*[aeiou]){3}");
        Pattern p4 = Pattern.compile("(..).*\\1");
        Pattern p5 = Pattern.compile("(.).\\1");
        int matches1 = 0;
        int matches2 = 0;

        while (data.hasNextLine()) {
            String line = data.nextLine();
            if (p1.matcher(line).find() && !p2.matcher(line).find() && p3.matcher(line).find()) {
                matches1++;
            }
            if (p4.matcher(line).find() && p5.matcher(line).find()) {
                matches2++;
            }
        }
        System.out.println("Answer 1: " + matches1);
        System.out.println("Answer 2: " + matches2);
    }
}
