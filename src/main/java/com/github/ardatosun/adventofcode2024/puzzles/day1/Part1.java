package com.github.ardatosun.adventofcode2024.puzzles.day1;

import com.github.ardatosun.adventofcode2024.puzzles.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Part1 {
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

        Collections.sort(leftList);
        Collections.sort(rightList);

        int totalDistance = 0;
        for (int i = 0; i < leftList.size(); i++) {
            totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
        }

        System.out.println("The total distance is: " + totalDistance); // 1580061
    }
}
