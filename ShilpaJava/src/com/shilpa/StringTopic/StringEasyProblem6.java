package com.shilpa.StringTopic;

//import java.util.Arrays;
//import java.util.List;
import java.util.Scanner;
//import java.util.stream.*;

public class StringEasyProblem6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        s = s.trim();
        if (s.length() == 0) {
            System.out.println(0);
        } else {
       /* Approach1-
         String deli="[ .,_'?!@]+";
         String[] p=s.split(deli);
         long count= Arrays.stream(p).count();
         System.out.println(""+count);
         List<String> l=Arrays.stream(p).collect(Collectors.toList());
           for (int i = 0; i <l.toArray().length ; i++) {
            System.out.println( l.get(i));
           }
         }
      */
            String[] strings = s.split("['!?,._@ ]+");
            System.out.println(strings.length);
            for (String str : strings)
                System.out.println(str);
        }
        scan.close();
    }
}
