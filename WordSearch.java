package com.bridgelabz.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class WordSearch
{
    public static boolean binarySearchWord(String[] words, String searchWord) {
        Arrays.sort(words);

        int left = 0;
        int right = words.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = searchWord.compareTo(words[mid]);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String filePath = "word_list.txt";
        String searchWord = "example";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            String[] words = sb.toString().split(",");

            if (binarySearchWord(words, searchWord)) {
                System.out.println("The word '" + searchWord + "' is found in the list.");
            } else {
                System.out.println("The word '" + searchWord + "' is not found in the list.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
