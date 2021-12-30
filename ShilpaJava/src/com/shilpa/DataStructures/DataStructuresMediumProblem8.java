package com.shilpa.DataStructures;

import java.util.Scanner;
import java.util.Stack;

public class DataStructuresMediumProblem8 {
    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            //Complete the code
            System.out.println(balanced(input));
        }
        sc.close();
    }
    public static boolean balanced(String s){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='[' || c=='('||c=='{'){
                stack.push(c);
            }else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
