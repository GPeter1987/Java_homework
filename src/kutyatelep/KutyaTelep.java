package kutyatelep;

import kutyatelep.Kutya.Faj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KutyaTelep {
	
	private static Random rnd = new Random();
	private int maxLetszam;
	private int minLetszam;
	private List<Kutya> kutyaLista;
	
	public int getMaxLetszam() {
		return maxLetszam;
	}
	public void setMaxLetszam(int letszam) throws Exception {
		if(letszam < 5 || letszam > 200) {
			throw new Exception("A telep létszáma 5 és 200 között kell ,hogy legyen.");
		}else {
			maxLetszam = letszam;
		}
	}
	
	public int darabszam;
	public int getDarabszam() {
		return kutyaLista.size();
	}
	/***
	 * 	Megmondja, hogy egy bizonyos fajból mennyi van a telepen
	 * @return
	 */
	public int fajDarabszam(Faj a) {
		int db = 0;
		for(Kutya k : kutyaLista){
			db++;
		}
		return db;
	}
	/**
	 * 	Elhelyez egy kutyát a telepen
	 * 	Egy fajtából nem lehet több mint 50 és nem lehet null
	 * 	Visszatér egy boolean értékkel
	 */
	public boolean elhelyez(Kutya k) {
		if(k == null) {
			return false;
		}
		if(fajDarabszam(k.fajta)>= 50) {
			return false;
		}
		kutyaLista.add(k);
		return true;
	}
	/**
	 * Lekerdezi az adott sorszámú kutyapéldányt
	 */
	public Kutya lekerdez(int index) {
		/*Kutya[] lekerdez = new Kutya[kutyaLista.size()];
		for(int i = 0; i < kutyaLista.size();i++) {
			lekerdez[i] = kutyaLista.get(i);
		}
		//System.out.println(lekerdez[index]); */
		return kutyaLista.get(index);
		
	}
	
	/**
	 * Egy évet öregít a telepen
	 */
	public void elteltEgyEv() {
		List<Kutya> torlendok = new ArrayList<Kutya>();
		for(Kutya k : kutyaLista) {
			k.setKora(k.getKora() + 1);
			// elpusztuló kutyák
			if(k.getKora() * 5 > rnd.nextInt(100-1)+1) {
				torlendok.add(k);
			}
		}
		for(Kutya p : torlendok) {
			kutyaLista.remove(p);
		}
	}
	
	/**
	 * Konstruktor
	 */
	public KutyaTelep(int max) {
		maxLetszam = max;
		kutyaLista = new ArrayList<Kutya>();
	}
}
