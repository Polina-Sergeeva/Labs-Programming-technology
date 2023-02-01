package matrix;

import exceptions.*;

public class SquareMatrix extends Matrix {
	public SquareMatrix (int n) {
		super (n, n);
		for (int i = 0; i < rows; i++) {
			matrix[i][i] = 1;
		}
	}
	@Override
	public SquareMatrix sum (Matrix m) {
		if (!(rows == m.rows && columns == m.columns)) {
			throw new WrongMatrixSizeException ("ERROR! Can't sum matrices of different sizes.");
		}
		SquareMatrix res = new SquareMatrix (rows);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
			 		res.setElement (i, j, getElement (i, j) + m.getElement (i, j));
				} 	
		}
		return res;
	}
}