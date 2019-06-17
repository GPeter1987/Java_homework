package franciaSakk;

public interface Sakk {

	public enum Csapat {
		SOTET,
		VILAGOS
	}
	
	int[] pozicio = new int[2];
	
	/**
	 * ütés függvény, paramétere a sakktáblán még 
	 * "életben" lévõ bábuk listája (ellenség és barát, 
	 * mindenki), a függvény ebbõl választ egy bábut 
	 * akit le tud(na) ütni. ha nincs ilyen bábu, 
	 * akkor null értékkel tér vissza. 
	 */
	public void utes();
	
	/**
	 * lépés függvény, paramétere a táblán jelenleg 
	 * üres cellák listája, a függvény megad ebbõl 
	 * 1 cellát ahova a bábu lépni tud, vagy null-t 
	 * ha sehova nem tud lépni 
	 */
	public void lepes();
}
