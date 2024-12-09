package com.github.ardatosun.adventofcode2024.puzzles.day2;

import com.github.ardatosun.adventofcode2024.puzzles.Utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) {
        String fileName = "day2/Puzzle.txt";
        int safeReports = 0;

        try (BufferedReader reader = Utils.getResourceFileReader(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                boolean isIncreasing = false;
                boolean isDecreasing = false;
                boolean isSafe = true;
                String[] levels = line.trim().split("\\s+");
                for (int i=0; i < levels.length - 1; i++) {
                    int currentLevel = Integer.parseInt(levels[i]);
                    int nextLevel = Integer.parseInt(levels[i + 1]);
                    int difference = nextLevel - currentLevel;

                    if (Math.abs(difference) < 1 || Math.abs(difference) > 3) {
                        isSafe = false;
                        break;
                    }
                    if (difference > 0) {
                        isIncreasing = true;
                    } else if (difference < 0) {
                        isDecreasing = true;
                    }
                    if (isIncreasing && isDecreasing) {
                        isSafe = false;
                        break;
                    }
                }
                if (isSafe) {
                    safeReports++;
                }

            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        System.out.println("Number of safe reports is: " + safeReports); // 230
    }
}
