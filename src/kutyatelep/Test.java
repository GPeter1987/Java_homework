package kutyatelep;



public class Test {

	public static void main(String[] args) throws Exception  {
		Kutya elso = new Kutya(BULLDOG, true);
		Kutya masodik = new Kutya(BULLDOG, false);
		Kutya kicsi = new Kutya(BULLDOG,true,false,elso,masodik,1);
		
		System.out.println(elso);
		System.out.println(masodik);
		System.out.println(kicsi);
		
		
	}

}
