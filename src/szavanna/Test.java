package szavanna;

public class Test {

	public static void main(String[] args) {
		
		Predator lion = new Predator(5,2);
		
		System.out.println(lion.getAge());
		System.out.println(lion.getMaxAge());
		System.out.println(lion.getSex());
		System.out.println(lion.getHunger());
		System.out.println(lion.getPosition());
		lion.toString();
	}

}
