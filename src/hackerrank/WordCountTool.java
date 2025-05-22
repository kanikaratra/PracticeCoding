package hackerrank;

public class WordCountTool {

    public static void main(String[] args) {
        System.out.println(countValidWords("This is form16 submiss$ion date"));
    }
    public static int countValidWords(String s) {
        String[] words = s.split("\\s+"); // Split by whitespace
        int count = 0;

        for (String word : words) {
            if (isValidWord(word)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isValidWord(String word) {
        if (word.length() < 3) return false; // Must be at least 3 characters

        boolean hasVowel = false, hasConsonant = false;

        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) return false; // Only alphanumeric characters

            if (isVowel(ch)) hasVowel = true;
            else if (Character.isLetter(ch)) hasConsonant = true;
        }

        return hasVowel && hasConsonant; // Must contain at least one vowel and one consonant
    }

    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return "aeiou".indexOf(ch) != -1;
    }

}