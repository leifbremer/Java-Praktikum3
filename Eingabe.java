
/**
 * Beschreiben Sie hier die Klasse Eingabe.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Eingabe extends Gegenstand
{
    private String schluessel;
    
    public Eingabe(String schluessel){
        this.schluessel = schluessel;
    }
    
    public String benutzen(){
        return "Sie können hier etwas eingeben";
    }
    
    private boolean vergleicheSchluessel(String schluessel){
        if(this.schluessel.equals(schluessel)){
            return true;
        }
        return false;
    }
}
