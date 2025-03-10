package mate.academy;

import mate.academy.lib.Injector;
import mate.academy.security.AuthenticationService;

public class Main {

    private static final Injector injector = Injector.getInstance("mate.academy");

    public static void main(String[] args) throws Exception {
        AuthenticationService authenticationService
                = (AuthenticationService) injector.getInstance(AuthenticationService.class);

        String email = "kfa13@gmail.com";
        String password = "kfa13";

        System.out.println(authenticationService.register(email, password));
        System.out.println(authenticationService.login(email, password));
    }
}
