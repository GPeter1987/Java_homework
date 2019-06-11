package kutyatelep;

import kutyatelep.Kutya.Faj;

public class Test {

	public static void main(String[] args) throws Exception  {
		Kutya elso = new Kutya(Faj.BULLDOG, true);
		Kutya masodik = new Kutya(Faj.BULLDOG, false);
		Kutya kicsi = new Kutya(Faj.BULLDOG,true,false,elso,masodik,1);
		
		System.out.println(elso);
		System.out.println(masodik);
		System.out.println(kicsi);
		
		masodik.tudszaporodni(elso);
		masodik.szaporodik(elso);
		
		
	}

}
