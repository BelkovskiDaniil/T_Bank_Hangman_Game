package backend.academy;

public class ConstantsGallows {
    public static final int MAX_ATTEMPTS = 6;
    public static final int[] NUMBERS_FOR_RANDOM = {1, 2, 3};
    private static final String[] ALPHABET = {
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
        "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "?"
    };

    public static final char[][] HANGMAN_STAGE_0 = {
        {' ', '+', '-', '-', '+'},
        {' ', '|', ' ', ' ', '|'},
        {' ', ' ', ' ', ' ', '|'},
        {' ', ' ', ' ', ' ', '|'},
        {' ', ' ', ' ', ' ', '|'},
        {'=', '=', '=', '=', '='}
    };

    public static final char[][] HANGMAN_STAGE_1 = {
        {' ', '+', '-', '-', '+'},
        {' ', '|', ' ', ' ', '|'},
        {' ', 'O', ' ', ' ', '|'},
        {' ', ' ', ' ', ' ', '|'},
        {' ', ' ', ' ', ' ', '|'},
        {'=', '=', '=', '=', '='}
    };

    public static final char[][] HANGMAN_STAGE_2 = {
        {' ', '+', '-', '-', '+'},
        {' ', '|', ' ', ' ', '|'},
        {' ', 'O', ' ', ' ', '|'},
        {' ', '|', ' ', ' ', '|'},
        {' ', ' ', ' ', ' ', '|'},
        {'=', '=', '=', '=', '='}
    };

    public static final char[][] HANGMAN_STAGE_3 = {
        {' ', '+', '-', '-', '+'},
        {' ', '|', ' ', ' ', '|'},
        {' ', 'O', ' ', ' ', '|'},
        {'/', '|', ' ', ' ', '|'},
        {' ', ' ', ' ', ' ', '|'},
        {'=', '=', '=', '=', '='}
    };

    public static final char[][] HANGMAN_STAGE_4 = {
        {' ', '+', '-', '-', '+'},
        {' ', '|', ' ', ' ', '|'},
        {' ', 'O', ' ', ' ', '|'},
        {'/', '|', '\\', ' ', '|'},
        {' ', ' ', ' ', ' ', '|'},
        {'=', '=', '=', '=', '='}
    };

    public static final char[][] HANGMAN_STAGE_5 = {
        {' ', '+', '-', '-', '+'},
        {' ', '|', ' ', ' ', '|'},
        {' ', 'O', ' ', ' ', '|'},
        {'/', '|', '\\', ' ', '|'},
        {'/', ' ', ' ', ' ', '|'},
        {'=', '=', '=', '=', '='}
    };

    public static final char[][] HANGMAN_STAGE_6 = {
        {' ', '+', '-', '-', '+'},
        {' ', '|', ' ', ' ', '|'},
        {' ', 'O', ' ', ' ', '|'},
        {'/', '|', '\\', ' ', '|'},
        {'/', ' ', '\\', ' ', '|'},
        {'=', '=', '=', '=', '='}
    };

    public static char[][] deepCopyHangmanStage() {
        if (ConstantsGallows.HANGMAN_STAGE_0 == null) {
            return null;
        }

        char[][] result = new char[ConstantsGallows.HANGMAN_STAGE_0.length][];
        for (int i = 0; i < ConstantsGallows.HANGMAN_STAGE_0.length; i++) {
            result[i] = ConstantsGallows.HANGMAN_STAGE_0[i].clone();
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
