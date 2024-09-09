package backend.academy;

public final class ConstantsGallows {
    public static final int MAX_ATTEMPTS = 6;
    public static final int MIN_AVAILABLE_ATTEMPTS = 6;
    public static final int[] NUMBERS_FOR_RANDOM = {1, 2, 3};
    public static final int THEME_WAR = 1;
    public static final int THEME_DEV = 2;
    public static final int THEME_RELIGION = 3;
    public static final int DIF_EASY = 1;
    public static final int DIF_MEDIUM = 2;
    public static final int DIF_HARD = 3;
    public static final int FIVE_SIXTHS = MAX_ATTEMPTS / 6 * 5;
    public static final int FOUR_SIXTHS = MAX_ATTEMPTS / 6 * 4;
    public static final int THREE_SIXTHS = MAX_ATTEMPTS / 6 * 3;
    public static final int TWO_SIXTHS = MAX_ATTEMPTS / 6 * 2;

    public static final int ROW_HEAD = 2;
    public static final int COLUMN_HEAD = 1;
    public static final int ROW_BODY = 3;
    public static final int ROW_LEGS = 4;
    public static final int COLUMN_LEFT = 0;
    public static final int COLUMN_MIDDLE = 1;
    public static final int COLUMN_RIGHT = 2;



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

    private ConstantsGallows() {
    }

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
