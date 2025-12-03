package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.example.TextAnalyzer.countStatistics;
import static org.example.TextAnalyzer.printStatistics;

public class Main {
    public static void main(String[] args) {
        try {
            String text = new String(Files.readAllBytes(Paths.get("input.txt")));
            Path outputPath = Paths.get("output.txt");

            TextStats stats = countStatistics(text);

            printStatistics(stats, outputPath);

        } catch (IOException e) {
            System.out.println("Ошибка: Файл input.txt не найден!");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
