package AoC2015.day06;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.awt.Point;

public class Day06 {

    public static void main(String[] args) throws IOException {
        Scanner data = new Scanner(new FileReader("AoC2015/day06/input.txt"));

        Pattern p = Pattern.compile("(.*) (\\d+),(\\d+) through (\\d+),(\\d+)");
        HashMap<Point, Boolean> lights1 = new HashMap<Point, Boolean>();
        HashMap<Point, Integer> lights2 = new HashMap<Point, Integer>();
        long sum1 = 0;
        long sum2 = 0;
        for (int i=0; i<1000; i++) {
            for (int j=0; j<1000; j++) {
                lights1.put(new Point(i, j), false);
                lights2.put(new Point(i, j), 0);
            }
        }

        while (data.hasNextLine()) {
            // For Regex groups:
            // 1 - instruction, 2, 3 - first x first matrix field, 4, 5 - last x last matrix field
            String line = data.nextLine();
            Matcher m = p.matcher(line);
            if (m.find()) {
                String instruction = m.group(1);
                int start1 = Integer.parseInt(m.group(2));
                int start2 = Integer.parseInt(m.group(3));
                int stop1 = Integer.parseInt(m.group(4));
                int stop2 = Integer.parseInt(m.group(5));
                for (int i=start1; i<=stop1; i++) {
                    for (int j=start2; j<=stop2; j++) {
                        if (instruction.equals("turn off")) {
                            lights1.put(new Point(i, j), false);
                            lights2.put(new Point(i, j), Math.max(0, lights2.get(new Point(i, j)) - 1));
                        } else if (instruction.equals("toggle")) {
                            lights1.put(new Point(i, j), !lights1.get(new Point(i, j)));
                            lights2.put(new Point(i, j), (lights2.get(new Point(i, j)) + 2));
                        } else if (instruction.equals("turn on")) {
                            lights1.put(new Point(i, j), true);
                            lights2.put(new Point(i, j), (lights2.get(new Point(i, j)) + 1));
                        }
                    }
                }
            }
    }
    for (boolean f : lights1.values()) {
        if (f) {
            sum1++;
        }
    }
    for (int f : lights2.values()) {
        sum2 += f;
    }
        System.out.println("Answer 1: " + sum1);
        System.out.println("Answer 2: " + sum2);
    }
}
