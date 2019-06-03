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
			throw new Exception("Az �rt�k nem lehet null!");
		}
	}
	
	// darabsz�m csak olvashat�
	public void hanyTabletVan() {
		int sorszam = tabletek.size();
		System.out.println("A rakt�rban " + sorszam + " tablet van."); 
	}
	
	//Tablet t�rl�se param�teralapj�n
	public void tabletTorolParam(Tablet t) {
		tabletek.remove(t);
	}
	// Tablet t�rl�se index alapj�n
	public void tabletTorolIndex(int index) {
		tabletek.remove(index);
	}
	
	
	// �sszes �r�rt�k, csak olvashat�
	public void raktarErtek() {
		int ertek = 0;
		for(int i = 0; i < tabletek.size();i++) {
			ertek += tabletek.get(i).getAr(); 
		}
		System.out.println("A rakt�r �rt�ke " + ertek + " Huf.");
	}
	
	// Rakt�ron l�v� tabletek �r�nak ki �r�sa;
	public void arKiir() {
		for(int i = 0; i < tabletek.size(); i++) {
			System.out.println(tabletek.get(i).getAr() + " Huf.");
		}
	}
	
	//Random sz�m gener�tor
		public int getRandomSzamEgyTartom�nyban(int min, int max) {
			Random r = new Random();
			return r.nextInt/*(*/(max - min)/*+1)+min*/;
		}
		// random boolean
		public boolean getRandomBoolean() {
			return Math.random() < 0.5;
		}
		
	// Random tablet t�rl�se
	public void randomTabletTorles() {
		int index = getRandomSzamEgyTartom�nyban(0, (tabletek.size() -1));
		tabletek.remove(index);
	}
	
	// Random rakt�r gener�l�s
	public void raktarKeszletGeneral(int db) throws Exception {
		int[] resX = Tablet.getResXArray();
		int[] resY = Tablet.getResYArray();
		double[] and = Tablet.getAndroidVerzioArray();
		for(int i = 0; i < db; i++) {
			int randomIndex = getRandomSzamEgyTartom�nyban(0, resX.length-1);
			int randomResX = resX[randomIndex];
			int randomResY = resY[randomIndex];
			double android = and[randomIndex];
			boolean randomBoolean = getRandomBoolean();
			int ar = getRandomSzamEgyTartom�nyban(10000, 800000);
			
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
