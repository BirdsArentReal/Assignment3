package com.example.assignment3;

import java.util.HashMap;

public class LazyDatabase {
    static String speechText = "REEEEEEEEEEEEEEEEEEE";

    public static void setSpeechText(String speechText) {
        LazyDatabase.speechText = speechText;
    }

    public static String countNumberOfWords(){
        if (!speechText.matches(".*\\w.*")){
            return "You fool! There are no words!";
        }
        else {
            int no_words = speechText.split(" ").length;
            String output = no_words+"";
            return output;
        }
    }

    //    placement 1 = most occuring, 2 = 2nd most, etc.
    public static String countMostOccuring(int placement){
        if (!speechText.matches(".*\\w.*")){
            return "You fool! There are no words!";
        }

        String[] words = speechText.split(" ");
        HashMap<String, Integer> word_count = new HashMap<>();
        for (String i: words){
            if (word_count.containsKey(i)){
                int temp = word_count.get(i);
                word_count.remove(i);
                word_count.put(i, temp + 1);
            }
            else{
                word_count.put(i, 1);
            }
        }

        return something(word_count, placement);

    }

    private static String something(HashMap<String, Integer> wordMap, int placement) {
        if (wordMap.size() < placement){
            return "You fool! There are too few words!";
        }

        String keyMax = "";
        int valMax = 0;

        for (String i: wordMap.keySet()) {
            if (wordMap.get(i) > valMax) {
                keyMax = i;
                valMax = wordMap.get(i);
            }
        }

        if (placement > 1) {
            wordMap.remove(keyMax);
            return something(wordMap, placement - 1);
        }
        if (placement == 1) {
            return keyMax + " (" + valMax + ")";
        }
        else {
            return "Something is wrong here";
        }
    }

}
