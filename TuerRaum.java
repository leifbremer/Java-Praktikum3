/**
 * Klasse TuerRaum.
 * 
 * Fügt eine verschlossene Tür zu, die erst geöggemt werden muss,
 * bevor der Raum betreten werden kann.
 * 
 * @author (Nicolas Lyer, Leif Bremer) 
 * @version (Version 1, 24.05.2024)
 */
public class TuerRaum extends Raum
{
    //Variable für Richtung der geschlossenen Tür
    private String richtung;
    
    //Variable zum Speichern des Raumes hinter der Tür
    private Raum nachbar;
    
    //Boolean zum überprüfen ob die Tür bereits offen ist
    private boolean offen;

    /**
     * Konstruktor TuerRaum
     * 
     * Intitalisierung von TuerRaum mit einer Beschreibung.
     * standardmäßig geschlossen.
     * 
     * @param beschreibung Für Beschreibung des Raumes
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
     * setze Raum und verschlossene Tuer.
     *
     * @param richtung Richtung fuer geschlossenen Ausgang
     * @param nachbar Raum hinter geschlossener Tuer
     */
    public void setzeAusgangZu(String richtung, Raum nachbar)
    {
        this.richtung = richtung;
        this.nachbar = nachbar;
    }

    /**
     * Methode oeffneAusgang
     *
     * Öffne die geschlossene Tür indem die Parameter in die normale Map für
     * Räume eingetragen werden.
     */
    public void oeffneAusgang()
    {
        ausgaenge.put(richtung, nachbar);
        offen = true;
    }

    /**
     * Methode gibAusgaengeAlsString
     *
     * Überschreibe die Methode der Superklasse, um auch die verschlossenen 
     * Türen auszugeben.
     * 
     * @return Ausgabe String
     */
    @Override
    protected String gibAusgaengeAlsString()
    {
        String ergebnis;
        ergebnis = super.gibAusgaengeAlsString();
        if(!offen){
            ergebnis += "\nVerschlossener Ausgang:" + richtung;
        }
        return ergebnis;
    }
}