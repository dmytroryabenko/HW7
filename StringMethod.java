package HW7;

public class StringMethod {

        public static void main(String[] args) {

            String str = "In God We Trust 1957";
            System.out.println("=====================================");
            System.out.println("Our main string: " + str);
            System.out.println("===========================");
            int countLetterInString = 0;
            int countSpacesInString = 0;
            int countDigitsInString = 0;
            int countPunctuationInString = 0;
            int countDoublesInString = 0;
            str = str.toLowerCase();

            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                for (int j = 0; j < str.length(); j++) {
                    if (ch[i] == str.charAt(j)) {
                        countDoublesInString++;
                    }
                }
                System.out.println("This char " + ch[i] + " happens " + countDoublesInString + " times");
                countDoublesInString = 0;
            }
            System.out.println("===========================");
            for (int i = 0; i < str.length(); i++) {
                if (isLetter(str.charAt(i))) {
                    countLetterInString++;
                } else if (str.charAt(i) == ' ') {
                    countSpacesInString++;
                } else if (isDigit(str.charAt(i))) {
                    countDigitsInString++;
                } else if (isPunctuation(str.charAt(i))) {
                    countPunctuationInString++;
                }
            }
            System.out.println("Count of letters in our main string: " + countLetterInString);
            System.out.println("Count of spaces in our main string: " + countSpacesInString);
            System.out.println("Count of digits in our main string: " + countDigitsInString);
            System.out.println("Count of punctuations in our main string: " + countPunctuationInString);
            System.out.println("===========================================");
        }
        private static boolean isLetter(char ch) {
            if ((ch != ' ') && (ch != '-') && (ch != ',') && (ch != '.') && (ch != '!') && (!isDigit(ch))) {
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
            int punctuationChar = 59;
            int punctuation1Char = 63;
            int punctuation2Char = 34;
            int punctuation3Char = 47;
            if (((ch >= punctuationChar) && (ch <= punctuation1Char)) ||
                    ((ch >= punctuation2Char) && (ch <= punctuation3Char))) {
                return true;
            }
            return false;
        }
    }
