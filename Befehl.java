/**
 * Objekte dieser Klasse halten Informationen über Befehle,
 * die der Benutzer eingegeben hat. Ein Befehl besteht momentan
 * aus zwei Teilen: einem Befehlswort und einem String.
 * 
 * Befehle werden von Benutzern dieser Klasse auf Gültigkeit
 * überprüft. Wenn ein Spieler einen ungültigen Befehl eingegeben
 * hat (ein unbekanntes Wort als Befehl), dann ist das Befehlswort UNKNOWN.
 *
 * Wenn der Befehl nur aus einem Wort bestand, dann ist das
 * zweite Wort <null>.
 * 
 * @author (Michael Kölling, David J. Barnes, Nicolas Lyer, Leif Bremer)
 * @version (Version 1, 24.05.2024)
 */

class Befehl
{
    private Befehlswort befehlswort;
    private String zweitesWort;

    /**
     * Konstruktor Befehl
     * 
     * Erzeuge ein Befehlsobjekt. beide Parameter müssen angegeben werden,
     * aber der zweite darf 'null' sein.
     * 
     * @param befehlswort das Befehlswort. UNKNOWN, wenn dieser Befehl nicht
     *                   vom Spiel erkannt wurde.
     * @param zweitesWort Das zweite Wort des Befehls. Darf null sein.
     */
    public Befehl(Befehlswort befehlswort, String zweitesWort)
    {
        this.befehlswort = befehlswort;
        this.zweitesWort = zweitesWort;
    }

    /**
     * Methode Befehlswort
     * 
     * Liefere das Befehlswort (das erste Wort) dieses Befehls.
     * Wenn der Befehl nicht verstanden wurde, ist das Ergebnis
     * UNKNOWN.
     * 
     * @return das Befehlswort.
     */
    public Befehlswort gibBefehlswort()
    {
        return befehlswort;
    }

    /**
     * Methode gibZweitesWort
     * 
     * @return Das zweite Wort dieses Befehls. Liefere 'null', wenn
     * es kein zweites Wort gab.
     */
    public String gibZweitesWort()
    {
        return zweitesWort;
    }

    /**
     * Methode istUnbekannt
     * 
     * @return 'true', wenn dieser Befehl nicht verstanden wurde.
     */
    public boolean istUnbekannt()
    {
        return (befehlswort == Befehlswort.UNKNOWN);
    }

    /**
     * Methode hatZweitesWort
     * 
     * @return 'true', wenn dieser Befehl ein zweites Wort hat.
     */
    public boolean hatZweitesWort()
    {
        return (zweitesWort != null);
    }
}

