package com.shilpa;

import java.util.*;

public class EasyProblem6 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();//no.of queries or series
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();//n is the power of 2
            for(int j=0;j<n;j++){
                a+=(int)(Math.pow(2,j))*b;//a=a+(b.2^j)
                System.out.print(a+" ");
            }
            System.out.println();
        }
        in.close();
    }
}
