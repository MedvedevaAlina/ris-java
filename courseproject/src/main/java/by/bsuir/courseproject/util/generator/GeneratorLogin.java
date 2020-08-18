package by.bsuir.courseproject.util.generator;

public class GeneratorLogin {
    private static final String DEFAULT_LOGIN = "logis1ik";
    private static int counter=56;

    private GeneratorLogin() {
    }

    public static String generateLogin() {
        ++counter;
        String newLogin = DEFAULT_LOGIN + counter;
        return newLogin;
    }
}
