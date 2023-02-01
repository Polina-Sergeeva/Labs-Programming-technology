class Matrix {

	private int [][] matrix;
	public Matrix (int n) {
		matrix = new int [n][n];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][i] = 1;
		}
	}
	
	public void setElement (int row, int column, int value) {
		matrix[row][column] = value;
	}
	public int getElement(int row, int column) {
		return matrix[row][column];
	}
	public Matrix sum (Matrix m) {
		Matrix res = new Matrix (matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
			 		res.setElement (i, j, getElement (i, j) + m.getElement (i, j));
				} 	
		}
		return res;
	}
	public Matrix product (Matrix m) {
		Matrix res = new Matrix (matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				res.setElement (i, j, 0);
				for (int k = 0; k < matrix.length; k++) {
					res.setElement (i, j, res.getElement (i, j) + getElement (i, k) * m.getElement (k, j));
				}
			}
		}
		return res;
	}
	public void swapColumns(int n1, int n2){
		for (int i = 0; i < matrix.length; i++)
		{
			int tmp = getElement (i, n1);
			setElement (i, n1, getElement (i, n2));
			setElement (i, n2, tmp);
		}	
		//return this;
	}
	public Matrix doSortColumns() {
		//Matrix res = new Matrix (matrix.length);
		int[] max = new int [matrix.length];
			for (int j = 0; j < matrix.length; j++){
				for(int k = 0; k < matrix.length; k++){
					max[j] += getElement(k, j);
				}
			}
		for (int l = 0; l < matrix.length; l++) {
			int min = l;
			for (int p = l + 1; p < matrix.length; p++){
				if (max[p] < max[min]){ 
					min = p;
					swapColumns(l, min);
				}
			}
		}
		return this;
	}

	public String toString () {
		StringBuffer res = new StringBuffer ();
		res.append ("\n");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				res.append (getElement (i, j));
				res.append (" ");
			}
			res.append ("\n");
		}
		return res.toString ();
	}
}