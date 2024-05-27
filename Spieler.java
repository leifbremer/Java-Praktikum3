import java.util.HashMap;

/**
 * Klasse Spieler
 * 
 * Die Klasse Spieler repräsentiert den User des Spiels.
 * Die wichtigen Eigenschaften des Users werden in der Klasse verarbeitet.
 * Zu den Eigenschaften zählen der aktuelle Raum,
 * das Inventar und die Anzahl der verbleibenden Züge des Users.
 * 
 * @author (Michael Kölling, David J. Barnes, Nicolas Lyer, Leif Bremer)
 * @version (Version 2, 24.05.2024)
 */

class Spieler 
{
    private Parser parser;
    private Raum aktuellerRaum;
    private HashMap<String,Gegenstand> inventar;
    private int zuege;
    /**
     * Konstruktor Spieler.
     * 
     * Inititalisierung des aktuellen Raums, des Parsers, des Inventars
     * und der Anzahl der Züge des Users.
     */
    public Spieler() 
    {
        parser = new Parser();
        inventar = new HashMap<String, Gegenstand>();
    }

    /**
     * Methode spielen
     * 
     * Die Hauptmethode zum Spielen. Läuft bis zum Ende des Spiels
     * in einer Schleife.
     */
    public void spielen() 
    {            
        aktuellerRaum = new Spielumgebung().raeumeAnlegen();
        zuege = 20;
        willkommenstextAusgeben();

        // Die Hauptschleife. Hier lesen wir wiederholt Befehle ein
        // und führen sie aus, bis das Spiel beendet wird.

        boolean beendet = false;
        while (! beendet && zuege != 0) {
            Befehl befehl = parser.liefereBefehl();
            beendet = verarbeiteBefehl(befehl);
        }
        if (! beendet){
            System.out.println("BUUMMM. Der Reaktor ist in die Luft geflogen. Sie haben Verloren. Versuchen Sie es doch nochmal.");
        }
        System.out.println("Danke für dieses Spiel. Auf Wiedersehen.");
        
    }

    /**
     * Methode willkommenstextAusgeben
     * 
     * Methode zum ausgeben des Begrüßungstextes.
     */
    private void willkommenstextAusgeben()
    {
        System.out.println();
        System.out.println("Willkommen!");
        System.out.println("Sie befinden sich in einem Reaktor.");
        System.out.println("KRRRCH KRRRCH! Oh Nein, hören Sie das? Der Reaktor droht in die Luft zu gehen!");
        System.out.println("Sie müssen den Reaktor reparieren, bevor alles in die Luft fliegt!");
        System.out.println("Aber sein Sie vorsichtig! Sie haben nur 20 Züge. Wählen Sie also mit Bedacht.");
        System.out.println("Tippen sie 'help', wenn Sie Hilfe brauchen.");
        System.out.println();
        System.out.println(aktuellerRaum.gibLangeBeschreibung());
    }

    
    /**
     * Methode verarbeiteBefehl
     * 
     * Verarbeitet einen gegebenen Befehl und führt ihn ggf. aus.
     * 
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

    /**
     * Methode hilfstextAusgeben
     * 
     * Die Methode gibt Hilfsinformationen für den User aus.
     * Es wird eine kurze Beschreibung des Spiels gegeben,
     * sowie die Liste aller Begefehlswörter
     */
    private void hilfstextAusgeben() 
    {
        System.out.println("Sie müssen den Reaktor reparieren.");
        System.out.println("\t");
        System.out.println("Ihnen stehen folgende Befehle zur Verfügung:");
        parser.zeigeBefehle();
    }

    /**
     * Methode wechsleRaum
     * 
     * Methode zum wechseln des Raumes.
     * Der User versucht in eine Richtung zu gehen. Wenn es einen Ausgang gibt,
     * wechselt der User in den neuen Raum, ansonsten gibt das Programm
     * eine Fehlermeldung aus.
     * 
     * @param befehl Der Befehl, der die Richtung angibt.
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
            zuege--;
            zuegeAusgeben();
        }
    }

    /**
     * Methode benutzen
     * 
     * Die Methode benutzt einen Gegenstand im aktuellen Raum.
     * 
     * @param befehl Der Befehl, der den Gegenstand angibt
     */
    private void benutzen(Befehl befehl)
    {
        Gegenstand gegenstand = aktuellerRaum.gibGegenstand(befehl.gibZweitesWort());
        
        if(null == gegenstand) {
            System.out.println("Was möchten Sie benutzen?");
            return;
        }
        
        System.out.println(gegenstand.benutzen());
    }
    
    /**
     * Methode take
     * 
     * Die Methode schreibt etwas in einen Gegenstand,
     * der sich im aktuellen Raum befindet
     * 
     * @param befehl Der Befehl, der den Gegenstand angibt.
     */
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
            System.out.println("Die Eingabe ist korrekt.");
        }
        
        else{
            System.out.println("Das hat leider nicht funktioniert.");
        }
    }
    
    /**
     * Methode take
     * 
     * Die Methode nimmt einen Gegenstand im aktuellen Raum auf.
     * 
     * @param befehl Der Befehl, der den Gegenstand angibt.
     */
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
    
    /**
     * Methode reparieren
     * 
     * Die Methode repariert einen Gegenstand im aktuellen Raum.
     * Bedingung dafür ist, dass das nötige Werkzeug im Inventar ist.
     * 
     * @param befehl Der Befehl, der den Gegenstand angibt
     * @return 'true', wenn das Spiel gewonnen ist, sonst 'false'
     */
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
    
    /**
     * Methode inventar 
     * 
     * Gibt eine Liste der Gegenstände, welche im Inventar sind, aus.
     */
    private void inventar()
    {
        System.out.println("Sie haben folgende Gegenstände: ");
        System.out.println();
        for(String gegenstand : inventar.keySet()){
            System.out.println(gegenstand + "  |");
        }
    }
    
    /**
     * Methode zuegeAusgeben
     * 
     * Gibt die Anzahl der uebrigen Zuege aus.
     */
    private void zuegeAusgeben()
    {
        System.out.println("Züge: " + zuege);
        System.out.println();
        System.out.println();
    }
    
    /**
     * Methode beenden
     * 
     * Wenn "quit" eingegeben wurde. Überprüfe den Rest des Befehls,
     * ob das Spiel wirklich beendet werden soll.
     * Falls kein Zweites Wort eingegeben wrd, beende das Spiel.
     * 
     * @param befehl Der Befehl zum Beenden des Spiels.
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
