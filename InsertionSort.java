package com.bridgelabz.assignment;

public class InsertionSort
{
    public static void insertionSort(String[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            String key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void printArray(String[] arr) {
        for (String element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] words = { "banana", "apple", "orange", "grape", "kiwi" };

        System.out.println("Array before sorting:");
        printArray(words);

        insertionSort(words);

        System.out.println("Array after sorting:");
        printArray(words);
    }
}
