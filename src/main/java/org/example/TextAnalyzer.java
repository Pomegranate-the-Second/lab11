package org.example;

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

    public static void printStatistics(TextStats stats) {
        System.out.println("Статистика текста:");
        System.out.println("Количество строк: " + stats.lineCount());
        System.out.println("Количество слов: " + stats.wordCount());
        System.out.println("Количество символов: " + stats.charCount());
    }
}