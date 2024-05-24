import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Dieser Parser liest Benutzereingaben und wandelt sie in
 * Befehle f�r das Reaktor-Spiel um. Bei jedem Aufruf
 * liest er eine Zeile von der Konsole und versucht, diese als
 * einen Befehl aus bis zu zwei W�rtern zu interpretieren. Er
 * liefert den Befehl als ein Objekt der Klasse Befehl zur�ck.
 * 
 * Der Parser verf�gt �ber einen Satz an bekannten Befehlen. Er
 * vergleicht die Eingabe mit diesen Befehlen. Wenn die Eingabe
 * keinen bekannten Befehl enth�lt, dann liefert der Parser ein als 
 * unbekannter Befehl gekennzeichnetes Objekt zur�ck.
 * 
 * @author (Michael K�lling, David J. Barnes, Nicolas Lyer, Leif Bremer)
 * @version (Version 2, 24.05.2024)
 */
class Parser 
{
    private Befehlswoerter befehle;  // h�lt die g�ltigen Befehlsw�rter
    private Scanner leser;         // Lieferant f�r eingegebene Befehle

    /**
     * Erzeuge einen Parser, der Befehle von der Konsole einliest.
     */
    public Parser() 
    {
        befehle = new Befehlswoerter();
        leser = new Scanner(System.in);
    }

    /**
     * Liest die n�chste Eingabezeile des Users ein.
     * Zerlegt sie in erstes Wort und zweites Wort.
     * Gibt den Befehl des Users zur�ck.
     * 
     * @return Den n�chsten Befehl des Benutzers.
     */
    public Befehl liefereBefehl() 
    {
        String eingabezeile;   // f�r die gesamte Eingabezeile
        String wort1 = null;
        String wort2 = null;

        System.out.print("> ");     // Eingabeaufforderung

        eingabezeile = leser.nextLine();
        
        // Finde bis zu zwei W�rter in der Zeile
        Scanner zerleger = new Scanner(eingabezeile);
        if(zerleger.hasNext()) {
            wort1 = zerleger.next();     // erstes Wort lesen
            if (zerleger.hasNext()) {
                wort2 = zerleger.next();    // zweites Wort lesen
                // Hinweis: Wir ignorieren den Rest der Eingabezeile.
            }
        }
        
        return new Befehl(befehle.gibBefehlswort(wort1), wort2);
    }

    /**
     * Methode zeigeBefehle
     *
     * Gibt eine Liste der bekannten Befehlsw�rter aus.
     */
    public void zeigeBefehle()
    {
        befehle.alleAusgeben();
    }
}
