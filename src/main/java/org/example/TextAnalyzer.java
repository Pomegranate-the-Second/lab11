package org.example;

public class TextAnalyzer {

    public static TextStats countStatistics(String text) {

        String[] lines = text.split("\n");

        int lineCount = lines.length;
        // Добавить подсчеты слов и символов в будущем
        int wordCount = 0;
        int charCount = 0;

        return new TextStats(lineCount, wordCount, charCount);
    }

    public static void printStatistics(TextStats stats) {
        System.out.println("Статистика текста:");
        System.out.println("Количество строк: " + stats.lineCount());
        System.out.println("Количество слов: " + stats.wordCount());
        System.out.println("Количество символов: " + stats.charCount());
    }
}