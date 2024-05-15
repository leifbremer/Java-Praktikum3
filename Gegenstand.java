
/**
 * Beschreiben Sie hier die Klasse Gegenstand.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class Gegenstand
{
    public String benutzen(){
        return "NICHT IMPLEMENTIERT";
    }
    
    public boolean eingeben(){
        return false;
    }
    
    public String getKey(){
        return null;
    }
    
    public Raum getValue(){
        return null;
    }
    
    public Raum getWo(){
        return null;
    }
    
    public boolean aufheben(){
        return false;
    }
}
