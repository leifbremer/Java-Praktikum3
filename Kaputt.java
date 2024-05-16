
/**
 * Beschreiben Sie hier die Klasse Kaputt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kaputt extends Gegenstand
{
    boolean kaputt;
    private Gegenstand werkzeug;
    
    public Kaputt(Gegenstand werkzeug)
    {
        kaputt = true;
        this.werkzeug = werkzeug;
    }
    
    public String benutzen()
    {
        if (kaputt){
            return "Sie müssen hier etwas reparieren.";
        } else{
            return "Hier ist nichts zu tun.";
        }
    }
    
    public Gegenstand gibWerkzeug(){
        return werkzeug;
    }
    
    public void reparieren()
    {
        kaputt = false;
    }
}
