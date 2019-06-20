package franciaSakk;

public interface Babu {

	public enum Csapat {
		SOTET,
		VILAGOS
	}
	
	int[] pozicio = new int[2];
	
	public int getPozicioX();
	public int getPozicioY();
	public void setPozicioX(int x);
	public void setPozicioY(int y);
	
	
	/**
	 * �t�s f�ggv�ny, param�tere a sakkt�bl�n m�g 
	 * "�letben" l�v� b�buk list�ja (ellens�g �s bar�t, 
	 * mindenki), a f�ggv�ny ebb�l v�laszt egy b�but 
	 * akit le tud(na) �tni. ha nincs ilyen b�bu, 
	 * akkor null �rt�kkel t�r vissza. 
	 */
	public void utes();
	
	/**
	 * l�p�s f�ggv�ny, param�tere a t�bl�n jelenleg 
	 * �res cell�k list�ja, a f�ggv�ny megad ebb�l 
	 * 1 cell�t ahova a b�bu l�pni tud, vagy null-t 
	 * ha sehova nem tud l�pni 
	 */
	public void lepes();
}
