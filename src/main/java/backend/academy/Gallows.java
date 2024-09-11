package backend.academy;

import lombok.Getter;
import static backend.academy.ConstantsGallows.ATTEMPTS_FOR_CURRENT_GAME;
import static backend.academy.ConstantsGallows.deepCopyHangmanStage;

@Getter
public class Gallows {
    private int attempts = ATTEMPTS_FOR_CURRENT_GAME;
    private char[][] hangman = deepCopyHangmanStage(0);

    //Добавляем к висельнику детали в зависимости от того, какая доля жизней потрачена
    public void add() {
        attempts -= 1;

        // Получаем текущую итерацию виселицы на основе оставшихся попыток
        int currentStage = Math.max(0, ConstantsGallows.HANGMAN_STAGES().size() - attempts - 1);

        // Обновляем текущее состояние виселицы на новую стадию
        hangman = deepCopyHangmanStage(currentStage);
    }


    public void reload() {
        attempts = ATTEMPTS_FOR_CURRENT_GAME;
        hangman = deepCopyHangmanStage(0);
    }

    @SuppressWarnings("squid:S106")
    public void print() {
        // CHECKSTYLE:OFF
        System.out.println();
        System.out.println();
        for (char[] row : hangman) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
        // CHECKSTYLE:ON
    }
}
