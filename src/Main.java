public class Main {
    public static void main(String[] args) {
        String login = "qwerty";
        String password = "12345";
        String confirmPassword = "12345";
        try {
            checkAuthentication(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка в логине");
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка в пароле");
        }
    }

    public static void checkAuthentication(String login, String password, String confirmPassword) {
        if (checkSymbol(login) || login.length() > 20) {
            throw new WrongLoginException();
        }
        if (checkSymbol(password) || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }

    public static boolean checkSymbol(String string) {
        String allowedSymbols = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789_";
        Boolean correctSymbol = false;
        for (int i = 0; i < string.length(); i++) {
            if (allowedSymbols.indexOf(string.charAt(i)) == -1) {
                correctSymbol = true;
            }
        }
        return correctSymbol;
    }
}