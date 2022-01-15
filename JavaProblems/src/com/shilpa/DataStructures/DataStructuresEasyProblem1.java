package com.shilpa.DataStructures;

import java.util.Scanner;

public class DataStructuresEasyProblem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
                for (int j = 0; j < a.length; j++) {
                    a[j] = scan.nextInt();
                }
        scan.close();
        for (int j : a) {
            System.out.println(j);
        }
    }
}

