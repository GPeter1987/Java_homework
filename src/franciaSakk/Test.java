package franciaSakk;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws Exception {
			
		int[][] tabla = new int [8][8];
		
		for(int i = 0; i < tabla.length; i++) {
			for(int j = 0; j < tabla.length; j++) {
				tabla[i][j] = j; 
			}
		}
		// Matrix ki ír
		for(int[] row : tabla) {
			System.out.println(Arrays.toString(row));
		}
					
		//Cellák és koordinátákkal való ellátása			
		ArrayList<Cella> mezok = new ArrayList<Cella>();
		
			for(int i = 0; i < tabla.length; i++) {
				for(int j = 0; j < tabla.length; j++) {
					// Cella koordinátáinak megadása
					Cella cella = new Cella(i+1,j+1); 
					// Cella koordináták ki írása
					System.out.println(cella.toString()); 
				}
	
		
			}
	}
}
