package com.shilpa.DataStructures;

import java.util.*;

public class DataStructuresEasyProblem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String d;
        ArrayList<ArrayList<String>> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            d = sc.nextLine();
            list.add(i, new ArrayList<>(Arrays.asList(d.split("\\s"))));
        }

        int q = sc.nextInt();
        for (int k = 0; k < q; k++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x <= list.size() && y < list.get(x-1).size() && y >= 0) {
                System.out.println(list.get(x-1).get(y));
            } else {
                System.out.println("ERROR!");
            }
        }
       /** Approach2-
       Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<List<Integer>> A = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            int l = input.nextInt();
            ArrayList<Integer> a = new ArrayList<Integer>();
            while(l-- > 0) {
                a.add(input.nextInt());
            }
            A.add(a);
        }

        int m = input.nextInt();
        while(m-- > 0) {
            int line = input.nextInt()-1;
            int position = input.nextInt()-1;
            if (line >= A.size()) {
                System.out.println("ERROR!");
            } else if (position >= A.get(line).size()) {
                System.out.println("ERROR!");
            } else {
                System.out.println(A.get(line).get(position));
            }
        }*/
    }
}
