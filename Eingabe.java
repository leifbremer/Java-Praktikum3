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
    private Raum raumVon;
    
    public Eingabe(String schluessel, Raum raumVon){
        this.schluessel = schluessel;
        this.raumVon = raumVon;
    }
    
    public String benutzen(){
        return "Sie können hier etwas eingeben";
    }
    
    public boolean eingeben(){
        Scanner leser = new Scanner(System.in);
        System.out.print("> ");
        return vergleicheSchluessel(leser.nextLine());
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
