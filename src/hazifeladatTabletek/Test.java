package hazifeladatTabletek;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Egy rakt�rt p�ld�nyos�t
		Raktar testRaktar = new Raktar();
		Tablet testTablet = new Tablet(800,600,false,false,4.0,30000);
		Tablet testTablet2 = new Tablet(800,600,true,false,4.0,35000);
		
		testRaktar.tabletHozzaAd(testTablet); 
		testRaktar.tabletHozzaAd(testTablet2);
		// 40db random tablet
		testRaktar.raktarKeszletGeneral(40);
		
		
		// �sszes tablet �r�nak ki�r�sa
		testRaktar.raktarErtek();
		testRaktar.arKiir();
		// darabsz�m
		testRaktar.hanyTabletVan();
		
		
		// random sorsz�m� t�rl�se
		testRaktar.randomTabletTorles();
		
		
		// �jra ki �rja az el�z� adatokat
		testRaktar.hanyTabletVan();
		testRaktar.raktarErtek();
		testRaktar.arKiir();
	}
		
	}
	
	


