package pattern.decorator;

/**
 * Decoratore usato per evidenziare i ticket con priorita alta.
 * <p>
 * Non cambia i dati del ticket: aggiunge soltanto un messaggio visivo alla sua
 * rappresentazione testuale.
 */
public class UrgentTicketDecorator extends TicketDecorator {
    public UrgentTicketDecorator(TicketComponent ticketComponent) {
        super(ticketComponent);
    }

    @Override
    public String getDisplayText() {
        return "*** URGENTE! ***\n" + super.getDisplayText();
    }
}
