package koPapirOllo;

import java.util.*;

public class KinaiJatekos {
	
	public enum Visszateres {
		KO,
		PAPIR,
		OLLO
	}
	
	public Visszateres vissza;
	private int rizsMenny;
	private int rizsKezdo; // 0 - 100 a kezdõ mennyiség
	private int mohosag; // 2 és 10 közti szám
	private String nev;
	
	Random rnd = new Random();
	
	
	public Visszateres getVissza() {
		return this.vissza;
	}
	
	public int getRizsMenny() {
		return rizsMenny;
	}

	public void setRizsMenny(int rizsMenny) throws Exception {
		if(rizsMenny >= 0) {
			this.rizsMenny = rizsMenny;
		}else {
			throw new Exception("A rizs mennyisége nem lehet negatív.");
		}
	}

	public int getRizsKezdo() {
		return rizsKezdo;
	}

	public void setRizsKezdo(int rizsKezdo) throws Exception {
		if(rizsKezdo >= 0 && rizsKezdo <= 100) {
			this.rizsKezdo = rizsKezdo;
		}else {
			throw new Exception ("Az ertek 0 és 100 közti kell ,hogy legyen");
		}
	}

	public int getMohosag() {
		return mohosag;
	}

	public void setMohosag(int mohosag) throws Exception {
		if(mohosag >= 2 && mohosag <= 10) {
			this.mohosag = mohosag;
		}else {
			throw new Exception("A mohóság értéke 2 és 10 közé kell ,hogy essen.");
		}
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) throws Exception {
		if(nev != null) {
			this.nev = nev;
		}else {
			throw new Exception("A név nem lehet null.");
		}
	}

	/**
	 * megadja, hogy a játékos részt kíván-e venni a játékban 
	 *(nem kíván, ha nincs meg a 3 rizs, illetve ha a mohóságának 
	 * megfelelõ mennyiségû nyereménnyel rendelkezik) 
	 */
	public boolean akarJatszani() {
		boolean akarJatszani = true;
		if(rizsMenny < 3 || rizsMenny > (rizsKezdo * mohosag)) {
			akarJatszani = false;
		}else {
			akarJatszani = true;
		}
		return akarJatszani;
	}
	
	/**
	 * enum: a függvény visszatérési értéke kõ, papír, vagy olló, 
	 * attól függõen a játékos épp mit mutatott fel
	 */
	public void felmutat() {
		int valasztas = rnd.nextInt((3-1)+1);
		if(valasztas == 1) {
			this.vissza = Visszateres.KO;
		}
		else if(valasztas == 2) {
			this.vissza = Visszateres.OLLO;
		}else {
			this.vissza = Visszateres.PAPIR;
		}
	
	}
	
	/**
	 * Konstruktor
	 * Paraméterek: nyereségvágy , rizs induló mennyisége
	 * @throws Exception 
	 */
	public KinaiJatekos(int nyeresegvagy, int rizsKezdo) throws Exception {
		setRizsKezdo(rizsKezdo);
		setMohosag(nyeresegvagy);
		setNev("Kínai");
		setRizsMenny(rizsKezdo);
	}

}
