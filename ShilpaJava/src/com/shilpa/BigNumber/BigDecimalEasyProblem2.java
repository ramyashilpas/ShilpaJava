package com.shilpa.BigNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BigDecimalEasyProblem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        BigInteger b=new BigInteger(n);
       boolean ans= b.isProbablePrime(1);
       if(ans){
           System.out.println("prime");
       }else {
           System.out.println("not prime");
       }
        bufferedReader.close();
    }
}
