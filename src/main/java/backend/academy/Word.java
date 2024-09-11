package backend.academy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

@Getter
public class Word {
    private String word = "";
    private final char[] secretWord;
    private final Set<String> usedLetters;

    public Word(String word) {
        this.word = word;
        this.secretWord = new char[word.length()];
        Arrays.fill(this.secretWord, '_');
        this.usedLetters = new HashSet<>();
    }

    //Проверка наличия буквы в слове
    public boolean letterCheck(String letter) {
        usedLetters.add(letter);
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).equals(letter)) {
                secretWord[i] = letter.charAt(0);
                found = true;
            }
        }
        return found;
    }

    @SuppressWarnings("squid:S106")
    public void print() {
        // CHECKSTYLE:OFF
        StringBuilder answer = new StringBuilder();
        for (char c : secretWord) {
            answer.append(c).append(' ');
        }
        System.out.println(answer);
        System.out.println();
        // CHECKSTYLE:ON
    }

    //Проверка, отгадано ли слово
    public boolean isClear() {
        boolean answer = true;
        for (char c : secretWord) {
            if (c == '_') {
                answer = false;
                break;
            }
        }
        return answer;
    }

    //Заполним слово
    public void makeClear() {
        for (int i = 0; i < word.length(); i++) {
            String letter = String.valueOf(word.charAt(i));
            letterCheck(letter);
        }
    }

    public boolean isLetterUsed(String letter) {
        return usedLetters.contains(letter);
    }

    public void clearUsedLetters() {
        usedLetters.clear();
    }
}

