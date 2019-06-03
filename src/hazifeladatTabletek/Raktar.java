package hazifeladatTabletek;

import java.util.ArrayList;
import java.util.Random;

public class Raktar {
	
	private ArrayList<Tablet> tabletek;
	
	public Raktar() {
		tabletek = new ArrayList<Tablet>(); 
		
	}

	 
	public void tabletHozzaAd(Tablet t) throws Exception {
		// Egy tablet csak egyszer lehet benne
		// Nem lehet benne null
		if(t != null) {
				tabletek.add(t);
		}		
		else {
			throw new Exception("Az érték nem lehet null!");
		}
	}
	
	// darabszám csak olvasható
	public void hanyTabletVan() {
		int sorszam = tabletek.size();
		System.out.println("A raktárban " + sorszam + " tablet van."); 
	}
	
	//Tablet törlése paraméteralapján
	public void tabletTorolParam(Tablet t) {
		tabletek.remove(t);
	}
	// Tablet törlése index alapján
	public void tabletTorolIndex(int index) {
		tabletek.remove(index);
	}
	
	
	// összes árérték, csak olvasható
	public void raktarErtek() {
		int ertek = 0;
		for(int i = 0; i < tabletek.size();i++) {
			ertek += tabletek.get(i).getAr(); 
		}
		System.out.println("A raktár értéke " + ertek + " Huf.");
	}
	
	// Raktáron lévõ tabletek árának ki írása;
	public void arKiir() {
		for(int i = 0; i < tabletek.size(); i++) {
			System.out.println(tabletek.get(i).getAr() + " Huf.");
		}
	}
	
	//Random szám generátor
		public int getRandomSzamEgyTartományban(int min, int max) {
			Random r = new Random();
			return r.nextInt/*(*/(max - min)/*+1)+min*/;
		}
		// random boolean
		public boolean getRandomBoolean() {
			return Math.random() < 0.5;
		}
		
	// Random tablet törlése
	public void randomTabletTorles() {
		int index = getRandomSzamEgyTartományban(0, (tabletek.size() -1));
		tabletek.remove(index);
	}
	
	// Random raktár generálás
	public void raktarKeszletGeneral(int db) throws Exception {
		int[] resX = Tablet.getResXArray();
		int[] resY = Tablet.getResYArray();
		double[] and = Tablet.getAndroidVerzioArray();
		for(int i = 0; i < db; i++) {
			int randomIndex = getRandomSzamEgyTartományban(0, resX.length-1);
			int randomResX = resX[randomIndex];
			int randomResY = resY[randomIndex];
			double android = and[randomIndex];
			boolean randomBoolean = getRandomBoolean();
			int ar = getRandomSzamEgyTartományban(10000, 800000);
			
			Tablet random = new Tablet( randomResX,
										randomResY,
										randomBoolean,
										randomBoolean,
										android,
										ar);
			
		//	tabletek.set(i, random);
			tabletHozzaAd(random);
			}
	}
	
	
	
}
