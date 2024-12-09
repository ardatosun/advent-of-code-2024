package com.github.ardatosun.adventofcode2024.puzzles.day2;

import com.github.ardatosun.adventofcode2024.puzzles.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Puzzle {
    public static void main(String[] args) {
        String fileName = "day2/Puzzle.txt";
        int initialSafeReports = 0;
        int finalSafeReports = 0;

        try (BufferedReader reader = Utils.getResourceFileReader(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] levels = line.trim().split("\\s+");
                ArrayList<Integer> reportLevels = new ArrayList<>();
                for (String level : levels) {
                    reportLevels.add(Integer.parseInt(level));
                }

                if (isReportSafe(reportLevels)) {
                    initialSafeReports++;
                    finalSafeReports++;
                } else {
                    boolean isSafeWithRemoval = false;
                    for (int i = 0; i < reportLevels.size(); i++) {
                        ArrayList<Integer> modifiedLevels = new ArrayList<>(reportLevels);
                        modifiedLevels.remove(i);
                        if (isReportSafe(modifiedLevels)) {
                            isSafeWithRemoval = true;
                            break;
                        }
                    }

                    if (isSafeWithRemoval) {
                        finalSafeReports++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        System.out.println("Number of safe reports initially: " + initialSafeReports); // 230
        System.out.println("Number of safe reports with removal: " + finalSafeReports); // 301
    }

    private static boolean isReportSafe(ArrayList<Integer> levels) {
        boolean isIncreasing = false;
        boolean isDecreasing = false;

        for (int i = 0; i < levels.size() - 1; i++) {
            int currentLevel = levels.get(i);
            int nextLevel = levels.get(i + 1);
            int difference = nextLevel - currentLevel;

            if (Math.abs(difference) < 1 || Math.abs(difference) > 3) {
                return false;
            }

            if (difference > 0) {
                isIncreasing = true;
            } else if (difference < 0) {
                isDecreasing = true;
            }

            if (isIncreasing && isDecreasing) {
                return false;
            }
        }
        return true;
    }
}
