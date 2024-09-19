package backend.academy;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public final class ConstantsGallows {
    public static final int ATTEMPTS_FOR_CURRENT_GAME = 6;
    public static final int MIN_AVAILABLE_ATTEMPTS = 6;
    public static final int EASY_DIFFICULT = 1;
    public static final int MEDIUM_DIFFICULT = 2;
    public static final int HARD_DIFFICULT = 3;
    public static final int TITLE_OF_THEME = 0;
    public static final int GAME_LOOSE = 2;
    public static final int GAME_WIN = 1;
    public static final int GAME_NEXT_LEVEL = 0;
    public static final String HINT_COMMAND = "?";
    public static final int GAME_MODE_DEFAULT = 1;
    public static final int GAME_MODE_SURVIVAL = 2;

    private static final List<String> ALPHABET = List.of(
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
        "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "?"
    );

    @Getter
    static final List<char[][]> HANGMAN_STAGES = new ArrayList<>();

    static {
        HANGMAN_STAGES.add(new char[][] {
            {' ', '+', '-', '-', '+'},
            {' ', '|', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', '|'},
            {'=', '=', '=', '=', '='}
        });

        HANGMAN_STAGES.add(new char[][] {
            {' ', '+', '-', '-', '+'},
            {' ', '|', ' ', ' ', '|'},
            {' ', 'O', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', '|'},
            {'=', '=', '=', '=', '='}
        });

        HANGMAN_STAGES.add(new char[][] {
            {' ', '+', '-', '-', '+'},
            {' ', '|', ' ', ' ', '|'},
            {' ', 'O', ' ', ' ', '|'},
            {' ', '|', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', '|'},
            {'=', '=', '=', '=', '='}
        });

        HANGMAN_STAGES.add(new char[][] {
            {' ', '+', '-', '-', '+'},
            {' ', '|', ' ', ' ', '|'},
            {' ', 'O', ' ', ' ', '|'},
            {'/', '|', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', '|'},
            {'=', '=', '=', '=', '='}
        });

        HANGMAN_STAGES.add(new char[][] {
            {' ', '+', '-', '-', '+'},
            {' ', '|', ' ', ' ', '|'},
            {' ', 'O', ' ', ' ', '|'},
            {'/', '|', '\\', ' ', '|'},
            {' ', ' ', ' ', ' ', '|'},
            {'=', '=', '=', '=', '='}
        });

        HANGMAN_STAGES.add(new char[][] {
            {' ', '+', '-', '-', '+'},
            {' ', '|', ' ', ' ', '|'},
            {' ', 'O', ' ', ' ', '|'},
            {'/', '|', '\\', ' ', '|'},
            {'/', ' ', ' ', ' ', '|'},
            {'=', '=', '=', '=', '='}
        });

        HANGMAN_STAGES.add(new char[][] {
            {' ', '+', '-', '-', '+'},
            {' ', '|', ' ', ' ', '|'},
            {' ', 'O', ' ', ' ', '|'},
            {'/', '|', '\\', ' ', '|'},
            {'/', ' ', '\\', ' ', '|'},
            {'=', '=', '=', '=', '='}
        });
    }

    private ConstantsGallows() {
    }

    public static char[][] deepCopyHangmanStage(int step) {
        int validStep = step;
        if (HANGMAN_STAGES.isEmpty()) {
            return null;
        } else if (validStep >= HANGMAN_STAGES.size()) {
            validStep = 0;
        }

        char[][] result = new char[ConstantsGallows.HANGMAN_STAGES.get(validStep).length][];
        for (int i = 0; i < ConstantsGallows.HANGMAN_STAGES.get(validStep).length; i++) {
            result[i] = ConstantsGallows.HANGMAN_STAGES.get(validStep)[i].clone();
        }
        return result;
    }

    public static boolean containsInAlpabet(String input) {
        for (String letter : ALPHABET) {
            if (letter.equals(input)) {
                return true;
            }
        }
        return false;
    }
}
