package backend.academy;

import org.apache.commons.lang3.Validate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Scanner;
import static org.mockito.Mockito.*;

public class GameProcessDefaultTest {
    private Gallows mockGallows;
    private Word mockWord;
    private Scanner mockScanner;
    private GameProcessDefault gameProcessDefault;

    @BeforeEach
    public void setUp() {
        mockGallows = mock(Gallows.class);
        mockWord = mock(Word.class);
        mockScanner = mock(Scanner.class);
        gameProcessDefault = new GameProcessDefault("battle", 1, 1);

        Mockito.when(mockWord.word()).thenReturn("battle");

        gameProcessDefault.gallow(mockGallows);
        gameProcessDefault.wordSecret(mockWord);
        gameProcessDefault.scanner(mockScanner);
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
        gameProcessDefault.gameProcess();

        // Проверка, что метод завершился корректно
        verify(mockWord, atLeastOnce()).print();
    }

    @Test
    public void testAddCallOnRepeatedIncorrectInput() {
        when(mockScanner.nextLine()).thenReturn("f", "f");

        when(mockWord.letterCheck(anyString())).thenReturn(false);

        gameProcessDefault.gameProcess();

        // Проверяем, что при повторном вводе неправильной буквы, теряется только одна жизнь
        verify(mockGallows, times(1)).add();
    }


    @Test
    public void testNoAddCallOnIncorrectInputNumber() {
        when(mockScanner.nextLine()).thenReturn("1", "a");

        when(mockWord.letterCheck(anyString())).thenReturn(true);

        gameProcessDefault.gameProcess();

        // Проверка, что при некорректном вводе не добавляется символ в виселицу
        verify(mockGallows, never()).add();
    }

    @Test
    public void testNoAddCallOnIncorrectInputString() {
        when(mockScanner.nextLine()).thenReturn("sdfsdfdsf", "a");

        when(mockWord.letterCheck(anyString())).thenReturn(true);

        gameProcessDefault.gameProcess();

        // Проверка, что при некорректном вводе не добавляется символ в виселицу
        verify(mockGallows, never()).add();
    }

    @Test
    public void testGameProcessWinCondition() {
        when(mockWord.isClear()).thenReturn(true);
        when(mockGallows.attempts()).thenReturn(5);
        when(mockScanner.nextLine()).thenReturn("b", "a", "t", "t", "l", "e");

        gameProcessDefault.gameProcess();

        // Проверка, что игра выиграна
        Validate.isTrue(gameProcessDefault.gameStatus() == 1, "Incorrect game status!");
    }

    @Test
    public void testGameProcessLoseCondition() {
        when(mockGallows.attempts()).thenReturn(0);
        when(mockScanner.nextLine()).thenReturn("b", "a", "t", "t", "l", "e");

        gameProcessDefault.gameProcess();

        // Проверка, что игра проиграна если кончились попытки
        Validate.isTrue(gameProcessDefault.gameStatus() == 2, "Incorrect game status!");
    }

    @Test
    public void testGameProcessLoseConditionAttempts() {
        when(mockGallows.attempts()).thenReturn(-1);
        when(mockScanner.nextLine()).thenReturn("b", "a", "t", "t", "l", "e");

        gameProcessDefault.gameProcess();

        // Проверка, что игра проиграна если отрицательные попытки
        Validate.isTrue(gameProcessDefault.gameStatus() == 2, "Incorrect game status!");
    }
}
