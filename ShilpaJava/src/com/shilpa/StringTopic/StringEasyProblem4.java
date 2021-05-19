package com.shilpa.StringTopic;


import java.util.*;

public class StringEasyProblem4 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
       //Approach1- StringBuilder rev= new StringBuilder();
        if(A.length()<50 && A.contains(A.toLowerCase())){
            /* Approach1-
            for (int i = A.length()-1; i >=0; i--)
                rev.append(A.charAt(i));
                if(rev.toString().equals(A))
                    System.out.println("Yes");
                else
                    System.out.println("No");*/
            //Approach2-
            if(A.equalsIgnoreCase(new StringBuffer(A).reverse().toString()))
                System.out.println("Yes");
            else
                System.out.println("No");
       }
        else{
            System.out.println("Length of A is less than 50 english lowercase letters");
        }

    }
}
