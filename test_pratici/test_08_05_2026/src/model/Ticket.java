package model;

import pattern.decorator.TicketComponent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Modello principale del dominio: descrive una richiesta aperta dagli utenti.
 * <p>
 * Implementa {@link TicketComponent} per poter essere visualizzato direttamente
 * oppure decorato, ad esempio con il prefisso urgente per i ticket ad alta
 * priorita.
 */
public class Ticket implements TicketComponent {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private final int id;
    private String titolo;
    private String descrizione;
    private String stato;
    private final User autore;
    private String priorita;
    private String categoria;
    private final LocalDateTime dataCreazione;
    private LocalDateTime dataRisoluzione;

    /**
     * Crea un ticket in stato iniziale {@code APERTO}; la data di creazione viene
     * impostata automaticamente al momento della costruzione.
     */
    public Ticket(int id, String titolo, String descrizione, User autore, String priorita, String categoria) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.autore = autore;
        this.priorita = priorita;
        this.categoria = categoria;
        this.stato = Costanti.STATO_APERTO;
        this.dataCreazione = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public User getAutore() {
        return autore;
    }

    public String getPriorita() {
        return priorita;
    }

    public void setPriorita(String priorita) {
        this.priorita = priorita;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public LocalDateTime getDataRisoluzione() {
        return dataRisoluzione;
    }

    public void setDataRisoluzione(LocalDateTime dataRisoluzione) {
        this.dataRisoluzione = dataRisoluzione;
    }

    /**
     * Prepara una rappresentazione testuale completa del ticket per la console.
     *
     * @return testo gia formattato con id, stato, autore, priorita e descrizione
     */
    @Override
    public String getDisplayText() {
        String risoluzione = dataRisoluzione == null ? "-" : dataRisoluzione.format(FORMATTER);
        return "#" + id + " [" + stato + "] " + titolo
                + "\nAutore: " + autore.getUsername()
                + " | Priorita: " + priorita
                + " | Categoria: " + categoria
                + "\nCreato: " + dataCreazione.format(FORMATTER)
                + " | Risolto: " + risoluzione
                + "\nDescrizione: " + descrizione;
    }
}
