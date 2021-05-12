package com.shilpa;
import java.io.*;
import java.util.Calendar;

class Result {
    public static String findDay(int month, int day, int year) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.set(Calendar.YEAR, year);
        rightNow.set(Calendar.MONTH, month - 1);
        rightNow.set(Calendar.DAY_OF_MONTH, day);
        int day_of_the_week = rightNow.get(Calendar.DAY_OF_WEEK);
        String[] days = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
        return days[day_of_the_week-1];
    }
}

public class EasyProblem11 {
    public static void main(String[] args)throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int month = Integer.parseInt(firstMultipleInput[0]);

            int day = Integer.parseInt(firstMultipleInput[1]);

            int year = Integer.parseInt(firstMultipleInput[2]);

            String res = Result.findDay(month, day, year);

            bufferedWriter.write(res);
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    catch(Exception ex){
        System.out.println("Invalid date");
        }
    }

}
