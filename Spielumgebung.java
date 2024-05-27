/**
 * Die Klasse Spielumgebung schafft die Spielumgebung in dem Spiel.
 * 
 * @author (Nicolas Lyer, Leif Bremer) 
 * @version (Version 1, 24.05.2024)
 */
public class Spielumgebung
{
    /**
     * Spielumgebung Konstruktor
     * 
     * Initialisiert ein Objekt, ohne spezielle Aktionen.
     */
    public Spielumgebung(){
        
    }
    
    /**
     * Methode raumeAnlegen
     * 
     * Diese Methode erstellt die verschiedenen R�ume des Spiels,
     * setzt die Ausg�nge zwischen den R�umen
     * und f�gt einige Gegenst�nde in bestimmte R�ume hinzu.
     *
     * @return Der Hauptraum, in dem das Spiel beginnt.

     */
    public Raum raeumeAnlegen()
    {
        // Deklaration der R�ume
        Raum hauptRaum, buero, lager,untererMotor, obererMotor, reaktor, 
        sicherheitsRaum, ersteHilfe, elektronik;

        // Instanziierung der R�ume
        hauptRaum = new Raum("in dem Hauptraum");
        buero = new Raum("in dem B�ro");
        lager = new Raum("in dem Lager");
        untererMotor = new Raum("in dem unteren Motorraum");
        obererMotor = new TuerRaum("in dem oberen Motorraum");
        reaktor = new Raum("in dem Reaktor");
        sicherheitsRaum = new Raum("in dem Sicherheitsraum");
        ersteHilfe = new Raum("in dem Erste-Hilfe-Raum");
        elektronik = new Raum("in dem Raum f�r die Elektronik");
        Gegenstand werkzeugkasten = new Werkzeug();
        
        // // die Ausg�nge initialisieren, dies setzt die Bezeichnungen,
        // // die der Spieler zum Weitergehen eingeben muss.
        // // man kann also denselben Ausgang unterschiedlich bezeichnen
        hauptRaum.setzeAusgang("oben", obererMotor);
        hauptRaum.setzeAusgang("unten", lager);
        hauptRaum.setzeAusgang("rechts", buero);
        hauptRaum.fuegeGegenstandHinzu("Tipp", new Hinweis("Der Reaktor befindet sich oben rechts"));

        lager.setzeAusgang("oben", hauptRaum);
        lager.setzeAusgang("unten", untererMotor);
        lager.setzeAusgang("links", elektronik);
        lager.fuegeGegenstandHinzu("Werkzeugkasten", werkzeugkasten);

        elektronik.setzeAusgang("rechts", lager);
        elektronik.fuegeGegenstandHinzu("Spannungseingabe", new Eingabe("187", obererMotor,"Geben Sie die passende Spannung als Zahl ein. (Ohne Volt)"));
        elektronik.fuegeGegenstandHinzu("Zettel", new Hinweis("Um die T�r zu reparieren muss hier die richtige Spannung eingegeben werden."));
        
        untererMotor.setzeAusgang("oben", lager);
        untererMotor.fuegeGegenstandHinzu("Widerstand", new Hinweis("Widerstand: 170 Ohm"));
        
        buero.setzeAusgang("oben", ersteHilfe);
        buero.setzeAusgang("links", hauptRaum);
        buero.fuegeGegenstandHinzu("Datenblatt", new Hinweis("Ben�tigter Strom: 1100 Milliampere"));
        
        ersteHilfe.setzeAusgang("oben", sicherheitsRaum);
        ersteHilfe.setzeAusgang("unten", buero);
        
        sicherheitsRaum.setzeAusgang("unten", ersteHilfe);
        sicherheitsRaum.setzeAusgang("links", obererMotor);
        
        obererMotor.setzeAusgang("unten", hauptRaum);
        obererMotor.setzeAusgang("rechts", sicherheitsRaum);
        obererMotor.setzeAusgangZu("links", reaktor);
        obererMotor.fuegeGegenstandHinzu("Zettel", new Hinweis("Die T�r zum Reaktor ist kaputt. Die Sicherung ist durchgebrannt. Begeben Sie sich in Elektronik."));
        
        reaktor.setzeAusgang("rechts", obererMotor);
        reaktor.fuegeGegenstandHinzu("Reaktor", new Kaputt(werkzeugkasten)); 
    
        return hauptRaum;  // das Spiel startet im Hauptraum
    }
}
