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
		// Matrix ki �r
		for(int[] row : tabla) {
			System.out.println(Arrays.toString(row));
		}
					
		//Cell�k �s koordin�t�kkal val� ell�t�sa			
		ArrayList<Cella> mezok = new ArrayList<Cella>();
		
			for(int i = 0; i < tabla.length; i++) {
				for(int j = 0; j < tabla.length; j++) {
					// Cella koordin�t�inak megad�sa
					Cella cella = new Cella(i+1,j+1); 
					// Cella koordin�t�k ki �r�sa
					System.out.println(cella.toString()); 
				}
	
		
			}
	}
}
