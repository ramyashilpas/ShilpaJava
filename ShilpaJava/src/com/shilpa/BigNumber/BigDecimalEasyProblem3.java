package com.shilpa.BigNumber;

import java.math.BigInteger;
import java.util.Scanner;

public class BigDecimalEasyProblem3 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.
        Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(String.valueOf(sc.nextBigInteger()));
        BigInteger b = new BigInteger(String.valueOf(sc.nextBigInteger()));
        BigInteger add = a.add(b);
        BigInteger multiply = a.multiply(b);
        System.out.println("" + add);
        System.out.println("" + multiply);
        sc.close();
    }
}
