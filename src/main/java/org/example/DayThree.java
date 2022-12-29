package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayThree {

    public static void main(final String args[]) {

        List<String> grid = new ArrayList<>();
        BufferedReader objReader = null;
        String stringCurrentLine;
        int numberOfTreesEncountered = 0;

        try {
            objReader = new BufferedReader(new FileReader("src/main/resources/inputSample.txt"));

            //reads file in
            while ((stringCurrentLine = objReader.readLine()) != null) {
                grid.add(stringCurrentLine);
            }

            for(int i = 0; i < grid.size(); i++) {

            String[] seperatedLines = grid.get(i).split("");

                for(String character : seperatedLines) {
                    System.out.println(character);

                }
                System.out.println("- - - - -");

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
