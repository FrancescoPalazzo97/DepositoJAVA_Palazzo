package model;

/**
 * Raccoglie le stringhe costanti usate per stati, priorita e categorie.
 * <p>
 * Il progetto evita volutamente gli {@code enum}, quindi questa classe mantiene
 * i valori ammessi in un unico punto leggibile.
 */
public class Costanti {
    public static final String STATO_APERTO = "APERTO";
    public static final String STATO_IN_LAVORAZIONE = "IN_LAVORAZIONE";
    public static final String STATO_RISOLTO = "RISOLTO";

    public static final String PRIORITA_BASSA = "BASSA";
    public static final String PRIORITA_MEDIA = "MEDIA";
    public static final String PRIORITA_ALTA = "ALTA";

    public static final String CATEGORIA_BUG = "BUG";
    public static final String CATEGORIA_FEATURE = "FEATURE";
    public static final String CATEGORIA_INFO = "INFO";
}
