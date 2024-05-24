/**
 * Klasse Werkzeug
 * 
 * Repräsentiert ein Werkzeug, das vom User verwendet werden kann.
 * Sie erbt von der Klasse Gegenstand.
 * 
 * @author (Nicolas Lyer, Leif Bremer) 
 * @version (Version 1, 24.05.2024)
 */
public class Werkzeug extends Gegenstand
{    
    /**
     * Methode benutzen
     *
     * Methode zur Benutzung des Werkzeugs.
     * Ausgabe, dass der Gegenstand hier nicht benutzt werden kann.
     *
     * @return Die Nachricht, dass der Gegenstand hier nicht benutzt werden kann.
     */
    public String benutzen(){
        return "Sie können diesen Gegenstand hier nicht benutzen";
    }
    
    /**
     * Methode aufheben
     *
     * Methode zum Aufheben des Werkzeugs.
     *
     * @return 'true'.
     */
    public boolean aufheben(){
        return true;
    }
}
