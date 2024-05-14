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

class Spiel 
{
    private Parser parser;
    private Raum aktuellerRaum;
    private HashMap<String,Gegenstand> inventar;

    /**
     * Erzeuge ein Spiel und initialisiere die interne Raumkarte.
     */
    public Spiel() 
    {
        raeumeAnlegen();
        parser = new Parser();
    }

    /**
     * Erzeuge alle Räume und verbinde ihre Ausgänge miteinander.
     */
    private void raeumeAnlegen()
    {
        Raum hauptRaum, buero, lager,untererMotor, obererMotor, reaktor, 
        sicherheitsRaum, ersteHilfe, elektronik;

        // die Räume erzeugen
        hauptRaum = new Raum("in dem Hauptraum");
        buero = new Raum("in dem Büro");
        lager = new Raum("in dem Lager");
        untererMotor = new Raum("in dem unteren Motorraum");
        obererMotor = new Raum("in dem oberen Motorraum");
        reaktor = new Raum("in dem Reaktor");
        sicherheitsRaum = new Raum("in dem Sicherheitsraum");
        ersteHilfe = new Raum("in dem Erste-Hilfe-Raum");
        elektronik = new Raum("in dem Raum für die Elektronik");
        
        // // die Ausgänge initialisieren, dies setzt die Bezeichnungen,
        // // die der Spieler zum Weitergehen eingeben muss.
        // // man kann also denselben Ausgang unterschiedlich bezeichnen
        hauptRaum.setzeAusgang("oben", obererMotor);
        hauptRaum.setzeAusgang("unten", lager);
        hauptRaum.setzeAusgang("rechts", buero);

        lager.setzeAusgang("oben", hauptRaum);
        lager.setzeAusgang("unten", untererMotor);
        lager.setzeAusgang("links", elektronik);

        elektronik.setzeAusgang("rechts", lager);
        elektronik.fuegeGegenstandHinzu("Spannungseinsteller", new Eingabe("50", "links", reaktor, obererMotor));

        untererMotor.setzeAusgang("oben", lager);
        untererMotor.fuegeGegenstandHinzu("Widerstand", new Hinweis("Widerstand: 100 Ohm"));
        
        buero.setzeAusgang("oben", ersteHilfe);
        buero.setzeAusgang("links", hauptRaum);
        buero.fuegeGegenstandHinzu("Datenblatt", new Hinweis("Datenblatt:"));
        
        ersteHilfe.setzeAusgang("oben", sicherheitsRaum);
        ersteHilfe.setzeAusgang("unten", buero);
        
        sicherheitsRaum.setzeAusgang("unten", ersteHilfe);
        sicherheitsRaum.setzeAusgang("links", obererMotor);
        
        obererMotor.setzeAusgang("unten", hauptRaum);
        obererMotor.setzeAusgang("rechts", sicherheitsRaum);
        
        reaktor.setzeAusgang("rechts", obererMotor);
    
        aktuellerRaum = hauptRaum;  // das Spiel startet draussen
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
        while (! beendet) {
            Befehl befehl = parser.liefereBefehl();
            beendet = verarbeiteBefehl(befehl);
        }
        System.out.println("Danke für dieses Spiel. Auf Wiedersehen.");
    }

    /**
     * Einen Begrüßungstext für den Spieler ausgeben.
     */
    private void willkommenstextAusgeben()
    {
        System.out.println();
        System.out.println("Willkommen zu Zuul!");
        System.out.println("Zuul ist ein neues, unglaublich langweiliges Spiel.");
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
            System.out.println("Ich weiss nicht, was Sie meinen...");
            break;

            case HELP:
            hilfstextAusgeben();
            break;

            case GO:
            wechsleRaum(befehl);
            break;

            case USE:
            benutzen(befehl);
            break;
            
            case WRITE:
            write(befehl);
            break;
            
            case TAKE:
            take(befehl);
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
        System.out.println("Sie haben sich verlaufen. Sie sind allein.");
        System.out.println("Sie irren auf dem Unigelände herum.");
        System.out.println();
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
            System.out.println("Dort ist keine Tür!");
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
            Raum raum = gegenstand.getWo();
            raum.setzeAusgang(gegenstand.getKey(),gegenstand.getValue());
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
            return;
        }
        
        System.out.println("Das koennen Sie nicht aufheben");
    }
    
    /**
     * "quit" wurde eingegeben. Überprüfe den Rest des Befehls,
     * ob das Spiel wirklich beendet werden soll.
     * @return 'true', wenn der Befehl das Spiel beendet, 'false' sonst.
     */
    private boolean beenden(Befehl befehl) 
    {
        if(befehl.hatZweitesWort()) {
            System.out.println("Was soll beendet werden?");
            return false;
        }
        else {
            return true;  // Das Spiel soll beendet werden.
        }
    }
}
