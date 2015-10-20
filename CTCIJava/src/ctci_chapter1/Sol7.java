package ctci_chapter1;

/*
 * write an algorithm that if an element in matrix M*N is 0, then set entire row and
 * column to 0
 * 
 */
public class Sol7 {

	public static void main(String[] args) {
		int n = 4;
		int[][] matrix = { 
							{ 0, 18, 22, 20 },
							{ 18, 0, 18, 21 },
							{ 16, 18, 16, 20 },
							{ 25, 24, 22, 24 }
						};
		System.out.println("\nbefore matrix:");
		printMatrix(matrix, n);
		
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}			
		}
		
		for(int r=0; r<matrix.length; r++) {
			if(row[r]) {
				nullifyEntireRow(matrix, r);
			}
		}
		
		for(int c=0; c<matrix[0].length; c++) {
			if(column[c]) {
				nullifyEntireColumn(matrix, c);
			}
		}
		
		System.out.println("\nafter matrix:");
		printMatrix(matrix, n);		
	}
	
	public static void nullifyEntireRow(int[][] m, int row) {
		for(int i=0; i<m.length; i++) {
			m[row][i] = 0;
		}
	}
	
	public static void nullifyEntireColumn(int[][] m, int col) {
		for(int i=0; i<m[0].length; i++) {
			m[i][col] = 0;
		}
	}

	public static void printMatrix(int[][] m, int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(m[i][j] + ",");
			}
			System.out.println();
		}
	}
}
