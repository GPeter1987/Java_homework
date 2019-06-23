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
	// Getterek és Setterek
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

	
	
	// Listák
	ArrayList<KinaiJatekos> jLista = new ArrayList<KinaiJatekos>();
	ArrayList<Biro> bLista = new ArrayList<Biro>();
	
	// Játékos hozzá adása
	public void jatekosHozzaad(KinaiJatekos k) throws Exception {
		if(jLista.size() <= maxJatekos) {
			jLista.add(k);
		}else {
			throw new Exception("A játékosok száma maximum " + maxJatekos + " lehet.");
		}
			
	}
	
	// Játékos törlése
	public void jatekosTorlese(KinaiJatekos a) {
		jLista.remove(a);
	}
	
	// Játékos lista kiírása
	public void jatekosLekerdez() {
			System.out.println(jLista);
	}
	
	// Bíró hozzá ad
	public void biroHozzaAd(Biro a) throws Exception {
		if(bLista.size() <= maxBiro) {
			bLista.add(a);
		}else {
			throw new Exception("A bírók száma maximum " + maxBiro + " lehet.");
		}
	}
	
	// Bíró törlése
	public void biroTorlese(Biro a) {
		bLista.remove(a);
	}
	
	// Ki írjuk a bírók listáját
	public void biroKiir() {
		System.out.println(bLista);
	}
	
	/**
	 * kiválaszt random egy bírót, random két játékost, 
	 * a bírót megkéri hogy próbálja lebonyolítani a játékot 
	 * a két játékossal, konzolra írja a történéseket 
	 * (játékosok neve, mit mutattak fel, a bíró döntése, stb)
	 * @throws Exception 
	 */
	public void lebonyolit() throws Exception {
		Biro biro;
		KinaiJatekos jatekos1;
		KinaiJatekos jatekos2;
		
		// Random választunk egy bírót majd két játékost
		biro = bLista.get(rnd.nextInt(bLista.size()));
		jatekos1 = jLista.get(rnd.nextInt(jLista.size()));
		jatekos2 = jLista.get(rnd.nextInt(jLista.size()));
		
		// Ki írjuk a játékosokat és a bírót.
		System.out.println("Az elsõ játékos: " + jatekos1);
		System.out.println("Az második játékos: " + jatekos2);
		System.out.println("A bíró: " + biro);
		
		// Amíg van a játékosoknál elég rizs addig játszannak.
		while(jatekos1.getRizsMenny() >= 3 && jatekos2.getRizsMenny() >= 3) {
			biro.lebonyolit(jatekos1, jatekos2);
			System.out.println(jatekos1.getVissza());
			System.out.println(jatekos2.getVissza());
		}
		// Ki írjuk a végeredményt.
		System.out.println("Az elsõ játékos: " + jatekos1.getRizsMenny() + " db rizzsel rendelkezik.");
		System.out.println("Az mások játékos: " + jatekos2.getRizsMenny() + " db rizzsel rendelkezik.");
	
	}

}
