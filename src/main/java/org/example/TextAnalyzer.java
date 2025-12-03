package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TextAnalyzer {

    public static TextStats countStatistics(String text) {
        String[] lines = text.split("\n");
        int lineCount = lines.length;

        // Подсчет слов: более простой и понятный способ
        int wordCount = 0;
        boolean inWord = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                if (!inWord) {
                    wordCount++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        int charCount = text.length();

        return new TextStats(lineCount, wordCount, charCount);
    }

    public static void printStatistics(TextStats stats, Path outputPath) {

        // Формируем строку со статистикой
        String statistics = "Статистика текста:\n" +
                "Количество строк: " + stats.lineCount() + "\n" +
                "Количество слов: " + stats.wordCount() + "\n" +
                "Количество символов: " + stats.charCount() + "\n";

        // Вывод в консоль
        System.out.print(statistics);

        // Вывод в файл, если указан путь
        if (outputPath != null) {
            try {
                // Создаем директории, если они не существуют
                if (outputPath.getParent() != null) {
                    Files.createDirectories(outputPath.getParent());
                }

                // Записываем в файл (перезаписываем существующий файл)
                Files.writeString(outputPath, statistics,
                        StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING,
                        StandardOpenOption.WRITE);

                System.out.println("Статистика сохранена в файл: " + outputPath.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл " + outputPath + ": " + e.getMessage());
            }
        }
    }

}