package com.shilpa.JavaIntroduction;

import java.util.Scanner;

public class EasyProblem8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            int count=0;
           while((sc.hasNext())) {
                String str = sc.nextLine();
                count++;
                System.out.println(count + " " + str);
                if(str.contains("end-of-file")) {
                break;
                }
            }
            sc.close();
    }
}
