/**
 * Klasse TuerRaum.
 * 
 * F�gt eine verschlossene T�r zu, die erst ge�ggemt werden muss,
 * bevor der Raum betreten werden kann.
 * 
 * @author (Nicolas Lyer, Leif Bremer) 
 * @version (Version 1, 24.05.2024)
 */
public class TuerRaum extends Raum
{
    //Variable f�r Richtung der geschlossenen T�r
    private String richtung;
    
    //Variable zum Speichern des Raumes hinter der T�r
    private Raum nachbar;
    
    //Boolean zum �berpr�fen ob die T�r bereits offen ist
    private boolean offen;

    /**
     * Konstruktor TuerRaum
     * 
     * Intitalisierung von TuerRaum mit einer Beschreibung.
     * standardm��ig geschlossen.
     * 
     * @param beschreibung F�r Beschreibung des Raumes
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
     * �ffne die geschlossene T�r indem die Parameter in die normale Map f�r
     * R�ume eingetragen werden.
     */
    public void oeffneAusgang()
    {
        ausgaenge.put(richtung, nachbar);
        offen = true;
    }

    /**
     * Methode gibAusgaengeAlsString
     *
     * �berschreibe die Methode der Superklasse, um auch die verschlossenen 
     * T�ren auszugeben.
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