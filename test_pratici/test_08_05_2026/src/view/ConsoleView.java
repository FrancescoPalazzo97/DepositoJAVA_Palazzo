package view;

import model.Costanti;
import model.Ticket;
import pattern.facade.TicketService;

import java.util.List;
import java.util.Scanner;

/**
 * View console dell'applicazione.
 * <p>
 * Contiene input e output testuali, cosi' controller e servizi restano liberi
 * da dettagli legati a {@link Scanner} e {@link System#out}.
 */
public class ConsoleView {
    private final Scanner inString;
    private final Scanner inInt;

    public ConsoleView() {
        this.inString = new Scanner(System.in);
        this.inInt = new Scanner(System.in);
    }

    /**
     * Mostra un breve messaggio iniziale con gli utenti disponibili.
     */
    public void showWelcome() {
        System.out.println("Sistema Gestione Ticket");
        System.out.println("Utenti: mario, luigi | Admin: anna, rossi");
    }

    /**
     * Legge una riga dalla console dopo aver mostrato un prompt.
     */
    public String readLine(String prompt) {
        System.out.print(prompt);
        return inString.nextLine().trim();
    }

    /**
     * Legge un numero intero e continua a chiedere input finche' il valore non e'
     * valido.
     */
    public int readInt(String prompt) {
        System.out.print(prompt);
        return inInt.nextInt();
    }

    /**
     * Menu disponibile agli utenti normali.
     */
    public void showUserMenu() {
        System.out.println("");
        System.out.println("0. Logout");
        System.out.println("1. Crea ticket");
        System.out.println("2. Vedi tutti i ticket");
        System.out.println("3. Vedi i miei ticket");
        System.out.println("4. Ordina ticket");
        System.out.println("5. Vedi notifiche");
    }

    /**
     * Menu admin: include quello utente e aggiunge le operazioni riservate.
     */
    public void showAdminMenu() {
        showUserMenu();
        System.out.println("6. Modifica ticket");
        System.out.println("7. Elimina ticket");
        System.out.println("8. Setta IN_LAVORAZIONE");
        System.out.println("9. Risolvi ticket");
    }

    /**
     * Converte la scelta numerica dell'utente in una priorita valida.
     */
    public String choosePriority() {
        System.out.println("Priorita: 1) BASSA  2) MEDIA  3) ALTA");
        int choice = readInt("Scelta: ");
        if (choice == 3) {
            return Costanti.PRIORITA_ALTA;
        }
        if (choice == 2) {
            return Costanti.PRIORITA_MEDIA;
        }
        return Costanti.PRIORITA_BASSA;
    }

    /**
     * Converte la scelta numerica dell'utente in una categoria valida.
     */
    public String chooseCategory() {
        System.out.println("Categoria: 1) BUG  2) FEATURE  3) INFO");
        int choice = readInt("Scelta: ");
        if (choice == 1) {
            return Costanti.CATEGORIA_BUG;
        }
        if (choice == 2) {
            return Costanti.CATEGORIA_FEATURE;
        }
        return Costanti.CATEGORIA_INFO;
    }

    /**
     * Stampa una lista di ticket usando il formato preparato dal servizio.
     */
    public void showTickets(List<Ticket> tickets, TicketService service) {
        if (tickets.isEmpty()) {
            System.out.println("Nessun ticket trovato.");
            return;
        }
        for (Ticket ticket : tickets) {
            System.out.println("------------------------------");
            System.out.println(service.formatTicket(ticket));
        }
    }
}
