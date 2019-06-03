package hazifeladatTabletek;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Egy raktárt példányosít
		Raktar testRaktar = new Raktar();
		Tablet testTablet = new Tablet(800,600,false,false,4.0,30000);
		Tablet testTablet2 = new Tablet(800,600,true,false,4.0,35000);
		
		testRaktar.tabletHozzaAd(testTablet); 
		testRaktar.tabletHozzaAd(testTablet2);
		// 40db random tablet
		testRaktar.raktarKeszletGeneral(40);
		
		
		// összes tablet árának kiírása
		testRaktar.raktarErtek();
		testRaktar.arKiir();
		// darabszám
		testRaktar.hanyTabletVan();
		
		
		// random sorszámú törlése
		testRaktar.randomTabletTorles();
		
		
		// újra ki írja az elõzõ adatokat
		testRaktar.hanyTabletVan();
		testRaktar.raktarErtek();
		testRaktar.arKiir();
	}
		
	}
	
	


