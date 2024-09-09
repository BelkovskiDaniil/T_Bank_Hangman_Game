package backend.academy;

import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;
import static backend.academy.ConstantsGallows.containsInAlpabet;

@Getter @Setter public class GameProcess {
    String word = "";
    int theme = 1;
    int level = 1;
    int gameStatus = 0;
    Gallows gallow = new Gallows();
    Word wordSecret;
    Scanner scanner = new Scanner(System.in);

    public GameProcess(String word, int theme, int level) {
        this.word = word;
        this.theme = theme;
        this.level = level;
        this.wordSecret = new Word(word);
    }

    @SuppressWarnings("squid:S106")
    public void gameWin() {
        // CHECKSTYLE:OFF
        gallow.print();
        wordSecret.print();
        System.out.println("""
                    Your are lucky winner!""");
        gameStatus = 1;
        // CHECKSTYLE:ON
    }

    @SuppressWarnings("squid:S106")
    public void gameLose() {
        // CHECKSTYLE:OFF
        gallow.print();
        wordSecret.print();
        System.out.println("""
                    Your are loose, maybe next time!""");
        gameStatus = 2;
        // CHECKSTYLE:ON
    }

    @SuppressWarnings("squid:S106")
    public void gameProcess() {
        String input = "";
        while (true) {
            // CHECKSTYLE:OFF
            System.out.println("\nYou have " + gallow.attempts() + " lives");
            // CHECKSTYLE:ON
            gallow.print();
            wordSecret.print();
            //Ожидание корректного ввода
            while (true) {
                // CHECKSTYLE:OFF
                System.out.println("Choose your letter! If you need a hint, enter \"?\" and lose one life!");
                input = scanner.nextLine().toLowerCase();
                if (containsInAlpabet(input)) {
                    break;
                }
                System.out.println("\nIncorrect input");
                // CHECKSTYLE:ON
            }

            if (!wordSecret.letterCheck(input)) {
                gallow.add();
            }
            //Вызов подсказки
            if (input.equals("?")) {
                // CHECKSTYLE:OFF
                System.out.println("\nYour hint: " + Dictionary.getHint(theme, level, wordSecret.word()));
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
    }
}
