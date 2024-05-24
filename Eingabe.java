import java.util.Scanner;
import java.util.HashMap;

/**
 * Klasse Eingabe
 * 
 * Repr�sentativ f�r einen Gegenstand, der eine Benutzereingabe durchf�hrt.
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
     * Initialisiert Schl�sse, Ausgangsraum und Abfrage.
     *
     * @param schluessel Der Schl�ssel, der f�r die erfolgreiche Eingabe erforderlich ist.
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
     * Ausgabe, dass eine Eingabe m�glich ist.
     *
     * @return Eine Nachricht, die anzeigt, dass eine Eingabe m�glich ist.
     */
    public String benutzen(){
        return "Sie k�nnen hier etwas eingeben";
    }
    
    /**
     * Methode eingeben
     *
     * Methode f�r die Benutzereingabe.
     * F�hrt die Benutzereingabe durch und �berpr�ft,
     * ob sie mit dem richtigen Schl�ssel entspricht.
     *
     * @return 'true' bei richtigem Schl�ssel, sonst 'false'.
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
     * Gibt den Raum, in der die Eingabe stattfand zur�ck.
     *
     * @return Der Raum, in der die Eingabe stattfand zur�ck.
     */
    public Raum getWo(){
        return raumVon;
    }
    
    /**
     * Methode vergleicheSchluessel
     *
     * Vergleicht die Benutzereingabe mit dem erwarteten Schl�ssel.
     *
     * @param schluessel Der vom User eingegebene Schl�ssel
     * @return 'true' bei richtigem Schl�ssel, sonst 'false'.
     */
    private boolean vergleicheSchluessel(String schluessel){
        if(this.schluessel.equals(schluessel)){
            return true;
        }
        return false;
    }
}
