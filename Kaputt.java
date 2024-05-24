/**
 * Klasse Kaputt
 * 
 * Die Klasse ist repr�sentativ f�r einen kaputten Gegenstand, der repariert werden muss.
 * Erbt von der Klasse Gegenstand
 * 
 * @author (Nicolas Lyer, Bremer) 
 * @version (Version 1, 24.05.2024)
 */
public class Kaputt extends Gegenstand
{
    boolean kaputt;
    private Gegenstand werkzeug;
    
    /**
     * Kaputt Konstruktor
     *
     * Initialisiert das Objekt als kaputt,
     * setzt das ben�tigte Werkzeug.
     *
     * @param werkzeug Das Werkzeug, das zur Reparatur des Gegenstands ben�tigt wird
     */
    public Kaputt(Gegenstand werkzeug)
    {
        kaputt = true;
        this.werkzeug = werkzeug;
    }
    
    /**
     * Methode benutzen
     *
     * Methode zum Benutzen des kaputten Gegenstandes.
     *
     * @return Ausgabe, ob der Gegenstand repariert werden muss oder nicht. 
     */
    public String benutzen()
    {
        if (kaputt){
            return "Sie m�ssen hier etwas reparieren.";
        } else{
            return "Hier ist nichts zu tun.";
        }
    }
    
    /**
     * Methode gibWerkzeug
     *
     * Die Methode gibt das Werkzeug zur�ck, das zur Reparatur des Gegenstands ben�tigt wird.
     *
     * @return Das Werkzeug, das zur Reparatur des Gegenstands ben�tigt wird.
     */
    public Gegenstand gibWerkzeug(){
        return werkzeug;
    }
    
    /**
     * Methode reparieren
     *
     * Repariert den Gegenstand, indem kaputt auf 'false' gesetzt wird.
     */
    public void reparieren()
    {
        kaputt = false;
    }
}
