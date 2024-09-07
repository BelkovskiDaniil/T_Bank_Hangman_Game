package backend.academy;

import lombok.Getter;
import static backend.academy.ConstantsGallows.MAX_ATTEMPTS;
import static backend.academy.ConstantsGallows.deepCopyHangmanStage;

@Getter public class Gallows {
    private int attempts = MAX_ATTEMPTS;
    private char[][] hangman = deepCopyHangmanStage();

    //Добавляем к висельнику детали в зависимости от того, какая доля жизней потрачена
    public void add() {
        attempts -= 1;
        if (attempts >= MAX_ATTEMPTS / 6 * 5 && attempts != MAX_ATTEMPTS) {
            hangman[2][1] = 'O';
        } else if (attempts >= MAX_ATTEMPTS / 6 * 4) {
            hangman[3][1] = '|';
        } else if (attempts >= MAX_ATTEMPTS / 6 * 3) {
            hangman[3][0] = '/';
        } else if (attempts >= MAX_ATTEMPTS / 6 * 2) {
            hangman[3][2] = '\\';
        } else if (attempts > 0) {
            hangman[4][0] = '/';
        } else if (attempts == 0) {
            hangman[4][2] = '\\';
        }
    }


    public void reload() {
        attempts = MAX_ATTEMPTS;
        hangman = deepCopyHangmanStage();
    }

    public void print() {
        System.out.println();
        for (char[] row : hangman) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }
}
