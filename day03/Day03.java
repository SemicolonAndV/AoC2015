package AoC2015.day03;

import java.io.*;
import java.util.*;

import java.awt.Point;

public class Day03 {

    static int strToInt(String x) {
        return Integer.parseInt(x);
    }
    public static void main(String[] args) throws IOException
    {
        Scanner data = new Scanner(new FileReader("AoC2015/day03/input.txt"));
        char[] dirs = new String(data.next()).toCharArray();
        HashMap<Character, Point> tr = new HashMap<Character, Point>();
        tr.put("^".charAt(0), new Point(0, 1));
        tr.put("v".charAt(0), new Point(0, -1));
        tr.put(">".charAt(0), new Point(1, 0));
        tr.put("<".charAt(0), new Point(-1, 0));

        Point current = new Point(0, 0);
        Point santa = new Point(0, 0);
        Point robot = new Point(0, 0);
        Set<Point> coords = new HashSet<Point>();
        Set<Point> coordsSr = new HashSet<Point>();
        coords.add(new Point(current.x, current.y));
        coordsSr.add(new Point(current.x, current.y));
        for (int i=0; i<dirs.length; i++) {
            Point tl = tr.get(dirs[i]);
            // Part 1
            current.translate(tl.x, tl.y);
            coords.add(new Point(current.x, current.y));
            // Part 2
            if (i % 2 == 0) {
                santa.translate(tl.x, tl.y);
                coordsSr.add(new Point(santa.x, santa.y));
            } else {
                robot.translate(tl.x, tl.y);
                coordsSr.add(new Point(robot.x, robot.y));
            }
        }
        System.out.println("Answer 1: " + coords.size());

        System.out.println("Answer 2: " + coordsSr.size());
    }
}
