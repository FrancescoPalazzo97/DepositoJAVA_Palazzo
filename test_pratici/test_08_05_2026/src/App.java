import controller.AuthController;
import controller.TicketController;
import model.User;
import view.ConsoleView;

/**
 * Punto di ingresso dell'applicazione console.
 * <p>
 * Si occupa solo del ciclo principale di login/logout e delega tutta la logica
 * di autenticazione e gestione ticket ai controller dedicati.
 */
public class App {
    /**
     * Avvia il programma e mantiene attiva la console finche' l'utente non scrive
     * {@code exit}.
     *
     * @param args argomenti da linea di comando, non utilizzati in questa app
     */
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        AuthController authController = new AuthController();
        TicketController ticketController = new TicketController(view);

        view.showWelcome();
        boolean running = true;
        while (running) {
            String username = view.readLine("\nUsername oppure 'exit': ");
            if ("exit".equalsIgnoreCase(username)) {
                running = false;
                continue;
            }

            User user = authController.login(username);
            if (user == null) {
                System.out.println("Utente non trovato.");
            } else {
                System.out.println("Login effettuato come " + user.getUsername());
                ticketController.start(user);
            }
        }

        System.out.println("Applicazione terminata.");
    }
}
