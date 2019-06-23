package koPapirOllo;

import java.util.ArrayList;
import java.util.Random;


public class JatekBarlang {
	
	private int maxJatekos;
	private int maxBiro;
	public Random rnd = new Random();
	
	
	
	
	// Konstruktor
	public JatekBarlang(int maxJatekos, int maxBiro) {
		setMaxJatekos(maxJatekos);
		setMaxBiro(maxBiro);
	}
	// Getterek �s Setterek
	public int getMaxJatekos() {
		return maxJatekos;
	}

	public void setMaxJatekos(int maxJatekos) {
		this.maxJatekos = maxJatekos;
	}

	public int getMaxBiro() {
		return maxBiro;
	}

	public void setMaxBiro(int maxBiro) {
		this.maxBiro = maxBiro;
	}

	
	
	// List�k
	ArrayList<KinaiJatekos> jLista = new ArrayList<KinaiJatekos>();
	ArrayList<Biro> bLista = new ArrayList<Biro>();
	
	// J�t�kos hozz� ad�sa
	public void jatekosHozzaad(KinaiJatekos k) throws Exception {
		if(jLista.size() <= maxJatekos) {
			jLista.add(k);
		}else {
			throw new Exception("A j�t�kosok sz�ma maximum " + maxJatekos + " lehet.");
		}
			
	}
	
	// J�t�kos t�rl�se
	public void jatekosTorlese(KinaiJatekos a) {
		jLista.remove(a);
	}
	
	// J�t�kos lista ki�r�sa
	public void jatekosLekerdez() {
			System.out.println(jLista);
	}
	
	// B�r� hozz� ad
	public void biroHozzaAd(Biro a) throws Exception {
		if(bLista.size() <= maxBiro) {
			bLista.add(a);
		}else {
			throw new Exception("A b�r�k sz�ma maximum " + maxBiro + " lehet.");
		}
	}
	
	// B�r� t�rl�se
	public void biroTorlese(Biro a) {
		bLista.remove(a);
	}
	
	// Ki �rjuk a b�r�k list�j�t
	public void biroKiir() {
		System.out.println(bLista);
	}
	
	/**
	 * kiv�laszt random egy b�r�t, random k�t j�t�kost, 
	 * a b�r�t megk�ri hogy pr�b�lja lebonyol�tani a j�t�kot 
	 * a k�t j�t�kossal, konzolra �rja a t�rt�n�seket 
	 * (j�t�kosok neve, mit mutattak fel, a b�r� d�nt�se, stb)
	 * @throws Exception 
	 */
	public void lebonyolit() throws Exception {
		Biro biro;
		KinaiJatekos jatekos1;
		KinaiJatekos jatekos2;
		
		// Random v�lasztunk egy b�r�t majd k�t j�t�kost
		biro = bLista.get(rnd.nextInt(bLista.size()));
		jatekos1 = jLista.get(rnd.nextInt(jLista.size()));
		jatekos2 = jLista.get(rnd.nextInt(jLista.size()));
		
		// Ki �rjuk a j�t�kosokat �s a b�r�t.
		System.out.println("Az els� j�t�kos: " + jatekos1);
		System.out.println("Az m�sodik j�t�kos: " + jatekos2);
		System.out.println("A b�r�: " + biro);
		
		// Am�g van a j�t�kosokn�l el�g rizs addig j�tszannak.
		while(jatekos1.getRizsMenny() >= 3 && jatekos2.getRizsMenny() >= 3) {
			biro.lebonyolit(jatekos1, jatekos2);
			System.out.println(jatekos1.getVissza());
			System.out.println(jatekos2.getVissza());
		}
		// Ki �rjuk a v�geredm�nyt.
		System.out.println("Az els� j�t�kos: " + jatekos1.getRizsMenny() + " db rizzsel rendelkezik.");
		System.out.println("Az m�sok j�t�kos: " + jatekos2.getRizsMenny() + " db rizzsel rendelkezik.");
	
	}

}
