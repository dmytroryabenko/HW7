package HW7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class StringTextKateryna {

    public static void main(String[] args) {
        String line;
        ArrayList<String> text = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/HW7/Kateryna"));
            while ((line = br.readLine()) != null) {
                String words = "";
                for (int i = 0; i < line.length(); i++) {
                    if ((isLetter(line.charAt(i)))) {
                        words += line.charAt(i);
                    } else if (words.length() > 0) {
                        text.add(words.toLowerCase());
                        words = "";
                    }
                }
                if (words.length() > 0) {
                    text.add(words.toLowerCase());
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }
        String longestWordInPoem = longestWordInPoem(text);
        int countLongestInPoem = numberInText(text, longestWordInPoem);
        String shortestWordInPoem = shortestWordInPoem(text);
        int countShortestWordInPoem = numberInText(text, shortestWordInPoem);

        System.out.println("Longest word in Kateryna: " + longestWordInPoem);
        System.out.println("Count of longest words in poem: " + countLongestInPoem);
        System.out.println("===================================");
        System.out.println("Shortest word in Kateryna: " + shortestWordInPoem);
        System.out.println("Count of shortest words in poem: " + countShortestWordInPoem);
        System.out.println("===================================");
    }
    private static int numberInText(ArrayList<String> text, String word) {
        int count = 0;
        for (String w : text) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }
    private static String longestWordSortInPoem(String longestWord, ArrayList<String> text) {

        ArrayList<String> forLongestWordInPoem = new ArrayList<>();
        for (String w : text) {
            if (w.length() == longestWord.length()) {
                forLongestWordInPoem.add(w);
            }
        }
        String[] a = new String[forLongestWordInPoem.size()];
        System.arraycopy(forLongestWordInPoem.toArray(), 0, a, 0, a.length);
        Arrays.sort(a);
        return a[a.length - 1];
    }
    private static String longestWordInPoem(ArrayList<String> text) {
        String longestWordInPoem = text.get(0);
        for (String word : text) {

            if (word.length() > longestWordInPoem.length()) {
                longestWordInPoem = word;
            } else if (word.length() == longestWordInPoem.length()) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) > longestWordInPoem.charAt(i)) {
                        longestWordInPoem = word;
                        break;
                    }
                }
            }
        }
        longestWordInPoem = longestWordSortInPoem(longestWordInPoem, text);
        return longestWordInPoem;
    }
    private static String shortestWordSort(String shortestWord, ArrayList<String> text) {

        ArrayList<String> forShortestWordInPoem = new ArrayList<>();
        for (String w : text) {
            if (w.length() == shortestWord.length()) {
                forShortestWordInPoem.add(w);
            }
        }
        String[] a = new String[forShortestWordInPoem.size()];
        System.arraycopy(forShortestWordInPoem.toArray(), 0, a, 0, a.length);
        Arrays.sort(a);
        return a[0];
    }
    private static String shortestWordInPoem(ArrayList<String> text) {
        String shortestWord = text.get(0);
        for (String word : text) {
            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            } else if (word.length() == shortestWord.length()) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) > shortestWord.charAt(i)) {
                        shortestWord = word;
                        break;
                    }
                }
            }
        }
        shortestWord = shortestWordSort(shortestWord, text);
        return shortestWord;
    }
    private static boolean isLetter(char ch) {
        if ((ch != ' ') && (ch != ',') && (ch != '—') && (!isPunctuation(ch)) && (!isDigit(ch))) {
            return true;
        }
        return false;
    }
    private static boolean isDigit(char ch) {
        int zeroChar = 48;
        int nineChar = 57;
        if ((ch >= zeroChar) && (ch <= nineChar)) {
            return true;
        }
        return false;
    }
    private static boolean isPunctuation(char ch) {
        int punctChar = 58;
        int punct1Char = 63;
        int punct2Char = 33;
        int punct3Char = 47;
        if (((ch >= punctChar) && (ch <= punct1Char)) ||
                ((ch >= punct2Char) && (ch <= punct3Char))) {
            return true;
        }
        return false;
    }
}
