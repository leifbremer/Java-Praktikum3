import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.HashMap;

/**
 * Klasse Raum
 * 
 * Ein "Raum" repr�sentiert einen Ort in der virtuellen Landschaft des
 * Spiels. Ein Raum ist mit anderen R�umen �ber Ausg�nge verbunden.
 * F�r jeden existierenden Ausgang h�lt ein Raum eine Referenz auf 
 * den benachbarten Raum.
 * 
 * @author (Nicolas Lyer, Leif Bremer) 
 * @version (Version 1, 24.05.2024)
 */

class Raum 
{
    protected String beschreibung; // Die Beschreibung dieses Raums.
    protected TreeMap<String, Raum> ausgaenge; // Die Ausg�nge dieses Raumes.
    private HashMap<String, Gegenstand> gegenstaende; // Die Gegenst�nde in diesem Raum.

    /**
     * Konstruktor Raum 
     *
     * Erzeuge einen Raum mit einer Beschreibung. Ein Raum
     * hat anfangs keine Ausg�nge.
     * 
     * @param beschreibung Die Beschreibung des Raums.
     */
    public Raum(String beschreibung) 
    {
        this.beschreibung = beschreibung;
        ausgaenge = new TreeMap<String, Raum>();
        gegenstaende = new HashMap<String, Gegenstand>();
    }

    /**
     * Methode setzeAusgang
     * 
     * Definiert einen Ausgang f�r diesen Raum.
     * 
     * @param richtung Die Richtung, in der der Ausgang liegen soll.
     * @param nachbar Der Raum, der �ber diesen Ausgang erreicht wird.
     */
    public void setzeAusgang(String richtung, Raum nachbar) 
    {
        ausgaenge.put(richtung, nachbar);
    }
    
    /**
     * Methode removeItem
     *
     * Entfernt einen Gegenstand aus dem Raum.
     *
     * @param name Der Name des zu entfernenden Gegenstands.
     */
    public void removeItem(String name)
    {
        gegenstaende.remove(name);
    }

    /**
     * Methode setzeAusgangZu
     *
     * Setzt einen Ausgang zu einem anderen Raum.
     * Wird verwendet, wenn ein Ausgang verschlossen ist.
     *
     * @param richtung Die Richtung des Ausgangs.
     * @param nachbar Der Raum, zu dem der Ausgang f�hren soll.
     */
    public void setzeAusgangZu(String richtung, Raum nachbar)
    {
        System.out.println("Das verschlie�en der T�r hat nicht funktioniert.");
        ausgaenge.put(richtung, nachbar);
    }
    
    /**
     * Methode fuegeGegenstandHinzu
     *
     * F�gt dem Raum einen Gegenstand hinzu.
     *
     * @param name Der Name des Gegenstands.
     * @param gegenstand Der Gegenstand, der dem Raum hinzugef�gt werden soll.
     */
    public void fuegeGegenstandHinzu(String name, Gegenstand gegenstand){
        gegenstaende.put(name, gegenstand);
    }

    /**
     * Methode gibKurzbeschreibung
     * 
     * Gibt die kurze Beschreibung dieses Raums zur�ck.
     * 
     * @return Die kurze Beschreibung dieses Raums (die dem Konstruktor
     * �bergeben wurde).
     */
    public String gibKurzbeschreibung()
    {
        return beschreibung;
    }

    /**
     * Methode gibLangeBeschreibung
     * 
     * Gibt eine lange Beschreibung dieses Raums zur�ck.
     * 
     * @return Eine lange Beschreibung dieses Raumes.
     */
    public String gibLangeBeschreibung()
    {
        String ergebnis = "Sie sind " + beschreibung + ".\n" + gibAusgaengeAlsString() + "\n";
        Set<String> keys = gegenstaende.keySet();
        if (0 != keys.size()){
            ergebnis += "Es befinden sich folgende Objekte im Raum:\n";
            for (String gegenstand : keys){
                ergebnis += gegenstand + " ";
            }
        }
        return ergebnis;
    }

    /**
     * Methode oeffneAusgang
     *
     * �ffnet einen Ausgang aus diesem Raum.
     * Gibt aus, dass der Raum nicht implementiert ist.
     */
    public void oeffneAusgang(){
        System.out.println("NICHT IMPLEMENTIERT");
    }
    
    /**
     * Methode gibAusgaengeAlsString
     * 
     * Gibt eine Beschreibung der Ausg�nge dieses Raums zur�ck.
     * 
     * @return Eine Beschreibung der Ausg�nge dieses Raumes.
     */
    protected String gibAusgaengeAlsString()
    {
        String ergebnis = "Ausg�nge:";
        Set<String> keys = ausgaenge.keySet();
        for(String ausgang : keys){
            ergebnis += " " + ausgang;
        }
        return ergebnis;
    }

    /**
     * Methode gibAusgang
     * 
     * Liefert den Raum, den wir erreichen, wenn wir aus diesem Raum
     * in die angegebene Richtung gehen.
     * Liefert 'null', wenn in
     * dieser Richtung kein Ausgang ist.
     * 
     * @param richtung Die Richtung, in die gegangen werden soll.
     * @return Den Raum in der angegebenen Richtung.
     */
    public Raum gibAusgang(String richtung) 
    {
        return ausgaenge.get(richtung);
    }
    
    /**
     * Methode gibGegenstand
     *
     * Gibt den Gegenstand mit dem angegebenen Namen zur�ck, der sich im Raum befindet.
     *
     * @param gegenstand Der Name des gesuchten Gegenstands.
     * @return Der Gegenstand mit dem angegebenen Namen.
     */
    public Gegenstand gibGegenstand(String gegenstand)
    {
        return gegenstaende.get(gegenstand);
    }
}