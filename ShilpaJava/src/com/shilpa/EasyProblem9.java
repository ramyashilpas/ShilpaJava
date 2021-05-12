package com.shilpa;
import java.io.IOException;
import java.util.*;

public class EasyProblem9 {

    static int B;
    static int H ;
    static boolean flag;
            static {
                Scanner sc = new Scanner(System.in);
                 B=sc.nextInt();
                 H=sc.nextInt();
                 flag=true;
                 if(B>0 && H>0){
                     flag=true;
                 }
                 else {
                     flag=false;
                     System.out.println("java.lang.Exception: Breadth and height must be positive");
                 }
            }
    public static void main(String[] args){

            if (flag) {
                int area = B * H;
                System.out.print(area);
            }

    }//end of main
}
