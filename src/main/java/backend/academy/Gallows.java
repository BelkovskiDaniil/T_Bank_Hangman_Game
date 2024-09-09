package backend.academy;

import lombok.Getter;
import static backend.academy.ConstantsGallows.COLUMN_HEAD;
import static backend.academy.ConstantsGallows.COLUMN_LEFT;
import static backend.academy.ConstantsGallows.COLUMN_MIDDLE;
import static backend.academy.ConstantsGallows.COLUMN_RIGHT;
import static backend.academy.ConstantsGallows.FIVE_SIXTHS;
import static backend.academy.ConstantsGallows.FOUR_SIXTHS;
import static backend.academy.ConstantsGallows.MAX_ATTEMPTS;
import static backend.academy.ConstantsGallows.ROW_BODY;
import static backend.academy.ConstantsGallows.ROW_HEAD;
import static backend.academy.ConstantsGallows.ROW_LEGS;
import static backend.academy.ConstantsGallows.THREE_SIXTHS;
import static backend.academy.ConstantsGallows.TWO_SIXTHS;
import static backend.academy.ConstantsGallows.deepCopyHangmanStage;

@Getter public class Gallows {
    private int attempts = MAX_ATTEMPTS;
    private char[][] hangman = deepCopyHangmanStage();

    //Добавляем к висельнику детали в зависимости от того, какая доля жизней потрачена
    public void add() {
        attempts -= 1;
        if (attempts >= FIVE_SIXTHS && attempts != MAX_ATTEMPTS) {
            hangman[ROW_HEAD][COLUMN_HEAD] = 'O';
        } else if (attempts >= FOUR_SIXTHS) {
            hangman[ROW_BODY][COLUMN_MIDDLE] = '|';
        } else if (attempts >= THREE_SIXTHS) {
            hangman[ROW_BODY][COLUMN_LEFT] = '/';
        } else if (attempts >= TWO_SIXTHS) {
            hangman[ROW_BODY][COLUMN_RIGHT] = '\\';
        } else if (attempts > 0) {
            hangman[ROW_LEGS][COLUMN_LEFT] = '/';
        } else if (attempts == 0) {
            hangman[ROW_LEGS][COLUMN_RIGHT] = '\\';
        }
    }


    public void reload() {
        attempts = MAX_ATTEMPTS;
        hangman = deepCopyHangmanStage();
    }

    public void print() {
        System.out.println("\n");
        for (char[] row : hangman) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
