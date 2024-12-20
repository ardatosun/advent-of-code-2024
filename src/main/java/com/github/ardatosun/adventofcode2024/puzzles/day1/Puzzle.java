package com.github.ardatosun.adventofcode2024.puzzles.day1;

import com.github.ardatosun.adventofcode2024.puzzles.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Puzzle {
    public static void main(String[] args) {
        String fileName = "day1/Puzzle.txt";
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        try (BufferedReader reader = Utils.getResourceFileReader(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+");
                int left = Integer.parseInt(numbers[0]);
                int right = Integer.parseInt(numbers[1]);
                leftList.add(left);
                rightList.add(right);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        ArrayList<Integer> sortedLeft = new ArrayList<>(leftList);
        ArrayList<Integer> sortedRight = new ArrayList<>(rightList);
        Collections.sort(sortedLeft);
        Collections.sort(sortedRight);

        int totalDistance = 0;
        for (int i = 0; i < sortedLeft.size(); i++) {
            totalDistance += Math.abs(sortedLeft.get(i) - sortedRight.get(i));
        }
        System.out.println("The total distance is: " + totalDistance); // 1580061

        HashMap<Integer, Integer> rightListCounts = new HashMap<>();
        for (int num : rightList) {
            rightListCounts.put(num, rightListCounts.getOrDefault(num, 0) + 1);
        }
        int similarityScore = 0;
        for (int num : leftList) {
            int countInRightList = rightListCounts.getOrDefault(num, 0);
            similarityScore += num * countInRightList;
        }

        System.out.println("The similarity score is: " + similarityScore); // 23046913
    }
}
