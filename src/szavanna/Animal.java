package szavanna;

import java.util.Random;

public class Animal {
	
	/**
	 * 	Minden �llat tud:
	 * 	x	- mozogni
	 * 	x	- szaporodni
	 * 	x	- �regedni
	 * 	x	- enni (Ev�s n�lk�l kib�r:	ragadoz�: 1 �vet
	 * 									n�v�nyev�: mindig tud enni)
	 * 	x	- �lem�g
	 * 	x	- szaporod�s �ta eltelt id�
	 * 	x	- szaporod�si kedv
	 * 
	 * 	Minden �llat rendelkezik:
	 * 	x	- Kor (nem lehet negat�v �s max 1000)
	 * 	x	- Nemmel
	 * 	x	- �hs�g (ragadoz�n�l ha el�ri a kett�t akkor elpusztul)
	 */
	//===================================================================
	
	Random rnd = new Random();
	
	// Konstruktor
	public Animal(	int pos0,
					int pos1,
					boolean tof,
					int hunger,
					boolean sex,
					int age,
					int last,
					boolean mod) {
		this.setPosition(pos0, pos1);
		this.setLive(tof);
		this.setHunger(0);
		this.setSex(sex);
		this.setAge(age);
		this.setLastReproduction(last);
		this.setMod(mod);
		
	}
	
	public Animal(int x, int y) {
		this.setPosition(x, y);
		this.setLive(true);
		this.setHunger(0);
		this.setSex(rnd.nextBoolean());
		this.setAge(1);
		this.setLastReproduction(0);
		this.setMod(true);
		
	}
	
	/**
	 * A position egy 2 int-et tartalmaz�
	 * array ami azt mutatja melyik m�trix
	 * koordin�t�kon tartozkodik az �llat
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
	 * �l e az �llat?
	 * True = �l
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
	 * Az �hs�g jelzi, hogy �llat tudott e 
	 * t�pl�lkozni.
	 * �s ha nem akkor azt meddig nem tudta
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
			System.out.println("Az �hs�g nem lehet t�bb mint 100 vagy kevesebb mint 0!");
		}
	}
	
	public int eating() {
		this.setHunger(1);
		return hunger;
	}
	
	
	/**
	 * A move method egy sz�mot ad vissza,
	 * +X �s -X k�zt amit a position egyik
	 * koordin�t�j�hoz fogunk hozz� adni,
	 * hogy az �llat elmozduljon valamelyik ir�nyba.
	 * @param step mekkor�t tud l�pni az �llat
	 * @return : Az elmozdul�s m�rt�ke
	 */
	public int[] move(int step) {
		int moveDirection = rnd.nextInt(10-1)+1;
		if(moveDirection < 5) {
			this.setPosition(step, 0);
		}else {
			this.setPosition(0, step);
		}
		return position;
	}
	/**
	 * 	Ha h�m akkor true
	 * 	Ha n�st�ny akkor false
	 */
	private boolean sex;
	
	public boolean getSex() {
		return this.sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	/**
	 * 	Az �llat kora
	 * 	�s kor�nak lek�rdez�se  �s be�ll�t�sa
	 */
	private int age = 0;
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if(this.age <= 0 && (this.age + age) < 1000) {
			this.age += age;
		}else {
			System.out.println("Az �llat �letkora nem lehet negat�v �s t�bb sem lehet 1000-n�l!");
		}
	}
	
	private int maxAge;
	
	public int getMaxAge() {
		return this.maxAge;
	}
	
	public void setMaxAge() {
		this.maxAge = rnd.nextInt(14-9)+9;
	}
	/**
	 * Elt�roljuk, hogy az �llat mikor szaporodott 
	 * utolj�ra, hogy tudjunk sz�molni, hogy mikor
	 * tud majd legk�zelebb.
	 */
	private int lastReproduction = 0;
	
	public int getLastReproduction() {
		return this.lastReproduction;
	}
	// A lastba annak k�rnek a sz�m�t kell bevinni amikor szaporodott
	public void setLastReproduction(int last) {
		this.lastReproduction = last;
	}
	
	/**
	 * Szaporod�si kedv
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
	 * 		- Nem �hes
	 * 		- Van kivel
	 * 		- Van hova
	 */
	public boolean whatMod() {
		// M�g ki kell t�lteni ,de kell hozz� a cella foglalts�gi adat.
		return true;
	}
	
	
	/**
	 * Szaporod�s
	 * @param male  : H�m �llat
	 * @param female: N�st�ny �llat
	 * @return 		: K�lyk�k
	 */
	public Animal reproduction(Animal male, 
								Animal female) {
		return null;
	}
	
	@Override
	public String toString() {
		return "Kor: " + this.age + 
				"El�rhet� max kor: " + this.getMaxAge() + 
				"neme: " + this.sex;
	}

}

	
