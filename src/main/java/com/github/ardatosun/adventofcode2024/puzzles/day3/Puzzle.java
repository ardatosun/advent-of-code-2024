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
        Pattern mulPattern = Pattern.compile(mulRegex);

        try (BufferedReader reader = Utils.getResourceFileReader(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.append(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        int totalSum = 0;
        Matcher matcher = mulPattern.matcher(input.toString());
        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            totalSum += x * y;
        }
        System.out.println("The total sum of all valid mul instructions is: " + totalSum); // 165225049
    }
}
