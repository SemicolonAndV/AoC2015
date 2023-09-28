package AoC2015.day02;

import java.io.*;
import java.util.*;

public class Day02 {

    static int strToInt(String x) {
        return Integer.parseInt(x);
    }
    public static void main(String[] args) throws IOException
    {
        Scanner data = new Scanner(new FileReader("AoC2015/day02/input.txt"));
        List<String> packs = new ArrayList<String>();
        int paper = 0;
        int ribbon = 0;
        while (data.hasNextLine()) {
            packs.add(data.nextLine());
        }
        String[] packStrings = packs.toArray(new String[0]);
        for(int i=0; i<packs.size(); i++) {
            String[] dims = packStrings[i].split("x");
            int a = strToInt(dims[0]);
            int b = strToInt(dims[1]);
            int c = strToInt(dims[2]);
            int[] tab = new int[3];
            tab[0] = a;
            tab[1] = b;
            tab[2] = c;
            Arrays.sort(tab);
            paper += (a * b + a * c + b * c) * 2 + tab[0] * tab[1]; 
            ribbon += a * b * c + tab[0] * 2 + tab[1] * 2;
        }
        System.out.println("Answer 1: " + paper);
        System.out.println("Answer 2: " + ribbon);
    }
}
