package de.jessi;

public class Util {

	public static boolean istErstesHalbjahr(int monat){
		if ((monat < 1) || (monat > 12)) throw new IllegalArgumentException();
		if(monat <= 6) return true; // Fehler war hier
		return false;
	}

}
