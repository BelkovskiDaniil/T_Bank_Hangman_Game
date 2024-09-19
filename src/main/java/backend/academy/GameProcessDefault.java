package backend.academy;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;
import static backend.academy.ConstantsGallows.ATTEMPTS_FOR_CURRENT_GAME;
import static backend.academy.ConstantsGallows.GAME_LOOSE;
import static backend.academy.ConstantsGallows.GAME_WIN;
import static backend.academy.ConstantsGallows.HINT_COMMAND;
import static backend.academy.ConstantsGallows.containsInAlpabet;

@Getter
@Setter
public class GameProcessDefault implements GameProcess {
    String word = "";
    int theme = 1;
    int level = 1;
    int gameStatus = 0;
    Gallows gallow = new Gallows();
    Word wordSecret;
    Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    String hint = "";
    int currentLives = ATTEMPTS_FOR_CURRENT_GAME;
    String input = "";

    public GameProcessDefault(String word, int theme, int level) {
        this.word = word;
        this.theme = theme;
        this.level = level;
        this.wordSecret = new Word(word);
    }

    @Override
    @SuppressWarnings("squid:S106")
    public void gameWin() {
        // CHECKSTYLE:OFF
        wordSecret.clearUsedLetters();
        gallow.print();
        wordSecret.print();
        System.out.println("""
                    Your are lucky winner!\n""");
        gameStatus = GAME_WIN;
        // CHECKSTYLE:ON
    }

    @Override
    @SuppressWarnings("squid:S106")
    public void gameLose() {
        // CHECKSTYLE:OFF
        wordSecret.clearUsedLetters();
        gallow.print();
        wordSecret.print();
        System.out.println("""
                    Your are loose, maybe next time!""");
        wordSecret.makeClear();
        System.out.println("\nAnswer was:");
        wordSecret.print();
        gameStatus = GAME_LOOSE;
        // CHECKSTYLE:ON
    }

    @Override
    @SuppressWarnings("squid:S106")
    public int[] gameProcess() {
        while (true) {
            // CHECKSTYLE:OFF
            System.out.println("\nYou have " + gallow.attempts() + " lives");
            // CHECKSTYLE:ON
            gallow.print();
            if (!hint.isEmpty()) {
                // CHECKSTYLE:OFF
                System.out.println("Your hint: " + hint + "\n");
                // CHECKSTYLE:ON
            }
            wordSecret.print();
            //Ожидание корректного ввода
            while (true) {
                // CHECKSTYLE:OFF
                System.out.println("Choose your letter! If you need a hint, enter \"?\" and lose one life!");
                input = scanner.nextLine().toLowerCase();
                if (containsInAlpabet(input)) {
                    if (!wordSecret.isLetterUsed(input)) {
                        break;
                    }
                    System.out.println("\nSymbol has already been used");
                }
                System.out.println("\nIncorrect input\n");
                // CHECKSTYLE:ON
            }

            if (!wordSecret.letterCheck(input)) {
                gallow.add();
                currentLives -= 1;
            }
            //Вызов подсказки
            if (HINT_COMMAND.equals(input)) {
                // CHECKSTYLE:OFF
                hint = Dictionary.getHint(theme, level, wordSecret.word());
                // CHECKSTYLE:ON
            }
            if (wordSecret.isClear()) {
                gameWin();
                break;
            } else if (gallow.attempts() <= 0) {
                gameLose();
                break;
            }
        }
        return new int[] {gameStatus, currentLives};
    }
}
