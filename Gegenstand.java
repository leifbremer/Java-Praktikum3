/**
 * Klasse Gegenstand
 * 
 * Abstrakte Klasse, die einen Gegenstand im Spiel repräsentiert.
 * Die anderen Gegenstände Kaputt, Wertkzeug, Hinweis und Eingabe können von der Klasse erben.
 * 
 * @author (Nicolas Lyer, Leif Bremer) 
 * @version (Version 1, 24.05.2024)
 */
public abstract class Gegenstand
{
    /**
     * Methode benutzen
     *
     * Der Gegenstand kann benutzt werden.
     *
     * @return Eine Ausgabe, dass der Gegenstand nicht benutzt werden kann.
     */
    public String benutzen(){
        return "Sie können das nicht benutzen";
    }

    /**
     * Methode eingeben
     * 
     * Eine Methode um etwas in den Gegenstand einzugeben.
     *
     * @return 'false' wenn keine Eingabe erfolgt.
     */
    public boolean eingeben(){
        return false;
    }

    /**
     * Methode getWo
     * 
     * Eine Methode, um den Raum des Gegenstandes zu erhalten.
     * 
     * @return 'null'.
     */
    public Raum getWo(){
        return null;
    }

    /**
     * Methode reparieren
     *
     * Eine Methode, um einen Gegenstand zu reparieren.
     *
     */
    public void reparieren(){

    }

    /**
     * Methode gibWerkzeug
     *
     * Eine Methode, die das Werkzeug für die Reparatur erhält.
     *
     * @return 'null'.
     */
    public Gegenstand gibWerkzeug(){
        return null;
    }

    /**
     * Methode aufheben
     *
     * Eine Methode, um den Gegenstand aufzuheben.
     *
     * @return 'false'.
     */
    public boolean aufheben(){
        return false;
    }
}