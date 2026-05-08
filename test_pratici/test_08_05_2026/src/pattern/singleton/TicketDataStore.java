package pattern.singleton;

import model.Admin;
import model.Ticket;
import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Archivio in memoria dell'applicazione.
 * <p>
 * Applica il Singleton pattern: esiste una sola istanza condivisa che conserva
 * gli {@link ArrayList} di utenti e ticket per tutta la durata del programma.
 */
public class TicketDataStore {
    private static TicketDataStore instance;

    private final ArrayList<Ticket> tickets;
    private final ArrayList<User> users;
    private int nextTicketId;

    /**
     * Costruttore privato per impedire la creazione di piu' datastore.
     */
    private TicketDataStore() {
        this.tickets = new ArrayList<>();
        this.users = new ArrayList<>();
        this.nextTicketId = 1;
        seedUsers();
    }

    /**
     * Restituisce l'unica istanza del datastore, creandola al primo accesso.
     *
     * @return istanza condivisa del datastore
     */
    public static TicketDataStore getInstance() {
        if (instance == null) {
            instance = new TicketDataStore();
        }
        return instance;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<User> getUsers() {
        return users;
    }

    /**
     * Genera un id progressivo per i nuovi ticket.
     *
     * @return prossimo identificativo disponibile
     */
    public int getNextTicketId() {
        return nextTicketId++;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public boolean removeTicket(Ticket ticket) {
        return tickets.remove(ticket);
    }

    /**
     * Cerca un ticket tramite id.
     *
     * @param id identificativo del ticket
     * @return ticket trovato oppure {@code null}
     */
    public Ticket findTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    /**
     * Cerca un utente tramite username ignorando maiuscole e minuscole.
     *
     * @param username nome digitato in fase di login
     * @return utente trovato oppure {@code null}
     */
    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    private void seedUsers() {
        users.add(new User("mario"));
        users.add(new User("luigi"));
        users.add(new Admin("anna"));
        users.add(new Admin("rossi"));
    }
}
