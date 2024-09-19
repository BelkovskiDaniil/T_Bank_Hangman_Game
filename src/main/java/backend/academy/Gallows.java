package backend.academy;

import lombok.Getter;
import lombok.Setter;
import static backend.academy.ConstantsGallows.ATTEMPTS_FOR_CURRENT_GAME;
import static backend.academy.ConstantsGallows.deepCopyHangmanStage;

@Getter
@Setter
public class Gallows {
    private int attempts = ATTEMPTS_FOR_CURRENT_GAME;
    private char[][] hangman = deepCopyHangmanStage(0);
    int currentIteration = 0;

    //Добавляем к висельнику детали в зависимости от того, какая доля жизней потрачена
    public void add() {
        attempts -= 1;

        int totalStages = ConstantsGallows.HANGMAN_STAGES().size();

        // Проверка, если попыток больше не осталось — показываем последнюю стадию
        if (attempts == 0) {
            hangman = deepCopyHangmanStage(totalStages - 1);
            return;
        }

        // Расчет доли потраченных попыток относительно общего количества попыток
        double fractionOfAttemptsUsed = (double) (ATTEMPTS_FOR_CURRENT_GAME - attempts) / ATTEMPTS_FOR_CURRENT_GAME;

        // Вычисляем текущую стадию на основе этой доли
        int currentStage = (int) Math.floor(fractionOfAttemptsUsed * (totalStages - 1));

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
