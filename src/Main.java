import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    private static final String validSymbols = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM123456789_";

    public static void main(String[] args) {
        try {
            authentication("12ds", "12", "12");
            System.out.println("Вход выполнен!");
        } catch (WrongLoginException wrongLoginException) {
            System.out.println(wrongLoginException.getMessage());
        } catch (WrongPasswordException wrongPasswordException) {
            System.out.println(wrongPasswordException.getMessage());
        }
    }

    private static void authentication(String login, String password, String confirmPassword) {
        for (int i = 0; i < login.length(); i++) {
            if (login.length() > 20 || !validSymbols.contains(Character.toString(login.charAt(i)))) {
                throw new WrongLoginException();
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (password.length() > 20 || !validSymbols.contains(Character.toString(password.charAt(i)))) {
                throw new WrongPasswordException();
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}