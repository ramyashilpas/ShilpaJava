package com.shilpa.StringTopic;

import java.util.Scanner;

public class StringMediumProblem8 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}
class MyRegex{
  /* Approach1-
    String ip0to255="(\\d{1,2}||(0|1)\\d{2}||2[0-4]\\d||25[0-5])";
    public String pattern=ip0to255+"\\."+ip0to255+"\\."+ip0to255+"\\."+ip0to255;*/
    //Approach2-
  public String pattern = "((\\d|\\d\\d|[0-1]\\d\\d|2[0-4][0-9]|25[0-5])\\.){3}(\\d|\\d\\d|[0-1]\\d\\d|2[0-4][0-9]|25[0-5])";

}