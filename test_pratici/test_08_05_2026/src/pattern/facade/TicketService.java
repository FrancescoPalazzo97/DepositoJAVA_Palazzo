package pattern.facade;

import model.Admin;
import model.Costanti;
import model.Ticket;
import model.User;
import pattern.decorator.TicketComponent;
import pattern.decorator.UrgentTicketDecorator;
import pattern.observer.NotificationManager;
import pattern.singleton.TicketDataStore;
import pattern.strategy.SortStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Facade dell'applicazione per tutti i casi d'uso sui ticket.
 * <p>
 * I controller parlano con questa classe invece di conoscere direttamente
 * datastore, notifiche, strategie e decoratori. In questo modo la logica resta
 * concentrata e piu' semplice da seguire.
 */
public class TicketService {
    private final TicketDataStore dataStore;
    private final NotificationManager notificationManager;

    public TicketService() {
        this.dataStore = TicketDataStore.getInstance();
        this.notificationManager = new NotificationManager();
    }

    /**
     * Crea un nuovo ticket, lo salva nello store e notifica gli admin.
     */
    public Ticket createTicket(String titolo, String descrizione, User autore, String priorita, String categoria) {
        Ticket ticket = new Ticket(dataStore.getNextTicketId(), titolo, descrizione, autore, priorita, categoria);
        dataStore.addTicket(ticket);
        notificationManager.notifyNewTicket(ticket);
        return ticket;
    }

    /**
     * @return copia della lista dei ticket, utile per non esporre direttamente la
     *         struttura interna dello store
     */
    public List<Ticket> getAllTickets() {
        return new ArrayList<>(dataStore.getTickets());
    }

    /**
     * Filtra i ticket creati da uno specifico utente.
     *
     * @param user autore da usare come filtro
     * @return ticket appartenenti all'utente indicato
     */
    public List<Ticket> getTicketsByUser(User user) {
        ArrayList<Ticket> result = new ArrayList<>();
        for (Ticket ticket : dataStore.getTickets()) {
            if (ticket.getAutore().equals(user)) {
                result.add(ticket);
            }
        }
        return result;
    }

    /**
     * Recupera un singolo ticket usando l'id.
     */
    public Ticket getTicketById(int id) {
        return dataStore.findTicketById(id);
    }

    /**
     * Modifica i dati principali di un ticket esistente.
     *
     * @return {@code true} se il ticket esiste ed e' stato aggiornato
     */
    public boolean updateTicket(int id, String titolo, String descrizione, String priorita, String categoria) {
        Ticket ticket = dataStore.findTicketById(id);
        if (ticket == null) {
            return false;
        }
        ticket.setTitolo(titolo);
        ticket.setDescrizione(descrizione);
        ticket.setPriorita(priorita);
        ticket.setCategoria(categoria);
        return true;
    }

    /**
     * Elimina un ticket dallo store.
     *
     * @return {@code true} se il ticket e' stato trovato ed eliminato
     */
    public boolean deleteTicket(int id) {
        Ticket ticket = dataStore.findTicketById(id);
        return ticket != null && dataStore.removeTicket(ticket);
    }

    /**
     * Porta un ticket allo stato IN_LAVORAZIONE. Il parametro admin rende chiaro
     * che il caso d'uso e' riservato a un amministratore.
     */
    public boolean setInLavorazione(int id, Admin admin) {
        Ticket ticket = dataStore.findTicketById(id);
        if (ticket == null) {
            return false;
        }
        ticket.setStato(Costanti.STATO_IN_LAVORAZIONE);
        return true;
    }

    /**
     * Risolve un ticket, registra la data di risoluzione e notifica l'autore.
     */
    public boolean resolveTicket(int id, Admin admin) {
        Ticket ticket = dataStore.findTicketById(id);
        if (ticket == null) {
            return false;
        }
        ticket.setStato(Costanti.STATO_RISOLTO);
        ticket.setDataRisoluzione(LocalDateTime.now());
        notificationManager.notifyResolvedTicket(ticket);
        return true;
    }

    /**
     * Applica la strategia di ordinamento scelta dal menu.
     */
    public List<Ticket> getSortedTickets(SortStrategy sortStrategy) {
        return sortStrategy.sort(dataStore.getTickets());
    }

    /**
     * Prepara il testo di visualizzazione. Se il ticket ha priorita ALTA viene
     * decorato con {@link UrgentTicketDecorator}.
     */
    public String formatTicket(Ticket ticket) {
        TicketComponent component = ticket;
        if (Costanti.PRIORITA_ALTA.equals(ticket.getPriorita())) {
            component = new UrgentTicketDecorator(component);
        }
        return component.getDisplayText();
    }
}
