package pattern.observer;

/**
 * Interfaccia del pattern Observer.
 * <p>
 * Ogni classe che vuole ricevere notifiche dal sistema deve implementare questo
 * metodo.
 */
public interface Observer {
    /**
     * Riceve un messaggio prodotto dal subject.
     *
     * @param messaggio contenuto della notifica
     */
    void update(String messaggio);
}
