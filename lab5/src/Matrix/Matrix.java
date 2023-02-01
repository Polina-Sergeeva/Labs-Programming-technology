package Matrix;

public class Matrix implements Imatrix {
    protected int row;
    protected int coluwn;
    protected int matrix[][];

    public Matrix(int row, int coluwn) {
        this.row = row;
        this.coluwn = coluwn;
        this.matrix = new int [row][coluwn];
    }

     public final boolean equals(Object obj){
        if(obj == null || !(obj instanceof IMatrix)){
            return false;
        }

        IMatrix a = (IMatrix)obj;
        if(this.getRow() != a.getRow() || this.getColumn() != a.getColumn()){
            return false;
        }
        for(int i = 0; i < this.getRow(); i++){
            for(int j = 0; j < this.getColumn(); j++){
                if(this.getElement(i, j) != a.getElement(i, j)){
                    return false;
                }
            }
        }
        return true;
    }
    public Imatrix product(Imatrix iM) {
        Matrix m = (Matrix) iM;
        if(this.getRow() != m.getColuwn()) {
            throw new MatrixException("Wrong matrix for product");
        }
        Matrix res = new Matrix(this.getRow(), m.getColuwn());
         for(int i = 0; i <res.getRow(); i++) {
             for(int j = 0; j < res.getColuwn(); j++) {
                res.matrix[i][j] = 0;
                for(int k = 0; k < res.getColuwn(); k++) {
                    res.matrix[i][j] += this.matrix[i][k] * m.matrix[k][j];
                }
            }
        } 
        return res;
    }
    public void setElement(int row, int column, int value) {
        this.matrix[row][column] = value;
    }

    public int getElement (int row, int column) {
        return(this.matrix[row][column]);
    }

    final public int getRow() {
        return(this.row);
    }

    final public int getColuwn() {
        return(this.coluwn);
    }

    public Imatrix sum(Imatrix m) {
        if(m.getRow() != this.getRow() || m.getColuwn() != this.getColuwn()) {
            throw new MatrixException("Wrong matrix for sum");  
        }

        Matrix res = new Matrix(this.getRow(), this.getColuwn());
        for(int i = 0; i < this.row; i++) {
            for(int j = 0; j < this.coluwn; j++) {  
                res.matrix[i][j] = this.getElement(i, j) + m.getElement(i,j);              
            }
        }
        return res;
    }
    
        public void fill() {
            this.setElement(220, 120, 500);
            this.setElement(250, 201, 500);
            this.setElement(250, 210, 500);
            this.setElement(230, 200, 500);
            this.setElement(180, 210, 500);
            this.setElement(250, 120, 500);
            this.setElement(290, 201, 500);
            this.setElement(280, 210, 500);
            this.setElement(240, 200, 500);
            this.setElement(480, 210, 500);
            this.setElement(820, 120, 500);
            this.setElement(950, 201, 500);
            this.setElement(850, 210, 500);
            this.setElement(630, 200, 500);
            this.setElement(980, 210, 500);
            this.setElement(720, 120, 500);
            this.setElement(850, 201, 500);
            this.setElement(660, 210, 500);
            this.setElement(920, 200, 500);
            this.setElement(10, 210, 500);
    
    }
    
     public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < this.getRow(); i++)
        {
            for (int j = 0; j < this.getColuwn(); j++) {
                str.append(this.getElement(i, j));
                str.append(" ");
            }
            str.append(" \n");
        }
        return str.toString();
    }
}
