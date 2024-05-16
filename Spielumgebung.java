
/**
 * Beschreiben Sie hier die Klasse Spielumgebung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spielumgebung
{
    public Spielumgebung(){
        
    }
    
    /**
     * Erzeuge alle R�ume und verbinde ihre Ausg�nge miteinander.
     */
    public Raum raeumeAnlegen()
    {
        Raum hauptRaum, buero, lager,untererMotor, obererMotor, reaktor, 
        sicherheitsRaum, ersteHilfe, elektronik;

        // die R�ume erzeugen
        hauptRaum = new Raum("in dem Hauptraum");
        buero = new Raum("in dem B�ro");
        lager = new Raum("in dem Lager");
        untererMotor = new Raum("in dem unteren Motorraum");
        obererMotor = new TuerRaum("in dem oberen Motorraum");
        reaktor = new Raum("in dem Reaktor");
        sicherheitsRaum = new Raum("in dem Sicherheitsraum");
        ersteHilfe = new Raum("in dem Erste-Hilfe-Raum");
        elektronik = new Raum("in dem Raum f�r die Elektronik");
        
        // // die Ausg�nge initialisieren, dies setzt die Bezeichnungen,
        // // die der Spieler zum Weitergehen eingeben muss.
        // // man kann also denselben Ausgang unterschiedlich bezeichnen
        hauptRaum.setzeAusgang("oben", obererMotor);
        hauptRaum.setzeAusgang("unten", lager);
        hauptRaum.setzeAusgang("rechts", buero);

        lager.setzeAusgang("oben", hauptRaum);
        lager.setzeAusgang("unten", untererMotor);
        lager.setzeAusgang("links", elektronik);
        lager.fuegeGegenstandHinzu("Werkzeugkasten", new Werkzeug());

        elektronik.setzeAusgang("rechts", lager);
        elektronik.fuegeGegenstandHinzu("Spannungseinsteller", new Eingabe("50", obererMotor));

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
        obererMotor.setzeAusgangZu("links", reaktor);
        
        reaktor.setzeAusgang("rechts", obererMotor);
    
        return hauptRaum;  // das Spiel startet draussen
    }
}
