package com.shilpa.DataStructures;


import java.util.*;


public class DataStructuresEasyProblem7 {
    public static void main(String[] argh) throws ClassCastException,NullPointerException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, Integer> list = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();

            list.put(name, phone);
            in.nextLine();

        }
        try {
            while (in.hasNext()) {
                String s = in.nextLine();
                if (list.containsKey(s)) {
                    System.out.println(s + "=" + list.get(s));
                } else {

                    System.out.println("Not found");

                }
            }
        }
        finally {
                in.close();
                System.exit(0);
        }

    }
}
