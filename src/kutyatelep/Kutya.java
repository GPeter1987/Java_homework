package kutyatelep;

public class Kutya {
	
	enum faj {
		TERRIER,
		BULLDOG,
		SPANIEL,
		VIZSLA
	}
	
	faj terrier = faj.TERRIER;
	faj bulldog = faj.BULLDOG;
	faj spaniel = faj.SPANIEL;
	faj vizsla = faj.VIZSLA;
	
	private boolean him;
	private boolean torzskonyvezett;
	private int kora = 1;
	
	
	
	/* Getterek és setterek */
	public boolean isHim() {
		return him;
	}
	public void setHim(boolean him) {
		this.him = him;
	}
	public boolean isTorzskonyvezett() {
		return torzskonyvezett;
	}
	public void setTorzskonyvezett(boolean torzskonyvezett) {
		this.torzskonyvezett = torzskonyvezett;
	}
	public int getKora() {
		return kora;
	}
	public void setKora(int kora) {
		this.kora = kora;
	}


	/*  Konstruktor  */
	public Kutya(faj faj,boolean him,boolean torzskonyvezett,Kutya apa, Kutya mama, int kor) {
		
		setHim(him);
		setTorzskonyvezett(torzskonyvezett);
		setKora(kor);
	}
	
	public Kutya(faj faj, boolean him) {
		
		setHim(him);
	}
	
	/* Metódusok */
	
	
	/**
	 * Megmutatja ,hogy két kutya példány képes e szaporodni egymással
	 * @param p => A másik kutya
	 * @return true vagy false
	 */
	public boolean tudszaporodni(Kutya p) {
		boolean tud = true;
		if(p.him == this.him && (p.terrier == this.terrier || 
								 p.bulldog == this.bulldog || 
								 p.spaniel == this.spaniel || 
								 p.vizsla == this.vizsla)) {
			tud = false;
		}else {
			tud = true;
		}
		return tud;
	}
	
	public void szaporodik(Kutya a) {
		
	}

}
