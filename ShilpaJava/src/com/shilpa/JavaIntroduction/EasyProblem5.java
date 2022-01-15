package com.shilpa.JavaIntroduction;

import java.util.Scanner;

public class EasyProblem5 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m;
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      if((n>=2)&&(n<=20)){
            for (int i = 1; i <= 10; i++) {
            m=n*i;
            System.out.println(n + " x "+i +" = "+m);
            }
        }
      else {
          System.out.println("maximum limit for Natural number n is 20");
      }

    }
}