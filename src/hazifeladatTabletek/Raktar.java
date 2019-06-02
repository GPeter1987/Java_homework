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
					throw new Exception("A tablet már a listában van.");
				}
				i++;	
			}
			tabletek.add(t);
		}else {
			throw new Exception("Az érték nem lehet null!");
		}
	}
	
	// darabszám csak olvasható
	public void hanyTabletVan() {
		int sorszam = tabletek.size();
		System.out.println("A raktárban " + sorszam + "van."); 
	}
	
	//Tablet törlése paraméteralapján
	public void tabletTorolParam() {
		tabletek.remove();
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
	}
	
}
