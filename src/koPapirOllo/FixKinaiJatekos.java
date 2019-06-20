package koPapirOllo;

public class FixKinaiJatekos extends KinaiJatekos {

	public FixKinaiJatekos(int nyeresegvagy, int rizsKezdo, Visszateres fix) throws Exception {
		super(nyeresegvagy, rizsKezdo);
		this.vissza = fix;
	}
	
	public Visszateres getVissza() {
		return vissza;
		
	}

}
