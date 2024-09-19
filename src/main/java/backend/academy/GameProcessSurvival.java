package backend.academy;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import static backend.academy.ConstantsGallows.ATTEMPTS_FOR_CURRENT_GAME;
import static backend.academy.ConstantsGallows.GAME_LOOSE;
import static backend.academy.ConstantsGallows.GAME_NEXT_LEVEL;
import static backend.academy.ConstantsGallows.HINT_COMMAND;
import static backend.academy.ConstantsGallows.containsInAlpabet;

public class GameProcessSurvival implements GameProcess {
    int theme = 1;
    int level = 1;
    int gameStatus = 0;
    Gallows gallow = new Gallows();
    Word wordSecret;
    Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    String hint = "";
    int currentLives = ATTEMPTS_FOR_CURRENT_GAME;
    String input = "";

    public GameProcessSurvival(String word, int theme, int level, int currentLives) {
        this.theme = theme;
        this.level = level;
        this.wordSecret = new Word(word);
        this.currentLives = currentLives;
    }

    @Override
    @SuppressWarnings("squid:S106")
    public void gameWin() {
        // CHECKSTYLE:OFF
        wordSecret.clearUsedLetters();
        gallow.print();
        wordSecret.print();
        System.out.println("""
                    Next level!""");
        gameStatus = GAME_NEXT_LEVEL;
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
                    Your are loose, good result!""");
        wordSecret.makeClear();
        System.out.println("\nAnswer was:");
        wordSecret.print();
        gameStatus = GAME_LOOSE;
        // CHECKSTYLE:ON
    }

    @Override
    @SuppressWarnings("squid:S106")
    public int[] gameProcess() {
        if (currentLives < ATTEMPTS_FOR_CURRENT_GAME) {
            for (int i = 0; i < (ATTEMPTS_FOR_CURRENT_GAME - currentLives); i++) {
                gallow.add();
            }
        }

        // NOPMD - CPD-OFF
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
                currentLives -= 1;
                gallow.add();
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
        // NOPMD - CPD-ON

        return new int[] {gameStatus, currentLives};
    }
}
