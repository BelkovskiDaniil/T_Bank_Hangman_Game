package backend.academy;

import java.util.Random;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;
import static backend.academy.ConstantsGallows.DIF_EASY;
import static backend.academy.ConstantsGallows.DIF_HARD;
import static backend.academy.ConstantsGallows.DIF_MEDIUM;
import static backend.academy.ConstantsGallows.MIN_AVAILABLE_ATTEMPTS;
import static backend.academy.ConstantsGallows.NUMBERS_FOR_RANDOM;
import static backend.academy.ConstantsGallows.THEME_DEV;
import static backend.academy.ConstantsGallows.THEME_RELIGION;
import static backend.academy.ConstantsGallows.THEME_WAR;

@Getter @Setter public class GameInterface {
    boolean cycleKey = true;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public void gameStart() {
        boolean shoudIUpdate = true;
        int theme = 1;
        int difficult = 1;
        String input = "";
        while (cycleKey) {
            //Проверка корректности количества попыток
            if (ConstantsGallows.MAX_ATTEMPTS < MIN_AVAILABLE_ATTEMPTS) {
                System.out.println("""
                    \nIncorrect number of attempts! (Should be more than 5)""");
                break;
            }
            //Проверка, нужно ли обновить данные при перезапуске игры
            if (shoudIUpdate) {
                System.out.println("""
                    \nChoose theme of words
                    Enter number of them (if incorrect input, we will use random)
                    1. War
                    2. Program development
                    3. Religion""");

                input = scanner.nextLine();
                theme = switch (input) {
                    case "1" -> THEME_WAR;
                    case "2" -> THEME_DEV;
                    case "3" -> THEME_RELIGION;
                    default -> NUMBERS_FOR_RANDOM[random.nextInt(NUMBERS_FOR_RANDOM.length)];
                };

                System.out.println("""
                    \nChoose difficult of words
                    Enter number of them (if incorrect input, we will use random)
                    1. Easy
                    2. Medium
                    3. Hard""");

                input = scanner.nextLine();
                difficult = switch (input) {
                    case "1" -> DIF_EASY;
                    case "2" -> DIF_MEDIUM;
                    case "3" -> DIF_HARD;
                    default -> NUMBERS_FOR_RANDOM[random.nextInt(NUMBERS_FOR_RANDOM.length)];
                };
            }

            GameProcess gameProcess = new GameProcess(Dictionary.getWord(theme, difficult), theme, difficult);
            gameProcess.gameProcess();

            System.out.println("""
                \nWanna play one more time?
                Enter number of them (if incorrect input, we will finish session)
                1. Yeah
                2. Nope""");

            input = scanner.nextLine();
            if (!input.equals("1")) {
                System.out.println("""
                \nThanks for game""");
                break;
            }

            System.out.println("""
                \nUpdate settings?
                Enter number of them (if incorrect input, we will don't change settings)
                1. Yeah
                2. Nope""");

            input = scanner.nextLine();
            shoudIUpdate = input.equals("1");
        }
    }
}
