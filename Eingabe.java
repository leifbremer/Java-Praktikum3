import java.util.Scanner;
import java.util.HashMap;

/**
 * Klasse Eingabe
 * 
 * Repräsentativ für einen Gegenstand, der eine Benutzereingabe durchführt.
 * 
 * @author (Nicolas Lyer, Leif Bremer) 
 * @version (Version 1, 24.05.2024)
 */
public class Eingabe extends Gegenstand
{
    private String schluessel;
    private Raum raumVon;
    private String abfrage;
    
    /**
     * Eingabe Konstruktor
     * 
     * Initialisiert Schlüsse, Ausgangsraum und Abfrage.
     *
     * @param schluessel Der Schlüssel, der für die erfolgreiche Eingabe erforderlich ist.
     * @param raumVon Der Raum, aus dem die Eingabe erfolgt.
     * @param abfrage Die Abfrage, die dem Benutzer gestellt wird.
     */
    public Eingabe(String schluessel, Raum raumVon, String abfrage){
        this.schluessel = schluessel;
        this.raumVon = raumVon;
        this.abfrage = abfrage; 
    }
    
    /**
     * Methode benutzen
     *
     * Benutzung des Eingabegegenstandes.
     * Ausgabe, dass eine Eingabe möglich ist.
     *
     * @return Eine Nachricht, die anzeigt, dass eine Eingabe möglich ist.
     */
    public String benutzen(){
        return "Sie können hier etwas eingeben";
    }
    
    /**
     * Methode eingeben
     *
     * Methode für die Benutzereingabe.
     * Führt die Benutzereingabe durch und überprüft,
     * ob sie mit dem richtigen Schlüssel entspricht.
     *
     * @return 'true' bei richtigem Schlüssel, sonst 'false'.
     */
    public boolean eingeben(){
        Scanner leser = new Scanner(System.in);
        System.out.println(abfrage);
        System.out.print("> ");
        return vergleicheSchluessel(leser.nextLine());
    }

    /**
     * Methode getWo
     * 
     * Gibt den Raum, in der die Eingabe stattfand zurück.
     *
     * @return Der Raum, in der die Eingabe stattfand zurück.
     */
    public Raum getWo(){
        return raumVon;
    }
    
    /**
     * Methode vergleicheSchluessel
     *
     * Vergleicht die Benutzereingabe mit dem erwarteten Schlüssel.
     *
     * @param schluessel Der vom User eingegebene Schlüssel
     * @return 'true' bei richtigem Schlüssel, sonst 'false'.
     */
    private boolean vergleicheSchluessel(String schluessel){
        if(this.schluessel.equals(schluessel)){
            return true;
        }
        return false;
    }
}
