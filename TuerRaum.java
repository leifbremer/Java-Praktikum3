/**
 * Beschreiben Sie hier die Klasse TuerRaum.
 * 
 * @author (Nicolas Lyer) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TuerRaum extends Raum
{
    private String richtung;
    private Raum nachbar;
    private boolean offen;

    public TuerRaum(String beschreibung)
    {
        super(beschreibung);
        offen = false;
    }

    public void setzeAusgangZu(String richtung, Raum nachbar)
    {
        this.richtung = richtung;
        this.nachbar = nachbar;
    }

    public void oeffneAusgang()
    {
        ausgaenge.put(richtung, nachbar);
        offen = true;
    }

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
