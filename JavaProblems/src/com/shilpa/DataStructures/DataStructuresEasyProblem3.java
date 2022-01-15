package com.shilpa.DataStructures;

import java.util.Arrays;
import java.util.Scanner;

public class DataStructuresEasyProblem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int l = 1;
            while (n - l >= 0) {
                for (int i = 0; i < n; i++) {
                    int[] arrnew = Arrays.copyOfRange(arr, i, i + l);
                    if (i + l <= n) {
                        int sum = 0;
                        for (int j = 0; j < arrnew.length; j++) {
                            sum += arrnew[j];
                        }
                        if (sum < 0)
                            count++;
                    }
                }
                l++;
            }
           System.out.println(count);
    }
}
