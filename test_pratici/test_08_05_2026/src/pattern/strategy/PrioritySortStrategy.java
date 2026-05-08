package pattern.strategy;

import model.Costanti;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Strategia che ordina i ticket dalla priorita piu' alta alla piu' bassa.
 */
public class PrioritySortStrategy implements SortStrategy {
    /**
     * Crea una copia della lista e la ordina senza modificare l'ordine originale
     * nello store.
     */
    @Override
    public List<Ticket> sort(List<Ticket> tickets) {
        ArrayList<Ticket> sorted = new ArrayList<>(tickets);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                Ticket current = sorted.get(i);
                Ticket next = sorted.get(j);
                if (priorityValue(current) < priorityValue(next)) {
                    sorted.set(i, next);
                    sorted.set(j, current);
                }
            }
        }
        return sorted;
    }

    /**
     * Traduce la priorita testuale in un valore numerico semplice da confrontare.
     */
    private int priorityValue(Ticket ticket) {
        if (Costanti.PRIORITA_ALTA.equals(ticket.getPriorita())) {
            return 3;
        }
        if (Costanti.PRIORITA_MEDIA.equals(ticket.getPriorita())) {
            return 2;
        }
        return 1;
    }
}
