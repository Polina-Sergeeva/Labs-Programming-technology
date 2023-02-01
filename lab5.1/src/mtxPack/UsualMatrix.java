package mtxPack;
import exceptionPack.*;
import java.util.Random;

public class UsualMatrix implements IMatrix{
    protected int matrix[][];
    protected int rows, columns;

    public UsualMatrix(){}
    public UsualMatrix(int rows, int columns){
        if(rows <= 0 || columns <= 0){
            throw new BoundException("The size cannot be negative!");
        }

        this.rows = rows;
        this.columns = columns;
        this.matrix = new int [rows][columns];
    }

    public IMatrix sum(IMatrix a){
        if(a.getRows() != this.getRows() || a.getColumns() != this.getColumns()){
            throw new exceptionPack.ArithmeticException("Cannot be sum!");
        }
        UsualMatrix res = new UsualMatrix(a.getRows(), a.getColumns());
        for(int i = 0; i < a.getRows(); i++){
            for(int j = 0; j < a.getColumns(); j++){
                int tmp = this.getElement(i, j) + a.getElement(i, j);
                res.setElement(i, j, tmp);
            }
        }
        return (IMatrix)res;
    }
    public IMatrix prod(IMatrix a){
        if(a.getColumns() != this.getRows() || a.getRows() != this.getColumns()){
            throw new exceptionPack.ArithmeticException("Cannot be sum!");
        }
        UsualMatrix res = new UsualMatrix(this.getRows(), this.getColumns());
        for(int i = 0; i < a.getRows(); i++){
            for(int j = 0; j < this.columns; j++){
                int tmp = 0;
                for(int k = 0; k < this.columns; k++){
                    //tmp += this.matrix[j][k] * a.matrix[k][i];
                    tmp += this.getElement(i, k) * a.getElement(k, j);
                }
                res.setElement(i, j, tmp);
            }
        }
        return (IMatrix)res;
    }
    public void setElement(int rows, int columns, int value){
        if(rows < 0 || rows >= this.getRows() || columns < 0 || columns >= this.getColumns()){
            throw new BoundException("Out of matrix's range!");
        }

        this.matrix[rows][columns] = value;
    }
    public int getElement(int rows, int columns){
        if(rows < 0 || rows >= this.getRows() || columns < 0 || columns >= this.getColumns()){
            throw new BoundException("Out of matrix's range!");
        }

        return this.matrix[rows][columns];
    }
    public final boolean equals(Object obj){
        if(obj == null || !(obj instanceof IMatrix)){
            return false;
        }

        IMatrix a = (IMatrix)obj;
        if(this.getRows() != a.getRows() || this.getColumns() != a.getColumns()){
            return false;
        }
        for(int i = 0; i < this.getRows(); i++){
            for(int j = 0; j < this.getColumns(); j++){
                if(this.getElement(i, j) != a.getElement(i, j)){
                    return false;
                }
            }
        }
        return true;
    }
    public int getRows(){
        return this.rows;
    }
    public int getColumns(){
        return this.columns;
    }

    public final String toString(){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < this.getRows(); i++){
            for(int j = 0; j < this.getColumns(); j++)
            {
                res.append(this.getElement(i, j) + " ");
            }
            res.append("\n");
        }
        return res.toString();
    }
    public void filling(){
        Random rand = new Random();
        for(int i = 0; i < this.getRows(); i++){
            for(int j = 0; j < this.getColumns(); j++){
                int val = rand.nextInt () % 100;
                if ( val == 0){
                    val += 34;
                    this.setElement(i, j, val);
                }
                else{
                    this.setElement(i, j, val);  
                }
            }
        }
        for(int k = 0; k < 1000; k++){
            this.setElement(rand.nextInt (999), rand.nextInt (999), 0);
        }
    }  
    public void fill1(){
        this.setElement(0, 1, 3);
        this.setElement(1, 0, 4);
        this.setElement(1, 2, 5);
        this.setElement(2, 1, 6);
        this.setElement(2, 0, 2);
        this.setElement(1, 1, 1);
    }
    public void fill2(){
        this.setElement(0, 1, 4);
        this.setElement(1, 0, 3);
        this.setElement(1, 2, 1);
        this.setElement(2, 1, 8);
        this.setElement(2, 0, 7);
        this.setElement(1, 1, 6);
    }
}

