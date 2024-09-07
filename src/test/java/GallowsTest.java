import backend.academy.Gallows;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static backend.academy.ConstantsGallows.HANGMAN_STAGE_0;
import static backend.academy.ConstantsGallows.HANGMAN_STAGE_1;
import static backend.academy.ConstantsGallows.HANGMAN_STAGE_2;
import static backend.academy.ConstantsGallows.HANGMAN_STAGE_3;
import static backend.academy.ConstantsGallows.HANGMAN_STAGE_4;
import static backend.academy.ConstantsGallows.HANGMAN_STAGE_5;
import static backend.academy.ConstantsGallows.HANGMAN_STAGE_6;
import static backend.academy.ConstantsGallows.MAX_ATTEMPTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GallowsTest {

    @Test
    void testPrint() {
        //Проверка отрисовки вывода
        Gallows gallow = new Gallows();
        for (int i = 0; i < MAX_ATTEMPTS + 1; i++) {
            switch (i) {
                case 0:
                    assertTrue(Arrays.deepEquals(gallow.hangman(), HANGMAN_STAGE_0), "Incorrect print");
                    gallow.add();
                    break;
                case 1:
                    assertTrue(Arrays.deepEquals(gallow.hangman(), HANGMAN_STAGE_1), "Incorrect print");
                    gallow.add();
                    break;
                case 2:
                    assertTrue(Arrays.deepEquals(gallow.hangman(), HANGMAN_STAGE_2), "Incorrect print");
                    gallow.add();
                    break;
                case 3:
                    assertTrue(Arrays.deepEquals(gallow.hangman(), HANGMAN_STAGE_3), "Incorrect print");
                    gallow.add();
                    break;
                case 4:
                    assertTrue(Arrays.deepEquals(gallow.hangman(), HANGMAN_STAGE_4), "Incorrect print");
                    gallow.add();
                    break;
                case 5:
                    assertTrue(Arrays.deepEquals(gallow.hangman(), HANGMAN_STAGE_5), "Incorrect print");
                    gallow.add();
                    break;
                case 6:
                    assertTrue(Arrays.deepEquals(gallow.hangman(), HANGMAN_STAGE_6), "Incorrect print");
                    gallow.add();
                    break;
            }
        }
    }
}
