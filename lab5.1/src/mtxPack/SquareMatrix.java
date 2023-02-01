package Matrix;

public class SquareMatrix extends Matrix{

    public SquareMatrix(int n){
        super(n, n);
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.coluwn; j++){
                if(i==j)
                matrix[i][j] = 1;
            }
        }
    }
    
    public SquareMatrix sum(Matrix m) {
        if(m.getRow() != this.getRow() || m.getColuwn() != this.getColuwn()) {
            throw new MatrixException("Wrong matrix for sum");  
        }

        SquareMatrix res = new SquareMatrix(m.getRow());
        for(int i = 0; i < m.getRow();i++){
            for(int j = 0; j < m.getColuwn(); j++) {
                res.matrix[i][j] = this.getElement(i, j) + m.getElement(i, j);
            }
        }
        return res;
    }
}
