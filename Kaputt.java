/**
 * Klasse Kaputt
 * 
 * Die Klasse ist repräsentativ für einen kaputten Gegenstand, der repariert werden muss.
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
     * setzt das benötigte Werkzeug.
     *
     * @param werkzeug Das Werkzeug, das zur Reparatur des Gegenstands benötigt wird
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
            return "Sie müssen hier etwas reparieren.";
        } else{
            return "Hier ist nichts zu tun.";
        }
    }
    
    /**
     * Methode gibWerkzeug
     *
     * Die Methode gibt das Werkzeug zurück, das zur Reparatur des Gegenstands benötigt wird.
     *
     * @return Das Werkzeug, das zur Reparatur des Gegenstands benötigt wird.
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
