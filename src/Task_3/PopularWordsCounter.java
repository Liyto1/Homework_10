package Task_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PopularWordsCounter {
    private File file = new File("C:\\Users\\Lev\\Desktop\\words.txt");


    public void countPopularWords() {
        try (FileReader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            Map<String, Integer> wordFrequencyMap = new HashMap<>();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }

            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFrequencyMap.entrySet());
            sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            for (Map.Entry<String, Integer> entry : sortedList) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
