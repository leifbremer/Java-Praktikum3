import java.util.HashMap;

/**
 * Diese Klasse h�lt eine Aufz�hlung aller Befehlsw�rter, die der Spieler 
 * eingeben kann. Mit ihrer Hilfe werden eingetippte Befehle erkannt. <br>
 * (Wolfgang Renz:) Sie werden jeweils einem reservierten
 * Befehlswort zugeordnet. <br> 
 * So k�nnten also verschiedene sprachliche Befehle dem Befehlswor.QUIT
 * zugeordnet werden, z.B. "ade", "ciao", "quit".<br>
 * Ebenfalls kann der Spieler auf diese Weise Befehle in unterschiedlichen
 * Sprachen geben, z.B. "go", "walk", "gehe", "nach".<br>
 * Auf diese Weise gewinnt man durch Nutzung von enum Befehlswort Flexibilit�t.
 *
 * @author  Michael K�lling und David J. Barnes, Wolfgang Renz
 * @version 31.07.2011, April 2014
 */

class Befehlswoerter
{
    // eine Abbildung von Befehlsw�rtern auf Elemente des 
    // Aufz�hlungstyps Befehlswort
    private HashMap<String, Befehlswort> gueltigeBefehle;

    /**
     * Konstruktor - initialisiere die Befehlsw�rter.
     */
    public Befehlswoerter()
    {
        gueltigeBefehle = new HashMap<String, Befehlswort>();
        gueltigeBefehle.put("nach", Befehlswort.GO);
        gueltigeBefehle.put("go", Befehlswort.GO);
        gueltigeBefehle.put("hilf", Befehlswort.HELP);
        gueltigeBefehle.put("help", Befehlswort.HELP);        
        gueltigeBefehle.put("ciao", Befehlswort.QUIT);
        gueltigeBefehle.put("quit", Befehlswort.QUIT);
        gueltigeBefehle.put("read", Befehlswort.READ);
        gueltigeBefehle.put("inv", Befehlswort.INV);
        gueltigeBefehle.put("take", Befehlswort.TAKE);
        gueltigeBefehle.put("write", Befehlswort.WRITE);
        gueltigeBefehle.put("repair", Befehlswort.REPAIR);
    }

    /**
     * Finde das Befehlswort, das mit einem Befehls-String verkn�pft ist.
     * @param befehlswort das nachzuschlagende Wort (als String)
     * @return Das zugeh�rige Befehlswort zum dem Wort oder UNKNOWN,
     *         wenn das Wort kein g�ltiges Befehlswort ist.
     */
    public Befehlswort gibBefehlswort(String wort)
    {
        Befehlswort befehlswort = gueltigeBefehle.get(wort);
        if(befehlswort != null) {
            return befehlswort;
        }
        else {
            return Befehlswort.UNKNOWN;
        }
    }

    /**
     * Pr�fe, ob eine gegebene Zeichenkette ein g�ltiger
     * Befehl ist.
     * @return 'true', wenn die gegebene Zeichenkette ein g�ltiger
     * Befehl ist, 'false' sonst.
     */
    public boolean istBefehl(String eingabe)
    {
        return gueltigeBefehle.containsKey(eingabe);
    }

    /**
     * Gib alle g�ltigen Befehlsw�rter auf die Konsole aus.
     */
    public void alleAusgeben() 
    {
        for(String befehl : gueltigeBefehle.keySet()) {
            System.out.print(befehl + "  ");
        }
        System.out.println();
    }
}
