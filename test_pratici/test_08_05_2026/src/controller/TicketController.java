package controller;

import model.Admin;
import model.Ticket;
import model.User;
import pattern.facade.TicketService;
import pattern.strategy.DateSortStrategy;
import pattern.strategy.PrioritySortStrategy;
import view.ConsoleView;

import java.util.List;

/**
 * Controller che gestisce il menu dei ticket.
 * <p>
 * Riceve le scelte dalla view, decide quale operazione eseguire e delega la
 * logica applicativa a {@link TicketService}.
 */
public class TicketController {
    private final ConsoleView view;
    private final TicketService ticketService;

    public TicketController(ConsoleView view) {
        this.view = view;
        this.ticketService = new TicketService();
    }

    /**
     * Avvia il ciclo del menu per l'utente autenticato. Il menu cambia in base al
     * ruolo: gli admin vedono anche le operazioni di gestione avanzata.
     */
    public void start(User currentUser) {
        boolean running = true;
        while (running) {
            if (currentUser instanceof Admin) {
                view.showAdminMenu();
            } else {
                view.showUserMenu();
            }

            int choice = view.readInt("Scelta: ");
            running = handleChoice(choice, currentUser);
        }
    }

    private boolean handleChoice(int choice, User currentUser) {
        switch (choice) {
            case 1:
                createTicket(currentUser);
                return true;
            case 2:
                view.showTickets(ticketService.getAllTickets(), ticketService);
                return true;
            case 3:
                view.showTickets(ticketService.getTicketsByUser(currentUser), ticketService);
                return true;
            case 4:
                sortTickets();
                return true;
            case 5:
                showNotifications(currentUser);
                return true;
            case 6:
                if (currentUser instanceof Admin) {
                    updateTicket();
                } else {
                    System.out.println("Operazione riservata agli admin.");
                }
                return true;
            case 7:
                if (currentUser instanceof Admin) {
                    deleteTicket();
                } else {
                    System.out.println("Operazione riservata agli admin.");
                }
                return true;
            case 8:
                if (currentUser instanceof Admin) {
                    setInLavorazione((Admin) currentUser);
                } else {
                    System.out.println("Operazione riservata agli admin.");
                }
                return true;
            case 9:
                if (currentUser instanceof Admin) {
                    resolveTicket((Admin) currentUser);
                } else {
                    System.out.println("Operazione riservata agli admin.");
                }
                return true;
            case 0:
                System.out.println("Logout effettuato.");
                return false;
            default:
                System.out.println("Scelta non valida.");
                return true;
        }
    }

    /**
     * Raccoglie da console i dati minimi e crea il ticket tramite Facade.
     */
    private void createTicket(User currentUser) {
        String titolo = view.readLine("Titolo: ");
        String descrizione = view.readLine("Descrizione: ");
        String priorita = view.choosePriority();
        String categoria = view.chooseCategory();
        Ticket ticket = ticketService.createTicket(titolo, descrizione, currentUser, priorita, categoria);
        System.out.println("Ticket creato con id #" + ticket.getId());
    }

    private void updateTicket() {
        int id = view.readInt("Id ticket da modificare: ");
        String titolo = view.readLine("Nuovo titolo: ");
        String descrizione = view.readLine("Nuova descrizione: ");
        String priorita = view.choosePriority();
        String categoria = view.chooseCategory();
        boolean updated = ticketService.updateTicket(id, titolo, descrizione, priorita, categoria);
        System.out.println(updated ? "Ticket modificato." : "Ticket non trovato.");
    }

    private void deleteTicket() {
        int id = view.readInt("Id ticket da eliminare: ");
        boolean deleted = ticketService.deleteTicket(id);
        System.out.println(deleted ? "Ticket eliminato." : "Ticket non trovato.");
    }

    private void setInLavorazione(Admin admin) {
        int id = view.readInt("Id ticket: ");
        boolean updated = ticketService.setInLavorazione(id, admin);
        System.out.println(updated ? "Ticket in lavorazione." : "Ticket non trovato.");
    }

    private void resolveTicket(Admin admin) {
        int id = view.readInt("Id ticket: ");
        boolean resolved = ticketService.resolveTicket(id, admin);
        System.out.println(resolved ? "Ticket risolto." : "Ticket non trovato.");
    }

    /**
     * Mostra tutti i ticket ordinati con la strategia scelta dall'utente.
     */
    private void sortTickets() {
        System.out.println("Ordina per: 1) Priorita  2) Data");
        int choice = view.readInt("Scelta: ");
        List<Ticket> sortedTickets;
        if (choice == 1) {
            sortedTickets = ticketService.getSortedTickets(new PrioritySortStrategy());
        } else {
            sortedTickets = ticketService.getSortedTickets(new DateSortStrategy());
        }
        view.showTickets(sortedTickets, ticketService);
    }

    private void showNotifications(User currentUser) {
        if (currentUser.getNotifiche().isEmpty()) {
            System.out.println("Nessuna notifica.");
            return;
        }
        for (String notifica : currentUser.getNotifiche()) {
            System.out.println("- " + notifica);
        }
    }
}
