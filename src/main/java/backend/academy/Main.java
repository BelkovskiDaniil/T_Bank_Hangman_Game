package backend.academy;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        GameInterface game = new GameInterface();
        game.gameStart();
    }
}
