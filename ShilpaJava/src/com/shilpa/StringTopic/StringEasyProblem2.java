package com.shilpa.StringTopic;

import java.util.Scanner;

public class StringEasyProblem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
       String s1= s.substring(start,end);
        System.out.println(""+s1);
    }
}
