package com.shilpa;

import java.util.Scanner;

public class EasyProblem4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            int p=s1.length();
            if(p<=10) {
                System.out.printf("%-15s", s1);
            }
            else{
                System.out.println("maximum string length is 10characters");
            }
            if ((x >= 0) && (x <= 999)) {
                System.out.printf("%03d%n", x);
            }
            else{
                System.out.println("maximum digits allowed is 3");
            }
        }

        System.out.println("================================");

    }
}
