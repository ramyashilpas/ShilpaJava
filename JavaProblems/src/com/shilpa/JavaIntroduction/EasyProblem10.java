package com.shilpa.JavaIntroduction;

import java.util.Scanner;

public class EasyProblem10 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.close();
            //String s=???; Complete this line below
            String s = "";
            if (n>=-100 && n<=100) {
                s = String.valueOf(n);
            }
            else{
                System.out.println("wrong answer");
            }
                if (n == Integer.parseInt(s)) {
                    System.out.println("Good job");
            }else {
                System.out.println("Wrong answer.");
            }
        }
        catch (Exception ex){
            System.out.println("Input should be Integer ranging from 100 to -100");
        }
    }
}
