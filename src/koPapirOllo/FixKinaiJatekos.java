package koPapirOllo;

public class FixKinaiJatekos extends KinaiJatekos {

	public FixKinaiJatekos(int nyeresegvagy, int rizsKezdo, Visszateres fix) throws Exception {
		super(nyeresegvagy, rizsKezdo);
		this.setMohosag(nyeresegvagy);
		this.setRizsKezdo(rizsKezdo);
		this.vissza = fix;
		this.setRizsMenny(rizsKezdo);
	}
	
	public Visszateres getVissza() {
		return this.vissza;
		
	}

}
