/**
 * Klasse Hinweis
 * 
 * Repr�sentativ f�r einen Gegenstand, der einen Hinweis an den User enth�lt.
 * Erbt von der Klasse Gegenstand.
 * 
 * @author (Nicolas Lyer, Leif Bremer) 
 * @version (Version 1, 24.05.2024)
 */
public class Hinweis extends Gegenstand
{
    private String hinweis;

    /**
     * Hinweis Konstruktor
     *
     * Initialiesurung des Hinweisetextes.
     *
     * @param hinweis Der Hinweistext.
     */
    public Hinweis(String hinweis){
        this.hinweis = hinweis;
    }

    /**
     * Methode benutzen
     *
     * Gibt den Hinweistext zur�ck.
     *
     * @return Der Hinweistext.
     */
    public String benutzen(){
        return hinweis;
    }
}
