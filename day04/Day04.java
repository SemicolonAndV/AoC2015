package AoC2015.day04;

import java.io.*;
import java.util.*;

import javax.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day04 {

    static void checkZeros(String code, int zeros) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String strToCheck = new String("");
        for (int i=0; i<zeros; i++) {
            strToCheck = strToCheck.concat("0");
        }
        long i = -1;
        while (true) {
            String res = DatatypeConverter.printHexBinary(md.digest((code + Long.toString(++i)).getBytes()));
            if (res.startsWith(strToCheck)) {
                System.out.println("Result: " + i);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException
    {
        Scanner data = new Scanner(new FileReader("AoC2015/day04/input.txt"));
        String code = new String(data.next());

        checkZeros(code, 5);
        checkZeros(code, 6);
    }
}
