package model;

import pattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un utente base del sistema.
 * <p>
 * Implementa {@link Observer} per poter ricevere notifiche, ad esempio quando
 * un proprio ticket viene risolto.
 */
public class User implements Observer {
    private final String username;
    private final List<String> notifiche;

    public User(String username) {
        this.username = username;
        this.notifiche = new ArrayList<>();
    }

    /**
     * @return username usato per il login e per identificare l'autore dei ticket
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return lista delle notifiche ricevute dall'utente durante l'esecuzione
     */
    public List<String> getNotifiche() {
        return notifiche;
    }

    /**
     * Riceve una notifica dal subject del pattern Observer e la conserva nella
     * lista personale dell'utente.
     *
     * @param messaggio testo della notifica
     */
    @Override
    public void update(String messaggio) {
        notifiche.add(messaggio);
    }

    @Override
    public String toString() {
        return username;
    }
}
