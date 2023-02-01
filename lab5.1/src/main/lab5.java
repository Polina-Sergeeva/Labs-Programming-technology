package main;
import mtxPack.*;


class lab5 {
    public static void main(String [] args) {
        /*UsualMatrix m = new UsualMatrix(1000, 1000);
        SparseMatrix sm = new SparseMatrix(1000, 1000);
        m.filling();
        sm.filling();*/
        UsualMatrix m = new UsualMatrix(3, 3);
        SparseMatrix sm = new SparseMatrix(3, 3);
        UsualMatrix m2 = new UsualMatrix(3, 3);
        SparseMatrix sm2 = new SparseMatrix(3, 3);
        m.fill1();
        sm.fill1();
        m2.fill2();
        sm2.fill2();
        System.out.println("Matrix m");
        System.out.println(m);
        System.out.println("Matrix sm2");
        System.out.println(sm2);
        System.out.println("Product Matrix m and Matrix sm2");
        System.out.println(m.prod(sm2));
        //System.out.println(sm.prod(sm2));
        System.out.println("Matrix m and Matrix sm");
        if (m.equals(sm)) {
            System.out.println("Equals");
        }
        else {
            System.out.println("Not Equals");
        }
    }
}
