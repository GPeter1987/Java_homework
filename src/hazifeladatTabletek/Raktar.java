package hazifeladatTabletek;

import java.util.ArrayList;

public class Raktar {
	
	private ArrayList<Tablet> tabletek;
	
	public Raktar() {
		tabletek = new ArrayList<Tablet>(); 
		
	}

	 
	public void tabletHozzaAd(Tablet t) throws Exception {
		// Egy tablet csak egyszer lehet benne
		// Nem lehet benne null
		if(t != null) {
			int i = 0;
			while(tabletek.get(i) != t && i < tabletek.size()) {
				if(tabletek.get(i) == t) {
					throw new Exception("A tablet m�r a list�ban van.");
				}
				i++;	
			}
			tabletek.add(t);
		}else {
			throw new Exception("Az �rt�k nem lehet null!");
		}
	}
	
	// darabsz�m csak olvashat�
	public void hanyTabletVan() {
		int sorszam = tabletek.size();
		System.out.println("A rakt�rban " + sorszam + "van."); 
	}
	
	//Tablet t�rl�se param�teralapj�n
	public void tabletTorolParam() {
		tabletek.remove();
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
	}
	
}
