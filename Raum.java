import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.HashMap;

/**
 * Diese Klasse modelliert R�ume in der Welt von Zuul.
 * 
 * Ein "Raum" repr�sentiert einen Ort in der virtuellen Landschaft des
 * Spiels. Ein Raum ist mit anderen R�umen �ber Ausg�nge verbunden.
 * F�r jeden existierenden Ausgang h�lt ein Raum eine Referenz auf 
 * den benachbarten Raum.
 * 
 * @author  Michael K�lling und David J. Barnes
 * @version 31.07.2011
 */

class Raum 
{
    private String beschreibung;
    private TreeMap<String, Raum> ausgaenge;        // die Ausg�nge dieses Raums
    private HashMap<String, Gegenstand> gegenstaende;

    /**
     * Erzeuge einen Raum mit einer Beschreibung. Ein Raum
     * hat anfangs keine Ausg�nge.
     * @param beschreibung enth�lt eine Beschreibung in der Form
     *        "in einer K�che" oder "auf einem Sportplatz".
     */
    public Raum(String beschreibung) 
    {
        this.beschreibung = beschreibung;
        ausgaenge = new TreeMap<String, Raum>();
        gegenstaende = new HashMap<String, Gegenstand>();
    }

    /**
     * Definiere einen Ausgang f�r diesen Raum.
     * @param richtung die Richtung, in der der Ausgang liegen soll
     * @param nachbar der Raum, der �ber diesen Ausgang erreicht wird
     */
    public void setzeAusgang(String richtung, Raum nachbar) 
    {
        ausgaenge.put(richtung, nachbar);
    }

    public void fuegeGegenstandHinzu(String name, Gegenstand gegenstand){
        gegenstaende.put(name, gegenstand);
    }

    /**
     * @return die kurze Beschreibung dieses Raums (die dem Konstruktor
     * �bergeben wurde).
     */
    public String gibKurzbeschreibung()
    {
        return beschreibung;
    }

    /**
     * Liefere eine lange Beschreibung dieses Raums, in der Form:
     *     Sie sind in der K�che.
     *     Ausg�nge: nord west
     * @return eine lange Beschreibung dieses Raumes.
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
     * Liefere eine Zeichenkette, die die Ausg�nge dieses Raums
     * beschreibt, beispielsweise
     * "Ausg�nge: north west".
     * @return eine Beschreibung der Ausg�nge dieses Raumes.
     */
    private String gibAusgaengeAlsString()
    {
        String ergebnis = "Ausg�nge:";
        Set<String> keys = ausgaenge.keySet();
        for(String ausgang : keys){
            ergebnis += " " + ausgang;
        }
        return ergebnis;
    }

    /**
     * Liefere den Raum, den wir erreichen, wenn wir aus diesem Raum
     * in die angegebene Richtung gehen. Liefere 'null', wenn in
     * dieser Richtung kein Ausgang ist.
     * @param richtung die Richtung, in die gegangen werden soll.
     * @return den Raum in der angegebenen Richtung.
     */
    public Raum gibAusgang(String richtung) 
    {
        return ausgaenge.get(richtung);
    }
    
    public Gegenstand gibGegenstand(String gegenstand)
    {
        return gegenstaende.get(gegenstand);
    }
}

