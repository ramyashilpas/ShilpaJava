package com.shilpa.DataStructures;

import java.util.LinkedList;
import java.util.Scanner;

public class DataStructuresEasyProblem6 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
         int N=scan.nextInt();
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<N;i++){
           int value=scan.nextInt();
           list.add(value);
        }
        int Q=scan.nextInt();
        for(int j=0;j<Q;j++){
            if(scan.next().equalsIgnoreCase("insert")){
            int index= scan.nextInt();
            int value= scan.nextInt();
            list.add(index,value);
           }
           else{
               int index=scan.nextInt();
            list.remove(index);
           }
        }
        scan.close();
        for(Integer num:list){
            System.out.print(num+ " ");
        }
    }
}
