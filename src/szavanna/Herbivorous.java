package szavanna;

public class Herbivorous extends Animal{
	
	/**
	*		- Max �letkor (	ragadoz�: 9-12 �v,
	* 						n�v�nyev�: 11-14 �v)
	*/

	public Herbivorous(	int pos0, 
						int pos1, 
						boolean tof, 
						int hunger, 
						boolean sex, 
						int age, 
						int last, 
						boolean mod) {
		super(pos0, pos1, tof, hunger, sex, age, last, mod);
		this.setMaxAge(); 
	}
	
	public Herbivorous(int x, int y) {
		super(x,y);
		this.setMaxAge();
	}
	
	// Megmondja ,hogy mennyi lehet a max kora az �llatnak
		private int maxAge;

		
		@Override
		public void setMaxAge() {
			this.maxAge = rnd.nextInt(14-11)+11;
		}
		
		//Megmondja, hogy az �lalt �l e m�g
		public boolean isItLive(Herbivorous a) {
			if(a.isLive() && a.getAge() <= a.maxAge) {
				a.setLive(true);
			}else {
				a.setLive(false);
			}
			return a.isLive();
		}
}
