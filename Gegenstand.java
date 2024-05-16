
/**
 * Beschreiben Sie hier die Klasse Gegenstand.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class Gegenstand
{
    public String benutzen(){
        return "Sie können das nicht benutzen";
    }

    public boolean eingeben(){
        return false;
    }

    public Raum getWo(){
        return null;
    }

    public void reparieren(){

    }

    public Gegenstand gibWerkzeug(){
        return null;
    }

    public boolean aufheben(){
        return false;
    }
}
