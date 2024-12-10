package com.github.ardatosun.adventofcode2024.puzzles.day3;

import com.github.ardatosun.adventofcode2024.puzzles.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle {
    public static void main(String[] args) {
        String fileName = "day3/Puzzle.txt";
        StringBuilder input = new StringBuilder();
        String mulRegex = "mul\\((\\d+),(\\d+)\\)";
        String toggleRegex = "do\\(\\)|don't\\(\\)";
        Pattern mulPattern = Pattern.compile(mulRegex);
        Pattern togglePattern = Pattern.compile(toggleRegex);

        try (BufferedReader reader = Utils.getResourceFileReader(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.append(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        int currentIndex = 0;
        boolean isEnabled = true;
        int totalSum = 0;
        int totalSumEnabled = 0;
        Matcher mulMatcher = mulPattern.matcher(input.toString());
        Matcher toggleMatcher = togglePattern.matcher(input.toString());
        while (mulMatcher.find()) {
            int x = Integer.parseInt(mulMatcher.group(1));
            int y = Integer.parseInt(mulMatcher.group(2));
            totalSum += x * y;

            while (toggleMatcher.find(currentIndex) && toggleMatcher.start() < mulMatcher.start()) {
                String toggle = toggleMatcher.group();
                if (toggle.equals("do()")) {
                    isEnabled = true;
                } else if (toggle.equals("don't()")) {
                    isEnabled = false;
                }
                currentIndex = toggleMatcher.end();
            }
            if (isEnabled) {
                totalSumEnabled += x * y;
            }
        }
        System.out.println("The total sum of all valid mul instructions is: " + totalSum); // 165225049
        System.out.println("The total sum of all valid and enabled mul instructions is: " + totalSumEnabled); // 108830766
    }
}
