package matrix;
import exceptions.*;

public class OneColumnMatrix extends Matrix {
	public OneColumnMatrix (int rows, int columns) {
		super (rows, 1);
		this.columns = columns;
	}

	@Override
	public int getElement (int row, int column) throws BadRangeMatrixException {
		if (row < 0 || row >= rows) {
			throw new BadRangeMatrixException  ("ERROR! Incorrect row.");
		}
		if (column < 0 || column >= columns) {
			throw new BadRangeMatrixException  ("ERROR! Incorrect column.");
		}
		return matrix[row][0];
	}

	@Override
	public void setElement (int row, int column, int val) throws BadRangeMatrixException{
		if (row < 0 || row >= rows) {
			throw new BadRangeMatrixException  ("ERROR! Incorrect row.");
		}
		if (column < 0 || column >= columns) {
			throw new BadRangeMatrixException  ("ERROR! Incorrect column.");
		}
		matrix[row][0] = val;
	}
}