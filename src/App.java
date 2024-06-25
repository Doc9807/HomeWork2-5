import exception.WrongLoginException;
import exception.WrongPasswordException;

public class App {
    private static final String VALID_SYMBOLS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890_";

    public static void main(String[] args) {
        try {
            authenticateUser("s3__EWR1", "32313", "32313");
            System.out.println("Добро пожаловать!");
        } catch (WrongLoginException wrongLoginException) {
            throw new WrongLoginException();
        } catch (WrongPasswordException wrongPasswordException) {
            throw new WrongPasswordException();
        }
    }

    private static void authenticateUser(String login, String password, String confirmPassword) {
        for (int i = 0; i < login.length(); i++) {
            if (!VALID_SYMBOLS.contains(Character.toString(login.charAt(i))) || login.length() > 20) {
                throw new WrongLoginException();
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (!VALID_SYMBOLS.contains(Character.toString(password.charAt(i))) || password.length() > 20) {
                throw new WrongPasswordException();
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}