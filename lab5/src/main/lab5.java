package main;
import Matrix.*;


class lab5 {
    public static void main(String [] args) {
        Matrix m = new Matrix(1000, 300);
        m.fill();
        //System.out.println(m);
        SparseMatrix sm = new SparseMatrix(1000, 300);
        m.fill();
        sm.fill();
        if (m.equals(sm)) {
            System.out.println("Equals");
        }
        else {
            System.out.println("Not Equals");
        }
    }
}
