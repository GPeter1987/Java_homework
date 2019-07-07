package szavanna;

import java.util.Random;

public class Animal {
	
	/**
	 * 	Minden állat tud:
	 * 	x	- mozogni
	 * 	x	- szaporodni
	 * 	x	- öregedni
	 * 		- enni (Evés nélkül kibír:	ragadozó: 1 évet
	 * 									növényevõ: mindig tud enni)
	 * 	x	- élemég
	 * 	x	- szaporodás óta eltelt idõ
	 * 		- szaporodási kedv
	 * 
	 * 	Minden állat rendelkezik:
	 * 		- Kor (nem lehet negatív és max 1000)
	 * 		- Max életkor (	ragadozó: 9-12 év,
	 * 						növényevõ: 11-14 év)
	 * 		- Nemmel
	 * 		- Éhség (ragadozónál ha eléri a kettõt akkor elpusztul)
	 */
	//===================================================================
	/**
	 * A position egy 2 int-et tartalmazó
	 * array ami azt mutatja melyik mátrix
	 * koordinátákon tartozkodik az állat
	 */
	private int[] position = new int[2];
	
	public int[] getPosition() {
		return this.position;
	}
	public void setPosition(int pos0, int pos1) {
		if(position[0] <= 0 && position[1] <= 0) {
			this.position[0] += pos0;
			this.position[1] += pos1;
		}
	}
	
	/**
	 * Él e az állat?
	 * True = él
	 * False = halott
	 */
	private boolean live;
	
	public boolean isLive() {
		return this.live;
	}
	public void setLive(boolean tof) {
		this.live = tof;
	}
	
	/**
	 * Az éhség jelzi, hogy állat tudott e 
	 * táplálkozni.
	 * És ha nem akkor azt meddig nem tudta
	 * megtenni.
	 */
	private int hunger = 0;
	
	public int getHunger() {
		return this.hunger;
	}
	public void setHunger(int x) {
		if(this.getHunger() >= 0 && (this.getHunger() + x) <= 100) {
			this.hunger = this.getHunger() + x;
		}else {
			System.out.println("Az éhség nem lehet több mint 100 vagy kevesebb mint 0!");
		}
	}
	
	public int eating() {
		this.setHunger(1);
		return hunger;
	}
	
	
	/**
	 * A move method egy számot ad vissza,
	 * +X és -X közt amit a position egyik
	 * koordinátájához fogunk hozzá adni,
	 * hogy az állat elmozduljon valamelyik irányba.
	 * @param step mekkorát tud lépni az állat
	 * @return : Az elmozdulás mértéke
	 */
	public int[] move(int step) {
		Random rnd = new Random();
		int moveDirection = rnd.nextInt(10-1)+1;
		if(moveDirection < 5) {
			this.setPosition(step, 0);
		}else {
			this.setPosition(0, step);
		}
		return position;
	}
	/**
	 * 	Ha hím akkor true
	 * 	Ha nõstény akkor false
	 */
	private boolean sex;
	
	/**
	 * 	Az állat kora
	 * 	És korának lekérdezése  és beállítása
	 */
	private int age = 0;
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if(this.age <= 0 && (this.age + age) < 1000) {
			this.age += age;
		}else {
			System.out.println("Az állat életkora nem lehet negatív és több sem lehet 1000-nél!");
		}
	}
	/**
	 * Eltároljuk, hogy az állat mikor szaporodott 
	 * utoljára, hogy tudjunk számolni, hogy mikor
	 * tud majd legközelebb.
	 */
	private int lastReproduction = 0;
	
	public int getLastReproduction() {
		return this.lastReproduction;
	}
	// A lastba annak körnek a számát kell bevinni amikor szaporodott
	public void setLastReproduction(int last) {
		this.lastReproduction = last;
	}
	
	/**
	 * Szaporodási kedv
	 */
	private boolean mod;
	
	public boolean getMod() {
		return this.mod;
	}
	public void setMod(boolean tof) {
		this.mod = tof;
	}
	
	/**
	 * Van e kedve szaporodni:
	 * 		- Nem éhes
	 * 		- Van kivel
	 * 		- Van hova
	 */
	public boolean whatMod() {
		// Még ki kell tölteni ,de kell hozzá a cella foglaltsági adat.
		return true;
	}
	
	
	/**
	 * Szaporodás
	 * @param male  : Hím állat
	 * @param female: Nõstény állat
	 * @return 		: Kölykök
	 */
	public Animal reproduction(Animal male, 
								Animal female) {
		return null;
	}

}
