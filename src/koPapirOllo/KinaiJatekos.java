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
	private int rizsKezdo; // 0 - 100 a kezd� mennyis�g
	private int mohosag; // 2 �s 10 k�zti sz�m
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
			throw new Exception("A rizs mennyis�ge nem lehet negat�v.");
		}
	}

	public int getRizsKezdo() {
		return rizsKezdo;
	}

	public void setRizsKezdo(int rizsKezdo) throws Exception {
		if(rizsKezdo >= 0 && rizsKezdo <= 100) {
			this.rizsKezdo = rizsKezdo;
		}else {
			throw new Exception ("Az ertek 0 �s 100 k�zti kell ,hogy legyen");
		}
	}

	public int getMohosag() {
		return mohosag;
	}

	public void setMohosag(int mohosag) throws Exception {
		if(mohosag >= 2 && mohosag <= 10) {
			this.mohosag = mohosag;
		}else {
			throw new Exception("A moh�s�g �rt�ke 2 �s 10 k�z� kell ,hogy essen.");
		}
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) throws Exception {
		if(nev != null) {
			this.nev = nev;
		}else {
			throw new Exception("A n�v nem lehet null.");
		}
	}

	/**
	 * megadja, hogy a j�t�kos r�szt k�v�n-e venni a j�t�kban 
	 *(nem k�v�n, ha nincs meg a 3 rizs, illetve ha a moh�s�g�nak 
	 * megfelel� mennyis�g� nyerem�nnyel rendelkezik) 
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
	 * enum: a f�ggv�ny visszat�r�si �rt�ke k�, pap�r, vagy oll�, 
	 * att�l f�gg�en a j�t�kos �pp mit mutatott fel
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
	 * Param�terek: nyeres�gv�gy , rizs indul� mennyis�ge
	 * @throws Exception 
	 */
	public KinaiJatekos(int nyeresegvagy, int rizsKezdo) throws Exception {
		setRizsKezdo(rizsKezdo);
		setMohosag(nyeresegvagy);
		setNev("K�nai");
		setRizsMenny(rizsKezdo);
	}

}
