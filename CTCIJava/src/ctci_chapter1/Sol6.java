package ctci_chapter1;

/*
 * rotate 4*4 matrix by 90 degree angle
 * 
 */
public class Sol6 {

	public static void main(String[] args) {
		int n=4;
		int[][] matrix = { 
							{ 20, 18, 22, 20 },
							{ 18, 20, 18, 21 },
							{ 16, 18, 16, 20 },
							{ 25, 24, 22, 24 }
            			};
		System.out.println("before matrix:");
		printMatrix(matrix, n);		
		
		System.out.println("\nafter matrix:");
		
		for(int layer=0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			
			for(int i=first; i<last; i++) {
				int offset = i - first;
						
				//save top
				int top = matrix[first][i];
				
				//left -> top
				matrix[first][i] = matrix[last - offset][first];
				
				//bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				//right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				
				//top to right
				matrix[i][last] = top;
			}
		}
		printMatrix(matrix, n);
	}
	
	public static void printMatrix(int[][] m, int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(m[i][j]);
				System.out.print(",");
			}
			System.out.println();
		}
	}
}