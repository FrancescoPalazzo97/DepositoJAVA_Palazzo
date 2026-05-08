package pattern.strategy;

import model.Ticket;

import java.util.List;

/**
 * Interfaccia del pattern Strategy per l'ordinamento dei ticket.
 * <p>
 * Il controller puo' scegliere una strategia diversa senza conoscere i dettagli
 * dell'algoritmo usato.
 */
public interface SortStrategy {
    /**
     * Ordina una lista di ticket secondo una regola specifica.
     *
     * @param tickets lista originale
     * @return nuova lista ordinata
     */
    List<Ticket> sort(List<Ticket> tickets);
}
