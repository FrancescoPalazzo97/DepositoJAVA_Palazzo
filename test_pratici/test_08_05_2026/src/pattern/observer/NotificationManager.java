package pattern.observer;

import model.Admin;
import model.Ticket;
import model.User;
import pattern.singleton.TicketDataStore;

/**
 * Subject del pattern Observer.
 * <p>
 * Centralizza l'invio delle notifiche: avvisa gli admin quando nasce un nuovo
 * ticket e l'autore quando il suo ticket viene risolto.
 */
public class NotificationManager {
    private final TicketDataStore dataStore;

    public NotificationManager() {
        this.dataStore = TicketDataStore.getInstance();
    }

    /**
     * Notifica tutti gli utenti admin della creazione di un nuovo ticket.
     *
     * @param ticket ticket appena creato
     */
    public void notifyNewTicket(Ticket ticket) {
        String messaggio = "Nuovo ticket #" + ticket.getId() + ": " + ticket.getTitolo();
        for (User user : dataStore.getUsers()) {
            if (user instanceof Admin) {
                user.update(messaggio);
            }
        }
    }

    /**
     * Notifica l'autore che il proprio ticket e' stato risolto.
     *
     * @param ticket ticket appena passato allo stato risolto
     */
    public void notifyResolvedTicket(Ticket ticket) {
        ticket.getAutore().update("Ticket #" + ticket.getId() + " risolto: " + ticket.getTitolo());
    }
}
