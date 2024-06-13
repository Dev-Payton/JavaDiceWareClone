package com.devpayton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class PasswordCreator {
    private int passwordLength = 0;

    public PasswordCreator(int passwordLength) {
        this.passwordLength = passwordLength;
        parseWordList();
    }

    private void parseWordList() {
        File wordlist = new File("src/main/resources/wordlist.txt");
        Map<Integer, String> formattedWords = new HashMap<>();
        Scanner lineScanner = null;
        try {
            lineScanner = new Scanner(wordlist);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (lineScanner.hasNextLine()) {
            String currentLine = lineScanner.nextLine();
            Scanner currentToken = new Scanner(currentLine);

            int currentInteger = Integer.parseInt(currentLine.substring(0, 5).trim());
            String currentWord = currentLine.substring(5).trim();
            formattedWords.put(currentInteger, currentWord);
        }
        createPassphrase(formattedWords);
    }

    public void createPassphrase(Map formattedWords) {
        StringBuilder entirePassPhrase = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            String currentWord = (String) formattedWords.get(generateDiceRolls());
            entirePassPhrase.append(currentWord.substring(0,1).toUpperCase() + currentWord.substring(1));
        }
        System.out.println("Passphrase: " + entirePassPhrase.toString());
    }

    public int generateDiceRolls() {
        Random random = new Random();
        StringBuilder randomNumber = new StringBuilder();
        for(int i = 0; i < 5; i++){
            randomNumber.append((int)((Math.random() * 6) + 1));
        }
        return Integer.parseInt(randomNumber.toString());


    }
}
