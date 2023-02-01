package matrix;
import exceptions.*;

	public class Matrix {
	protected int [][] matrix;
	protected int rows;
	protected int columns;
	public Matrix (int rows, int columns) {
		matrix = new int [rows][columns];
		this.rows = rows;
		this.columns = columns;
	}
	//установка элемента
	final public void setElement (int row, int column, int value){
		if (row < 0 || row >= rows) {
			throw new WrongMatrixIndexException ("ERROR! Incorrect row.");
		}
		if (column < 0 || column >= columns) {
			throw new WrongMatrixIndexException ("ERROR! Incorrect column.");
		}
		matrix[row][column] = value;
	}
	//доступ к элементу
	final public int getElement (int row, int column){
		if (row < 0 || row >= rows) {
			throw new WrongMatrixIndexException ("ERROR! Incorrect row.");
		}
		if (column < 0 || column >= columns) {
			throw new WrongMatrixIndexException ("ERROR! Incorrect column.");
		}
		return matrix[row][column];
	}
	public Matrix sum (Matrix m){
		if (!(rows == m.rows && columns == m.columns)) {
			throw new WrongMatrixSizeException ("ERROR! Can't sum matrices of different sizes.");
		}
		Matrix res = new Matrix (rows, columns);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
			 		res.setElement (i, j, getElement (i, j) + m.getElement (i, j));
				} 	
		}
		return res;
	}
	public Matrix product (Matrix m){
		if (columns != m.rows) {
			throw new WrongMatrixSizeException ("ERROR! Can't multiply: amownt of columns of first matrix is not equal to the amownt of rows of the second matrix.");
		}
		Matrix res = new Matrix (rows, m.columns);
		for (int i = 0; i < res.rows; i++) {
			for (int j = 0; j < res.columns; j++) {
				res.setElement (i, j, 0);
				for (int k = 0; k < columns; k++) {
					res.setElement (i, j, res.getElement (i, j) + getElement (i, k) * m.getElement (k, j));
				}
			}
		}
		return res;
	}
	final public String toString () {
		StringBuilder res = new StringBuilder ();
		res.append ("\n");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				res.append (getElement (i, j));
				res.append (" ");
			}
			res.append ("\n");
		}
		return res.toString ();
	}
	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		//if (getClass() != obj.getClass())
			//return false;
		Matrix other = (Matrix) obj;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				if (matrix[i][j] != other.matrix[i][j])
					return false;
		return true;
	}
}