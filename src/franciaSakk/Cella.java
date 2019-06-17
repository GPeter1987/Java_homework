package franciaSakk;

public class Cella {
	/**
	 * x,y egész számok, 1..8
	 */
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) throws Exception {
		if(x < 9 && x > 0) {
			this.x = x;
		}else {
			throw new Exception("Az értéknek 1 és 8 közti számnak kell lennie.");
		}
	}
	public int getY() {
		return y;
	}
	public void setY(int y) throws Exception {
		if(y < 9 && y > 0) {
			this.y = y;
		}else {
			throw new Exception("Az értéknek 1 és 8 közti számnak kell lennie.");
		}
	}
	/**
	 * Konstruktor
	 */
	public Cella(int x, int y) throws Exception {
		setX(x);
		setY(y);
	}
}
