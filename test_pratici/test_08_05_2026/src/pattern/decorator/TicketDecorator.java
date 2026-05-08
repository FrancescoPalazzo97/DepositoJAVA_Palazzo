package pattern.decorator;

/**
 * Classe base per i decoratori dei ticket.
 * <p>
 * Conserva un {@link TicketComponent} interno e, di default, ne riusa la
 * visualizzazione. Le sottoclassi possono aggiungere dettagli prima o dopo il
 * testo originale.
 */
public abstract class TicketDecorator implements TicketComponent {
    protected final TicketComponent ticketComponent;

    protected TicketDecorator(TicketComponent ticketComponent) {
        this.ticketComponent = ticketComponent;
    }

    @Override
    public String getDisplayText() {
        return ticketComponent.getDisplayText();
    }
}
