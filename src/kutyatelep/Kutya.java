package kutyatelep;

public class Kutya {
	
	private enum faj {
		TERRIER,
		BULLDOG,
		SPANIEL,
		VIZSLA
	}
	
	
	
	private boolean him;
	private boolean torzskonyvezett;
	private int kora = 1;
	private Kutya apa;
	private Kutya anya;
	
	
	
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
	public Kutya getApa() {
		return apa;
	}
	public void setApa(Kutya k) throws Exception {
		if(k == null) {
			throw new Exception("Egyik szülõ(apa) sem lehet null.");
		}else {
			apa = k;
		}
	}
	public Kutya getAnya() {
		return anya;
	}
	public void setAnya(Kutya k) throws Exception {
		if(k == null) {
			throw new Exception("Egyik szülõ(anya) sem lehet null.");
		}else {
			apa = k;
		}
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
