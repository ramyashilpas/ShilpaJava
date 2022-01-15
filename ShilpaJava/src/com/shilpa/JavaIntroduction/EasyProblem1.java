package com.shilpa.JavaIntroduction;

import java.util.Scanner;

public class EasyProblem1 {
    public static void main(String[] args){
        int myNum;
        Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 3; i++) {
                myNum = scanner.nextInt();
                System.out.println(myNum);
            }
        scanner.close();
    }
}
