import backend.academy.Gallows;
import backend.academy.GameProcess;
import backend.academy.Word;
import org.apache.commons.lang3.Validate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Scanner;
import static org.mockito.Mockito.*;

public class GameProcessTest {
    private Gallows mockGallows;
    private Word mockWord;
    private Scanner mockScanner;
    private GameProcess gameProcess;

    @BeforeEach
    public void setUp() {
        mockGallows = mock(Gallows.class);
        mockWord = mock(Word.class);
        mockScanner = mock(Scanner.class);
        gameProcess = new GameProcess("battle", 1, 1);

        Mockito.when(mockWord.word()).thenReturn("battle");

        gameProcess.gallow(mockGallows);
        gameProcess.wordSecret(mockWord);
        gameProcess.scanner(mockScanner);
    }

    @Test
    public void testGameProcessCompletes() {
        // Настройка ввода с последовательностью правильных букв
        when(mockScanner.nextLine()).thenReturn("b", "a", "t", "t", "l", "e");

        when(mockWord.letterCheck(anyString())).thenAnswer(invocation -> {
            String guessedLetter = invocation.getArgument(0);
            return "battle".contains(guessedLetter);
        });

        // Настройка поведения для проверки, что слово угадано полностью
        when(mockWord.isClear()).thenReturn(false, false, false, false, false, true);

        // Выполнение тестируемого метода
        gameProcess.gameProcess();

        // Проверка, что метод завершился корректно
        verify(mockWord, atLeastOnce()).print();
    }

    @Test
    public void testNoAddCallOnIncorrectInputNumber() {
        when(mockScanner.nextLine()).thenReturn("1", "a");

        when(mockWord.letterCheck(anyString())).thenReturn(true);

        gameProcess.gameProcess();

        // Проверка, что при некорректном вводе не добавляется символ в виселицу
        verify(mockGallows, never()).add();
    }

    @Test
    public void testNoAddCallOnIncorrectInputString() {
        when(mockScanner.nextLine()).thenReturn("sdfsdfdsf", "a");

        when(mockWord.letterCheck(anyString())).thenReturn(true);

        gameProcess.gameProcess();

        // Проверка, что при некорректном вводе не добавляется символ в виселицу
        verify(mockGallows, never()).add();
    }

    @Test
    public void testGameProcessWinCondition() {
        when(mockWord.isClear()).thenReturn(true);
        when(mockGallows.attempts()).thenReturn(5);
        when(mockScanner.nextLine()).thenReturn("b", "a", "t", "t", "l", "e");

        gameProcess.gameProcess();

        // Проверка, что игра выиграна
        Validate.isTrue(gameProcess.gameStatus() == 1, "Incorrect game status!");
    }

    @Test
    public void testGameProcessLoseCondition() {
        when(mockGallows.attempts()).thenReturn(0);
        when(mockScanner.nextLine()).thenReturn("b", "a", "t", "t", "l", "e");

        gameProcess.gameProcess();

        // Проверка, что игра проиграна если кончились попытки
        Validate.isTrue(gameProcess.gameStatus() == 2, "Incorrect game status!");
    }

    @Test
    public void testGameProcessLoseConditionAttempts() {
        when(mockGallows.attempts()).thenReturn(-1);
        when(mockScanner.nextLine()).thenReturn("b", "a", "t", "t", "l", "e");

        gameProcess.gameProcess();

        // Проверка, что игра проиграна если отрицательные попытки
        Validate.isTrue(gameProcess.gameStatus() == 2, "Incorrect game status!");
    }
}
