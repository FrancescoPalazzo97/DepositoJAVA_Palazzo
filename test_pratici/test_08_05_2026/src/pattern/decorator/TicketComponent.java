package pattern.decorator;

/**
 * Contratto comune tra il ticket reale e i suoi decoratori.
 * <p>
 * Permette al Decorator pattern di aggiungere testo alla visualizzazione senza
 * modificare la classe {@code Ticket}.
 */
public interface TicketComponent {
    /**
     * @return testo da mostrare in console per il ticket o per il ticket decorato
     */
    String getDisplayText();
}
