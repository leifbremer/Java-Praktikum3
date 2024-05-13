import java.util.Scanner;
import java.util.HashMap;

/**
 * Beschreiben Sie hier die Klasse Eingabe.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Eingabe extends Gegenstand
{
    private String schluessel;
    private String tuer;
    private Raum raumVon;
    private Raum raumZu;
    
    public Eingabe(String schluessel, String tuer, Raum raumZu, Raum raumVon){
        this.schluessel = schluessel;
        this.tuer = tuer;
        this.raumVon = raumVon;
        this.raumZu = raumZu;
    }
    
    public String benutzen(){
        return "Sie können hier etwas eingeben";
    }
    
    public boolean eingeben(){
        Scanner leser = new Scanner(System.in);
        System.out.print("> ");
        return vergleicheSchluessel(leser.nextLine());
    }
    
    public String getKey(){
        return tuer;
    }
    
    public Raum getValue(){
        return raumZu;
    }
    
    public Raum getWo(){
        return raumVon;
    }
    
    private boolean vergleicheSchluessel(String schluessel){
        if(this.schluessel.equals(schluessel)){
            return true;
        }
        return false;
    }
}
