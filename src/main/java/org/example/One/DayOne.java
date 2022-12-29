package org.example.One;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayOne {

    public static void main(final String args[]) {

        List<Integer> expenseReport = new ArrayList<>();

        String stringCurrentLine;
        BufferedReader objReader = null;
        int sum = 0;
        int finalValue = 0;

        //reads file in
        try {
            objReader = new BufferedReader(new FileReader("src/main/resources/input.txt"));

            //reads file in
            while ((stringCurrentLine = objReader.readLine()) != null) {
                expenseReport.add(Integer.parseInt(stringCurrentLine));
            }

            for(int i = 0; i < expenseReport.size() - 1; i++) {
                int currentValue = expenseReport.get(i);

                for (Integer value : expenseReport) {
                    if (value + currentValue == 2020) {
                        finalValue = value * currentValue;
                        break;
                    }
                }
            }
            System.out.println(finalValue + " = is the product");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
