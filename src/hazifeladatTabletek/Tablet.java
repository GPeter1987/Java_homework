package hazifeladatTabletek;

public class Tablet {
	
	
	/**
	 * A felbontások csak párban szerepelhetnek. Ezt az azonos index megadással akarom elérni.
	 */
	private int[] resXArray = {640,800,1024}; // X felbontás ,egész szám
	private int[] resYArray = {480,600,768}; // Y felbontás , egész szám
	private double[] androidVerzioArray = {4.0, 4.1, 4.2}; // Csak ezek az android verziók valid értékek
	
	private int resX;
	private int resY;
	private boolean vanKamera = false;
	private boolean vanGps = false;
	private double androidVerzio;
	private int ar; // Egész szám 10e...800e közt kell legyen ,de 1-el oszthatónak kell lennie
	
	
	/* =======> Getterek & Setterek <======= */
	
	public int getResX() {
		return resX;
	}
	public void setResX(int resX) throws Exception {
		if (resX == resXArray[0] || resX == resXArray[1] || resX == resXArray[2]) {
		this.resX = resX;
		}else {
			throw new Exception("A megadott felbontás elsõ eleme csak 640,800,1024 lehet.");
		}
	}
	public int getResY() {
		return resY;
	}
	public void setResY(int resY) throws Exception {
		if(resY == resYArray[0] || resY == resYArray[1] || resY == resYArray[2]) {
		this.resY = resY;
		}
		else {
			throw new Exception("A megadott felbontás második eleme csak 480,600,768 lehet.");
		}
	}
	public boolean isVanKamera() {
		return vanKamera;
	}
	public void setVanKamera(boolean vanKamera) {
		this.vanKamera = vanKamera;
	}
	public boolean isVanGps() {
		return vanGps;
	}
	public void setVanGps(boolean vanGps) {
		this.vanGps = vanGps;
	}
	public double getAndroidVerzio() {
		return androidVerzio;
	}
	public void setAndroidVerzio(double androidVerzio) throws Exception {
		if(		androidVerzio == androidVerzioArray[0] || 
				androidVerzio == androidVerzioArray[1] || 
				androidVerzio == androidVerzioArray[2] ) {
		this.androidVerzio = androidVerzio;
		}else {
			throw new Exception("A megadott android verzió csak 4.0, 4.1, 4.2 lehet.");
		}
	}
	public int getAr() {
		return ar;
	}
	public void setAr(int ar) throws Exception {
		if(ar >= 10000 && ar <= 800000) {
			this.ar = ar;
		}else {
			throw new Exception("Az árnak 10.000 és 800.000 Huf közt kell lennie.");
		}
	}
	
	/* =======> Konstruktorok <======= */
	
	// Konstruktor 6 mezõvel
	public Tablet(int resXIndex, int resYIndex, boolean kamera, boolean gps, double androidV, int ar) {
		
	}
	// Konstruktor 4 mezõvel
	public Tablet(int resXIndex, int resYIndex, double android, int ar) {
		
	}
	// Konstruktor ahol csak az ár van megadva, minden más a minimális lehetséges értéken
	public Tablet(int ar) {
		
	}

}
