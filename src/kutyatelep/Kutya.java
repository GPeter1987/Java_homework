package kutyatelep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kutya {
	
	public enum Faj {
		TERRIER,
		BULLDOG,
		SPANIEL,
		VIZSLA
	}
	
	static Random rnd = new Random();
	
	public Faj fajta;
	private boolean him;
	private boolean torzskonyvezett;
	private int kora = 1;
	private Kutya apa = null;
	private Kutya anya = null;
	
	
	
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
		if(k.isHim() != true) {
			throw new Exception("Egyik szülõ(apa) sem lehet null.");
		}else {
			apa = k;
		}
	}
	public Kutya getAnya() {
		return anya;
	}
	public void setAnya(Kutya k) throws Exception {
		if(k.isHim() != false) {
			throw new Exception("Egyik szülõ(anya) sem lehet null.");
		}else {
			anya = k;
		}
	}
	


	/*  Konstruktor  */
	public Kutya(Faj fajta,boolean him,boolean torzskonyvezett,Kutya apa, Kutya mama, int kor) throws Exception {
		this.fajta = fajta;
		setHim(him);
		setTorzskonyvezett(torzskonyvezett);
		setKora(kor);
		setApa(apa);
		setAnya(mama);
	}
	
	public Kutya(Faj fajta, boolean him) {
		this.fajta = fajta;
		setHim(him);
		torzskonyvezett = false;
		kora = 1;
		apa = null;
		anya = null;
	}
	
	/* Metódusok */
	
	
	/**
	 * Megmutatja ,hogy két kutya példány képes e szaporodni egymással
	 * @param p => A másik kutya
	 * @return true vagy false
	 */
	public boolean tudszaporodni(Kutya p) {
		boolean tud;
		if(p.him == this.him || p.fajta != this.fajta) {
			tud = false;
		}else {
			tud = true;
		}
		//System.out.println(tud);    //ellenõrzés
		return tud;
		
	}
	
	/**
	 * Random számú kiskutyat hoz létre 4-8 közt.
	 * A megadott szülõbõl plusz a jelenlegi pédányból
	 * @param a => A másik kutya amivel szaporítani akarunk.
	 * @throws Exception 
	 */
	public List<Kutya> szaporodik(Kutya a) throws Exception {
		
		
		if(tudszaporodni(a)) {
			
			int kisKutyaSzam = rnd.nextInt(8 - 4) + 4;
			boolean kisKutyaTorzskonyv = false;
			
			if(this.torzskonyvezett && a.torzskonyvezett) {
				kisKutyaTorzskonyv = true;
			}
			List<Kutya> kisKutya = new ArrayList<Kutya>();
			
			for(int i =0; i < kisKutyaSzam; i++) {
				boolean kisKutyaNeme = (rnd.nextInt(100-1)+1) < 50;
				
				Kutya apa, anya;
                if(a.isHim()){
                    apa=a;
                    anya=this;
                }
                else{
                    apa=this;
                    anya=a;
                }
				
				Kutya kis_Kutya = new Kutya(this.fajta,kisKutyaNeme,kisKutyaTorzskonyv,apa,anya,1);
				kisKutya.add(kis_Kutya);
			}
			//	System.out.println(kisKutya);
				return kisKutya;
			
		}else{
			return null;
		}
		
	}
	
	@Override
	public String toString() {
		return "A kutya faja: " + fajta + " a kutya hím: " + him + " van törzskönyve: "
				+ torzskonyvezett + " Kora: " + kora;
	}

}
