package com.github.ardatosun.adventofcode2024.puzzles;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {
    public static BufferedReader getResourceFileReader(String resourcePath) {
        InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
        if (resourceStream == null) {
            throw new IllegalArgumentException("Resource not found: " + resourcePath);
        }
        return new BufferedReader(new InputStreamReader(resourceStream));
    }
}
