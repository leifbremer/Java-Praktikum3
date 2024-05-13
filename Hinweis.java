
/**
 * Beschreiben Sie hier die Klasse Information.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Hinweis extends Gegenstand
{
    private String hinweis;

    public Hinweis(String hinweis){
        this.hinweis = hinweis;
    }

    public String benutzen(){
        return hinweis;
    }
    
    
}
