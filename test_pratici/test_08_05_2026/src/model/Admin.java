package model;

/**
 * Utente con permessi amministrativi.
 * <p>
 * Estende {@link User}: eredita login e notifiche, ma viene riconosciuto dai
 * controller per abilitare modifica, eliminazione e risoluzione dei ticket.
 */
public class Admin extends User {
    public Admin(String username) {
        super(username);
    }
}
