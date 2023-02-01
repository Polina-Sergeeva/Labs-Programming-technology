package main;
import exceptions.*;
import matrix.*;

public class lab3  {
	public static void main (String[] args) throws  NonSuitableMatrixException, BadRangeMatrixException {
		Matrix m = new Matrix(2, 2);
		OneColumnMatrix m1 = new OneColumnMatrix(2, 2);
		try {
			m.setElement (0, 1, 12);
		}
		catch (BadRangeMatrixException e) {
			System.out.println (e.getMessage ());
		}
		try {
			System.out.println(m.sum(m1));
		}
		catch (NonSuitableMatrixException e) {
			System.out.println (e.getMessage ());
		}
	}
}