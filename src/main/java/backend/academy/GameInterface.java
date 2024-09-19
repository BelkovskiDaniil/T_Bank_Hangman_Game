package backend.academy;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.List;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;
import static backend.academy.ConstantsGallows.ATTEMPTS_FOR_CURRENT_GAME;
import static backend.academy.ConstantsGallows.EASY_DIFFICULT;
import static backend.academy.ConstantsGallows.GAME_LOOSE;
import static backend.academy.ConstantsGallows.GAME_MODE_DEFAULT;
import static backend.academy.ConstantsGallows.GAME_MODE_SURVIVAL;
import static backend.academy.ConstantsGallows.GAME_WIN;
import static backend.academy.ConstantsGallows.HARD_DIFFICULT;
import static backend.academy.ConstantsGallows.MEDIUM_DIFFICULT;
import static backend.academy.ConstantsGallows.MIN_AVAILABLE_ATTEMPTS;


@Getter
@Setter
public class GameInterface {
    boolean cycleKey = true;
    Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    private static final SecureRandom RANDOM = new SecureRandom();
    boolean shoudIUpdate = true;
    int theme = 1;
    int difficult = EASY_DIFFICULT;
    int gameMode = GAME_MODE_DEFAULT;
    int levelsCounter = 0;
    int currentAttempts = ATTEMPTS_FOR_CURRENT_GAME;
    String input = "";
    UsersDB usersDB = new UsersDB();
    private static final int GAME_RESULT_INDEX = 0;
    private static final int CURRENT_ATTEMPTS_INDEX = 1;

    @SuppressWarnings("squid:S106")
    public void gameStart() {
        usersDB.connect();

        while (cycleKey) {
            levelsCounter = 0;
            //Проверка корректности количества попыток
            if (ATTEMPTS_FOR_CURRENT_GAME < MIN_AVAILABLE_ATTEMPTS) {
                // CHECKSTYLE:OFF
                System.out.println("""
                    \nIncorrect number of attempts! (Should be more than 5)""");
                break;
                // CHECKSTYLE:ON
            }
            //Проверка, нужно ли обновить данные при перезапуске игры
            if (shoudIUpdate) {
                updateSettings();
            }

            while (true) {
                GameProcess gameProcess;
                if (gameMode == GAME_MODE_SURVIVAL) {
                    gameProcess = new GameProcessSurvival(Dictionary.getWord(theme, difficult),
                        theme, difficult, currentAttempts);
                } else {
                    gameProcess = new GameProcessDefault(Dictionary.getWord(theme, difficult),
                        theme, difficult);
                }
                int[] gameResults = gameProcess.gameProcess();
                int gameResult = 0;
                for (int i = 0; i < gameResults.length; i++) {
                    if (i == GAME_RESULT_INDEX) {
                        gameResult = gameResults[i];
                    } else {
                        currentAttempts = gameResults[i];
                    }
                }
                if (gameResult == GAME_LOOSE || gameResult == GAME_WIN) {
                    break;
                } else if (gameMode == GAME_MODE_SURVIVAL) {
                    levelsCounter += 1;
                }
            }
            addToLeaderboard();
            if (!afterGame()) {
                break;
            }
        }
    }

    private void addToLeaderboard() {
        // CHECKSTYLE:OFF
        if (gameMode == GAME_MODE_SURVIVAL) {
            System.out.println("If you want to add your score to the leaderboard, enter a name (or skip)!");
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                String themeString = Dictionary.getAllThemes().get(theme);
                String difficultString = switch (difficult) {
                    case EASY_DIFFICULT -> "Easy";
                    case MEDIUM_DIFFICULT -> "Medium";
                    case HARD_DIFFICULT -> "Hard";
                    default -> "";
                };
                usersDB.addUser(input, levelsCounter, themeString, difficultString);
            }
        }
        // CHECKSTYLE:ON
    }

    private boolean afterGame() {
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
            return false;
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
        return true;
    }

    private void updateSettings() {
        while (true) {
            // CHECKSTYLE:OFF
            System.out.println("\nChoose game mode:");
            System.out.println("Enter number of them (if incorrect input, we will use default)");
            System.out.println("1. Default");
            System.out.println("2. Survival");
            System.out.println("3. See the table of leaders");
            // CHECKSTYLE:ON

            input = scanner.nextLine();

            if ("3".equals(input)) {
                usersDB.print();
            } else {
                break;
            }
        }

        try {
            gameMode = Integer.parseInt(input);
            if (difficult < GAME_MODE_DEFAULT || difficult > GAME_MODE_SURVIVAL) {
                gameMode = GAME_MODE_DEFAULT;
            }
        } catch (NumberFormatException e) {
            gameMode = GAME_MODE_DEFAULT;
        }

        List<String> allThemes = Dictionary.getAllThemes();

        // CHECKSTYLE:OFF
        System.out.println("\nChoose theme of words");
        System.out.println("Enter number of them (if incorrect input, we will use random)");

        for (int i = 0; i < allThemes.size(); i++) {
            System.out.println((i + 1) + ". " + allThemes.get(i));
        }
        // CHECKSTYLE:ON

        input = scanner.nextLine();

        try {
            theme = Integer.parseInt(input) - 1;
            if (theme < 0 || theme >= allThemes.size()) {
                theme = RANDOM.nextInt(allThemes.size());
            }
        } catch (NumberFormatException e) {
            theme = RANDOM.nextInt(allThemes.size());
        }

        // CHECKSTYLE:OFF
        System.out.println("\nChoose difficulty of words");
        System.out.println("Enter number of them (if incorrect input, we will use random)");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        // CHECKSTYLE:ON

        input = scanner.nextLine();

        try {
            difficult = Integer.parseInt(input);
            if (difficult < EASY_DIFFICULT || difficult > HARD_DIFFICULT) {
                difficult = RANDOM.nextInt(HARD_DIFFICULT) + 1;
            }
        } catch (NumberFormatException e) {
            difficult = RANDOM.nextInt(HARD_DIFFICULT) + 1;
        }
    }
}
