package org.example.Two;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayTwoPartTwo {

    public static void main(final String args[]) {

        List<String> passwords = new ArrayList<>();
        BufferedReader objReader = null;
        String stringCurrentLine;
        String minimumNumber;
        String maximumNumber;
        String letterToMatch;
        String password;
        int numberOfValidPasswords = 0;

        try {
            objReader = new BufferedReader(new FileReader("src/main/resources/input.txt"));

            //reads file in
            while ((stringCurrentLine = objReader.readLine()) != null) {
                passwords.add(stringCurrentLine);
            }

            for(int i = 0; i < passwords.size(); i++) {
//            for(int i = 0; i < 3; i++) {
                boolean firstPositionCheck = false;
                boolean secondPositionCheck = false;

                String[] parts = passwords.get(i).split("[ :-]");
                minimumNumber = parts[0];
                maximumNumber = parts[1];
                letterToMatch = parts[2];
                password = parts[4];

                String firstPosition = password.substring(Integer.parseInt(minimumNumber) - 1, Integer.parseInt(minimumNumber));
                String secondPosition = password.substring(Integer.parseInt(maximumNumber) - 1, Integer.parseInt(maximumNumber));

                if(firstPosition.equalsIgnoreCase(letterToMatch)) {
                    firstPositionCheck = true;
                }
                if(secondPosition.equalsIgnoreCase(letterToMatch)) {
                    secondPositionCheck = true;
                }

                if(firstPositionCheck == true && secondPositionCheck == true) {
                    System.out.println("Match NOT For: " + password + " min: " + minimumNumber + ", max: " + maximumNumber + " letter To Match: " + letterToMatch);
                } else if(firstPositionCheck == true || secondPositionCheck == true) {
                    System.out.println("***Match Found For: " + password + " min: " + minimumNumber + ", max: " + maximumNumber + " letter To Match: " + letterToMatch + " index: " + i + "***");
                    numberOfValidPasswords += 1;
                }
            }
            System.out.println(numberOfValidPasswords);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
