package kutyatelep;

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
			throw new Exception("A telep l�tsz�ma 5 �s 200 k�z�tt kell ,hogy legyen.");
		}else {
			maxLetszam = letszam;
		}
	}
	
	public int darabszam;
	public int getDarabszam() {
		return kutyaLista.size();
	}
	
	public int fajDarabszam(fajta) {
		int db = 0;
		for(fajta : kutyaLista){
			db++;
		}
		return db;
	}
	

}
