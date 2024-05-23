/**
 * Beschreiben Sie hier die Klasse TuerRaum.
 * 
 * @author (Nicolas Lyer) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TuerRaum extends Raum
{
    //Variable für Richtung der geschlossenen Tuer
    private String richtung;
    
    //Variable zum Speichern des Raumes hinter der Tuer
    private Raum nachbar;
    
    //Boolean zum überprüfen ob die Tuer bereits offen ist
    private boolean offen;

    /**
     * Konstruktor TuerRaum
     * 
     * @param beschreibung für Beschreibung des Raumes
     * 
     */
    public TuerRaum(String beschreibung)
    {
        super(beschreibung);
        offen = false;
    }

    /**
     * Methode setzeAusgangZu
     *
     * @param richtung Richtung fuer geschlossenen Ausgang
     * @param nachbar Raum hinter geschlossener Tuer
     * 
     * setze Raum und verschlossene Tuer
     */
    public void setzeAusgangZu(String richtung, Raum nachbar)
    {
        this.richtung = richtung;
        this.nachbar = nachbar;
    }

    /**
     * Methode oeffneAusgang
     *
     * oeffne die geschlossene Tuer indem die Parameter in die normale Map fuer
     * Raume eingetragen werden
     */
    public void oeffneAusgang()
    {
        ausgaenge.put(richtung, nachbar);
        offen = true;
    }

    /**
     * Methode gibAusgaengeAlsString
     *
     * ueberschreibe die Methode der Superklasse, um auch die verschlossenen 
     * Tueren auszugeben
     * @return Ausgabe String
     */
    @Override
    protected String gibAusgaengeAlsString()
    {
        String ergebnis;
        ergebnis = super.gibAusgaengeAlsString();
        if(!offen){
            ergebnis += "Verschlossene Tür:" + richtung;
        }
        return ergebnis;
    }
}
