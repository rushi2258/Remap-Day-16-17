package com.bridgelabz.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations
{
    public static List<String> getPermutationsIterative(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(String.valueOf(str.charAt(0)));

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            List<String> newPermutations = new ArrayList<>();

            for (String permutation : permutations) {
                for (int j = 0; j <= permutation.length(); j++) {
                    String newPermutation = permutation.substring(0, j) + currentChar + permutation.substring(j);
                    newPermutations.add(newPermutation);
                }
            }

            permutations = newPermutations;
        }

        return permutations;
    }

    public static List<String> getPermutationsRecursive(String str) {
        List<String> permutations = new ArrayList<>();

        if (str.length() == 1) {
            permutations.add(str);
        } else {
            char firstChar = str.charAt(0);
            String remainingString = str.substring(1);
            List<String> previousPermutations = getPermutationsRecursive(remainingString);

            for (String permutation : previousPermutations) {
                for (int i = 0; i <= permutation.length(); i++) {
                    String newPermutation = permutation.substring(0, i) + firstChar + permutation.substring(i);
                    permutations.add(newPermutation);
                }
            }
        }

        return permutations;
    }

    public static void main(String[] args) {
        String input = "abc";

        List<String> iterativePermutations = getPermutationsIterative(input);
        List<String> recursivePermutations = getPermutationsRecursive(input);

        System.out.println("Iterative Permutations: " + iterativePermutations);
        System.out.println("Recursive Permutations: " + recursivePermutations);

        boolean areEqual = Arrays.equals(iterativePermutations.toArray(), recursivePermutations.toArray());
        System.out.println("Permutations are equal: " + areEqual);
    }
}
