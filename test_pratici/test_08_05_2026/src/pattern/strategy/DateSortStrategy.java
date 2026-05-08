package pattern.strategy;

import model.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Strategia che ordina i ticket per data di creazione crescente.
 */
public class DateSortStrategy implements SortStrategy {
    /**
     * Crea una copia della lista e la ordina dal ticket piu' vecchio al piu'
     * recente.
     */
    @Override
    public List<Ticket> sort(List<Ticket> tickets) {
        ArrayList<Ticket> sorted = new ArrayList<>(tickets);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                Ticket current = sorted.get(i);
                Ticket next = sorted.get(j);
                if (current.getDataCreazione().isAfter(next.getDataCreazione())) {
                    sorted.set(i, next);
                    sorted.set(j, current);
                }
            }
        }
        return sorted;
    }
}
