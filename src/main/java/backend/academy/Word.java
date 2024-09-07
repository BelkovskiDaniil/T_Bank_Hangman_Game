package backend.academy;

import lombok.Getter;
import java.util.Arrays;

@Getter public class Word {
    private String word = "";
    private final char[] secretWord;

    public Word(String word) {
        this.word = word;
        this.secretWord = new char[word.length()];
        Arrays.fill(this.secretWord, '_');
    }

    //Проверка наличия буквы в слове
    public boolean letterCheck(String letter) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).equals(letter)) {
                secretWord[i] = letter.charAt(0);
                found = true;
            }
        }
        return found;
    }

    public void print() {
        StringBuilder answer = new StringBuilder();
        for (char c : secretWord) {
            answer.append(c).append(" ");
        }
        System.out.println(answer);
        System.out.println();
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
}

