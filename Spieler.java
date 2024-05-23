import java.util.HashMap;

/**
 *  Dies ist die Hauptklasse der Anwendung "Die Welt von Zuul".
 *  "Die Welt von Zuul" ist ein sehr einfaches, textbasiertes
 *  Adventure-Game. Ein Spieler kann sich in einer Umgebung bewegen,
 *  mehr nicht. Das Spiel sollte auf jeden Fall ausgebaut werden,
 *  damit es interessanter wird!
 * 
 *  Zum Spielen muss eine Instanz dieser Klasse erzeugt werden und
 *  an ihr die Methode "spielen" aufgerufen werden.
 * 
 *  Diese Instanz dieser Klasse erzeugt und initialisiert alle
 *  anderen Objekte der Anwendung: Sie legt alle Räume und einen
 *  Parser an und startet das Spiel. Sie wertet auch die Befehle
 *  aus, die der Parser liefert und sorgt für ihre Ausführung.
 * 
 * @author  Michael Kölling und David J. Barnes
 * @version 31.07.2011
 * 
 * Hallo Test 23
 * 
 */

class Spieler 
{
    private Parser parser;
    private Raum aktuellerRaum;
    private HashMap<String,Gegenstand> inventar;
    private int zuege;
    /**
     * Erzeuge ein Spiel und initialisiere die interne Raumkarte.
     */
    public Spieler() 
    {
        aktuellerRaum = new Spielumgebung().raeumeAnlegen();
        parser = new Parser();
        inventar = new HashMap<String, Gegenstand>();
        zuege = 30;
    }

    /**
     * Die Hauptmethode zum Spielen. Läuft bis zum Ende des Spiels
     * in einer Schleife.
     */
    public void spielen() 
    {            
        willkommenstextAusgeben();

        // Die Hauptschleife. Hier lesen wir wiederholt Befehle ein
        // und führen sie aus, bis das Spiel beendet wird.

        boolean beendet = false;
        while (! beendet && zuege != 0) {
            zuege--;
            Befehl befehl = parser.liefereBefehl();
            beendet = verarbeiteBefehl(befehl);
        }
        if (zuege == 0){
            System.out.println("BUUMMM. Der Reaktor ist in die Luft geflogen. Sie haben Verloren. Versuchen Sie es doch nochmal.");
        }
        System.out.println("Danke für dieses Spiel. Auf Wiedersehen.");
        
    }

    /**
     * Einen Begrüßungstext für den Spieler ausgeben.
     */
    private void willkommenstextAusgeben()
    {
        System.out.println();
        System.out.println("Willkommen!");
        System.out.println("Sie befinden sich in einem Reaktor.");
        System.out.println("KRRRCH KRRRCH! Oh Nein, hören Sie das? Der Reaktor droht in die Luft zu gehen!");
        System.out.println("Sie müssen den Reaktor reparieren bevor alles in die Luft fliegt!");
        System.out.println("Aber sein Sie vorsichtig! Sie haben nur 30 Züge. Wählen Sie also mit Bedacht.");
        System.out.println("Tippen sie 'help', wenn Sie Hilfe brauchen.");
        System.out.println();
        System.out.println(aktuellerRaum.gibLangeBeschreibung());
    }

    /**
     * Verarbeite einen gegebenen Befehl (führe ihn aus).
     * @param befehl Der zu verarbeitende Befehl.
     * @return 'true', wenn der Befehl das Spiel beendet, 'false' sonst.
     */
    private boolean verarbeiteBefehl(Befehl befehl) 
    {
        boolean moechteBeenden = false;

        Befehlswort befehlswort = befehl.gibBefehlswort();

        switch(befehlswort) { 
            case UNKNOWN:
            System.out.println("Ich weiss nicht, was Sie meinen. Wenn Sie Probleme haben nutzen Sie 'help'.");
            break;

            case HELP:
            hilfstextAusgeben();
            break;

            case GO:
            wechsleRaum(befehl);
            break;

            case READ:
            benutzen(befehl);
            break;
            
            case INV:
            inventar();    
            break;    
            
            case WRITE:
            write(befehl);
            break;
            
            case TAKE:
            take(befehl);
            break;
            
            case REPAIR:
            moechteBeenden = reparieren(befehl);
            break;
            
            case QUIT:
            moechteBeenden = beenden(befehl);
            break;
        }
        // ansonsten: Befehl nicht erkannt.
        return moechteBeenden;
    }

