package Map;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapHomework {

    static Scanner scanner = new Scanner(System.in);
    static Map<String, Integer> map = new TreeMap<>();


    public static void main(String[] args) {
//        wordsCount();
//        checkUniqueNameAndSameName();

    }

    public static void wordsCount() {
        System.out.print("Enter words: ");
        String words = scanner.nextLine();
        String[] wordArray = words.split("\\s+");
        for (String word : wordArray) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        printMap();
    }

    public static void checkUniqueNameAndSameName() {
        System.out.print("Enter number of names need add: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            String names = scanner.nextLine();
            if (map.containsKey(names)) {
                map.put(names, map.get(names) + 1);
            } else {
                map.put(names, 1);
            }
        }
        System.out.println("Unique names: ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
        System.out.println("Same names: ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void printMap() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
