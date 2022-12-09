package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTwoPartOne {

    public static void main(final String args[]) {
        List<String> passwords = new ArrayList<>();

        try {
            String stringCurrentLine;
            String minimumNumber;
            String maximumNumber;
            String letterToMatch;
            String password;
            String regex;
            int numberOfValidPasswords = 0;
            BufferedReader objReader = null;

            objReader = new BufferedReader(new FileReader("src/main/resources/input.txt"));

            while ((stringCurrentLine = objReader.readLine()) != null) {
                passwords.add(stringCurrentLine);
            }

            for(int i = 0; i < passwords.size(); i++) {

                String[] parts = passwords.get(i).split("[ :-]");
                minimumNumber = parts[0];
                maximumNumber = parts[1];
                letterToMatch = parts[2];
                password = parts[4];

                List<String> characters = List.of(password.split(""));
                StringBuilder remainingCharacters = new StringBuilder();

                for (int j = 0; j < characters.size(); j++) {
                    if (characters.get(j).equalsIgnoreCase(letterToMatch)) {
                        remainingCharacters.append(characters.get(j));
                    }
                }
                regex = "^" + letterToMatch + "{" + minimumNumber + "," + maximumNumber + "}$";
                Pattern pattern = Pattern.compile(regex);

                Matcher matcher = pattern.matcher(remainingCharacters);
                boolean wasMatchFound = matcher.find();
                if (wasMatchFound) {
                    numberOfValidPasswords += 1;
                    System.out.println("***Match Found For: " + password + " min: " + minimumNumber + ", max: " + maximumNumber + " letter To Match: " + letterToMatch + " index: " + i + "***");
                } else {
                    System.out.println("Match NOT For: " + password + "**min: " + minimumNumber + ", max: " + maximumNumber + " letter To Match: " + letterToMatch);
                }
            }
            System.out.println("Number of Valid Passwords: " + numberOfValidPasswords);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
