package backend.academy;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.Getter;

@Getter
public class UsersDB {
    private static final String DATABASE_URL = "jdbc:sqlite:Users.db";
    private static final String TABLE_CREATION_SQL = "CREATE TABLE IF NOT EXISTS users ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "user TEXT NOT NULL,"
        + "score INTEGER NOT NULL,"
        + "theme TEXT NOT NULL,"
        + "difficult TEXT NOT NULL);";
    private static final String SELECT_SCORE_SQL = "SELECT score FROM users WHERE user = ?";
    private static final String INSERT_USER_SQL = "INSERT INTO users (user, score,"
        + " theme, difficult) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_USER_SQL = "UPDATE users SET score = ?, theme = ?, difficult = ? WHERE user = ?";
    private static final String SELECT_ALL_USERS_SQL = "SELECT * FROM users ORDER BY score DESC";
    private static final String SCORE_COLUMN = "score";
    private static final String USER_COLUMN = "user";
    private static final String THEME_COLUMN = "theme";
    private static final String DIFFICULT_COLUMN = "difficult";
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;


    private Connection connection;

    public void connect() {
        File dbFile = new File("Users.db");
        boolean databaseExists = dbFile.exists();

        try {
            connection = DriverManager.getConnection(DATABASE_URL);
            if (!databaseExists) {
                createTable();
            }
        } catch (SQLException e) {
            // CHECKSTYLE:OFF
            System.out.println(e.getMessage());
            // CHECKSTYLE:ON
        }
    }

    private void createTable() {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(TABLE_CREATION_SQL);
        } catch (SQLException e) {
            // CHECKSTYLE:OFF
            System.out.println(e.getMessage());
            // CHECKSTYLE:ON
        }
    }

    public void addUser(String userName, int score, String theme, String difficulty) {
        try (PreparedStatement selectStmt = connection.prepareStatement(SELECT_SCORE_SQL);
             PreparedStatement insertStmt = connection.prepareStatement(INSERT_USER_SQL);
             PreparedStatement updateStmt = connection.prepareStatement(UPDATE_USER_SQL)) {

            selectStmt.setString(1, userName);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int existingScore = rs.getInt(SCORE_COLUMN);
                if (score > existingScore) {
                    updateStmt.setInt(ONE, score);
                    updateStmt.setString(TWO, theme);
                    updateStmt.setString(THREE, difficulty);
                    updateStmt.setString(FOUR, userName);
                    updateStmt.executeUpdate();
                }
            } else {
                insertStmt.setString(ONE, userName);
                insertStmt.setInt(TWO, score);
                insertStmt.setString(THREE, theme);
                insertStmt.setString(FOUR, difficulty);
                insertStmt.executeUpdate();
            }

        } catch (SQLException e) {
            // CHECKSTYLE:OFF
            System.out.println(e.getMessage());
            // CHECKSTYLE:ON
        }
    }

    public void print() {
        try (PreparedStatement selectStmt = connection.prepareStatement(SELECT_ALL_USERS_SQL);
             ResultSet rs = selectStmt.executeQuery()) {

            while (rs.next()) {
                // CHECKSTYLE:OFF
                int id = rs.getInt("id");
                String userName = rs.getString(USER_COLUMN);
                int score = rs.getInt(SCORE_COLUMN);
                String theme = rs.getString(THEME_COLUMN);
                String difficulty = rs.getString(DIFFICULT_COLUMN);

                System.out.printf("\nID: %d | User: %s | Score: %d | Theme: %s | Difficulty: %s%n",
                    id, userName, score, theme, difficulty);
                // CHECKSTYLE:ON
            }

        } catch (SQLException e) {
            // CHECKSTYLE:OFF
            System.out.println(e.getMessage());
            // CHECKSTYLE:ON
        }
    }
}
