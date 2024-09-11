package backend.academy;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.List;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;
import static backend.academy.ConstantsGallows.EASY_DIFFICULT;
import static backend.academy.ConstantsGallows.HARD_DIFFICULT;
import static backend.academy.ConstantsGallows.MIN_AVAILABLE_ATTEMPTS;

@Getter
@Setter
public class GameInterface {
    boolean cycleKey = true;
    Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    private static final SecureRandom RANDOM = new SecureRandom();

    @SuppressWarnings("squid:S106")
    public void gameStart() {
        boolean shoudIUpdate = true;
        int theme = 1;
        int difficult = 1;
        String input = "";
        while (cycleKey) {
            //Проверка корректности количества попыток
            if (ConstantsGallows.ATTEMPTS_FOR_CURRENT_GAME < MIN_AVAILABLE_ATTEMPTS) {
                // CHECKSTYLE:OFF
                System.out.println("""
                    \nIncorrect number of attempts! (Should be more than 5)""");
                break;
                // CHECKSTYLE:ON
            }
            //Проверка, нужно ли обновить данные при перезапуске игры
            if (shoudIUpdate) {
                // Fetch all available themes
                List<String> allThemes = Dictionary.getAllThemes();

                // Display available themes dynamically
                // CHECKSTYLE:OFF
                System.out.println("\nChoose theme of words");
                System.out.println("Enter number of them (if incorrect input, we will use random)");

                for (int i = 0; i < allThemes.size(); i++) {
                    System.out.println((i + 1) + ". " + allThemes.get(i));
                }
                // CHECKSTYLE:ON

                input = scanner.nextLine();

                try {
                    theme = Integer.parseInt(input) - 1; // Adjusting to zero-based index
                    if (theme < 0 || theme >= allThemes.size()) {
                        theme = RANDOM.nextInt(allThemes.size()); // Random theme if input is out of range
                    }
                } catch (NumberFormatException e) {
                    theme = RANDOM.nextInt(allThemes.size()); // Random theme if input is not a number
                }

                // Display difficulty levels dynamically
                // CHECKSTYLE:OFF
                System.out.println("\nChoose difficulty of words");
                System.out.println("Enter number of them (if incorrect input, we will use random)");
                System.out.println("1. Easy");
                System.out.println("2. Medium");
                System.out.println("3. Hard");
                // CHECKSTYLE:ON

                input = scanner.nextLine();

                try {
                    difficult = Integer.parseInt(input); // Difficulty starts from 1
                    if (difficult < EASY_DIFFICULT || difficult > HARD_DIFFICULT) {
                        difficult = RANDOM.nextInt(HARD_DIFFICULT) + 1; // Random difficulty if input is out of range
                    }
                } catch (NumberFormatException e) {
                    difficult = RANDOM.nextInt(HARD_DIFFICULT) + 1; // Random difficulty if input is not a number
                }
            }

            GameProcess gameProcess = new GameProcess(Dictionary.getWord(theme, difficult), theme, difficult);
            gameProcess.gameProcess();

            // CHECKSTYLE:OFF
            System.out.println("""
                Wanna play one more time?
                Enter number of them (if incorrect input, we will finish session)
                1. Yeah
                2. Nope""");
            // CHECKSTYLE:ON

            input = scanner.nextLine();
            if (!"1".equals(input)) {
                // CHECKSTYLE:OFF
                System.out.println("""
                \nThanks for game""");
                break;
                // CHECKSTYLE:ON
            }

            // CHECKSTYLE:OFF
            System.out.println("""
                \nUpdate settings?
                Enter number of them (if incorrect input, we will don't change settings)
                1. Yeah
                2. Nope""");
            // CHECKSTYLE:ON

            input = scanner.nextLine();
            shoudIUpdate = "1".equals(input);
        }
    }
}
