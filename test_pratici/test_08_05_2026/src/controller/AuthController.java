package controller;

import model.User;
import pattern.singleton.TicketDataStore;

/**
 * Controller dedicato all'autenticazione semplificata.
 * <p>
 * Il login non usa password: verifica soltanto che lo username esista tra gli
 * utenti hard-coded nel datastore.
 */
public class AuthController {
    private final TicketDataStore dataStore;

    public AuthController() {
        this.dataStore = TicketDataStore.getInstance();
    }

    /**
     * Cerca l'utente corrispondente allo username digitato.
     *
     * @param username nome inserito in console
     * @return utente trovato oppure {@code null} se non esiste
     */
    public User login(String username) {
        if (username == null || username.trim().isEmpty()) {
            return null;
        }
        return dataStore.findUserByUsername(username.trim());
    }
}