    // Implementierung der Benutzerbefehle:

    /**
     * Gib Hilfsinformationen aus.
     * Hier geben wir eine etwas alberne und unklare Beschreibung
     * aus, sowie eine Liste der Befehlswörter.
     */
    private void hilfstextAusgeben() 
    {
        System.out.println("Sie müssen den Reaktor reparieren.");
        System.out.println("Anzahl verbleibender Züge: " + zuege);
        System.out.println("\t");
        System.out.println("Ihnen stehen folgende Befehle zur Verfügung:");
        parser.zeigeBefehle();
    }

    /**
     * Versuche, in eine Richtung zu gehen. Wenn es einen Ausgang gibt,
     * wechsele in den neuen Raum, ansonsten gib eine Fehlermeldung
     * aus.
     */
    private void wechsleRaum(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
            // Gibt es kein zweites Wort, wissen wir nicht, wohin...
            System.out.println("Wohin möchten Sie gehen?");
            return;
        }

        String richtung = befehl.gibZweitesWort();

        // Wir versuchen, den Raum zu verlassen.
        Raum naechsterRaum = aktuellerRaum.gibAusgang(richtung);

        if (naechsterRaum == null) {
            System.out.println("Sie können da nicht durch!");
        }
        else {
            aktuellerRaum = naechsterRaum;
            System.out.println(aktuellerRaum.gibLangeBeschreibung());
        }
    }

    private void benutzen(Befehl befehl)
    {
        Gegenstand gegenstand = aktuellerRaum.gibGegenstand(befehl.gibZweitesWort());
        
        if(null == gegenstand) {
            System.out.println("Was möchten Sie benutzen?");
            return;
        }
        
        System.out.println(gegenstand.benutzen());
    }
    
    private void write(Befehl befehl)
    {
        boolean erfolg;
        Gegenstand gegenstand = aktuellerRaum.gibGegenstand(befehl.gibZweitesWort());
        
        if(null == gegenstand) {
            System.out.println("Wo möchten Sie etwas eingeben?");
            return;
        }
        
        erfolg = gegenstand.eingeben();
        
        if(erfolg){
            Raum raum = (TuerRaum) gegenstand.getWo();
            raum.oeffneAusgang();
        }
        
        else{
            System.out.println("Das hat leider nicht funktioniert");
        }
    }
    
    private void take(Befehl befehl)
    {
        Gegenstand gegenstand = aktuellerRaum.gibGegenstand(befehl.gibZweitesWort());
        
        if(null == gegenstand) {
            System.out.println("Dieser Gegenstand ist hier nicht.");
            return;
        }
        
        if(gegenstand.aufheben()){
            inventar.put(befehl.gibZweitesWort(),gegenstand);
            aktuellerRaum.removeItem(befehl.gibZweitesWort());
            return;
        }
        
        System.out.println("Das können Sie nicht aufheben");
    }
    private boolean reparieren(Befehl befehl)
    {
        Gegenstand zuReparieren = aktuellerRaum.gibGegenstand(befehl.gibZweitesWort());
        Gegenstand werkzeug;
        if(zuReparieren == null){
            System.out.println("Der Gegenstand befindet sich nicht in diesem Raum.");
            return false;
        }
        
        werkzeug = zuReparieren.gibWerkzeug();
        if(werkzeug == null){
            System.out.println("Das können Sie nicht reparieren");
            return false;
        }
        
        for(String s : inventar.keySet()){
            if(inventar.get(s).equals(werkzeug)){
                zuReparieren.reparieren();
                System.out.println("Sie haben gewonnen.");
                return true;
            }
        }
        
        System.out.println("Sie haben nicht das nötige Werkzeug.");
        return false;
    }
    
    private void inventar()
    {
        System.out.println("Sie haben folgende Gegenstände: ");
        System.out.println();
        for(String gegenstand : inventar.keySet()){
            System.out.println(gegenstand + "  ");
        }
    }
    
    /**
     * "quit" wurde eingegeben. Überprüfe den Rest des Befehls,
     * ob das Spiel wirklich beendet werden soll.
     * @return 'true', wenn der Befehl das Spiel beendet, 'false' sonst.
     */
    private boolean beenden(Befehl befehl) 
    {
        if(befehl.hatZweitesWort()) {
            System.out.println("Was soll beendet werden??");
            return false;
        }
        else {
            return true;  // Das Spiel soll beendet werden.
        }
    }
}
