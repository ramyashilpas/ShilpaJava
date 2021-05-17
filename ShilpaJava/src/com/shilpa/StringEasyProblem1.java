package com.shilpa;

import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;

public class StringEasyProblem1 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A= sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        if((A.equals(A.toLowerCase())) && (B.equals(B.toLowerCase()))) {
            System.out.println(A.length()+B.length());
            System.out.println(A.compareTo(B)>0?"Yes":"No");
            A = A.substring(0,1).toUpperCase()+A.substring(1).toLowerCase();
            B = B.substring(0,1).toUpperCase()+B.substring(1).toLowerCase();
            System.out.println(A+" "+B);
        }
        else{
            System.out.println("Enter lowercase english letters");
        }
    }
}
