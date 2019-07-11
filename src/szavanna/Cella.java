package szavanna;

public class Cella {
	/**
	 * 	Tulajdons�gok:
	 * 	x	- x koordin�ta
	 * 	x	- y koordin�ta
	 * 	x	- �res e
	 * 	x	- Mi van rajta ha nem �res
	 */
	
	/**
	 * K�t koordin�t�t fogad X �s Y
	 */
	private int x;
	private int y;
	/**
	 * �res e a cella
	 */
	private boolean empty;
	/**
	 * Mi van a cell�ban
	 * 		True - akkor ragadoz�
	 * 		False - akkor n�v�nyev�
	 */
	private boolean whatsIn;
	
	// Setters and Getters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		if(x <= 0) {
			this.x = x;
		}else if(x < 0){
			this.x = 0;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if(y <= 0) {
			this.y = y;
		}else if(y < 0) {
			this.y = 0;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public boolean isWhatsIn() {
		return whatsIn;
	}

	public void setWhatsIn(boolean whatsIn) {
		this.whatsIn = whatsIn;
	}
	
	// Konstruktor
	public Cella(	int x, 
					int y, 
					boolean empty, 
					boolean whatsIn) {
		this.setX(x);
		this.setY(y);
		this.setEmpty(true);
		this.setWhatsIn(true);
	}
	
	
	@Override
	public String toString() {
		String pic = null;
		if(this.empty) {
			pic = ".";
		}
		else if(!this.empty && this.whatsIn) {
			pic = "R";
		}
		else if(!this.empty && !this.whatsIn) {
			pic = "N";
		}
		return pic;
	}
}
