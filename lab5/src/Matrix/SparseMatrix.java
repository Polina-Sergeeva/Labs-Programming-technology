package Matrix;
import java.util.LinkedList;
import java.util.ListIterator;

public class SparseMatrix implements Imatrix{
    class SparseMatrixNode {
        private int line;
        private int column;
        private int value;
    
        public SparseMatrixNode(int lin, int colum, int val) {
            this.line = lin;
            this.column = colum;
            this.value = val;
        }
        public int getLin() {
            return this.line;
        }
        public int getColumn () {
            return this.column;
        }
        public boolean contains(int lin, int colum) {
            if (this.column == colum && this.line == lin){
                return true;
            }
            else {
                return false;
            }
        }
        public int getValue(int lin, int colum) {
            return this.value;
        }
    }
    private int line;
    private int column;
    private LinkedList l;
    
    public SparseMatrix(int lin, int colum) {
        this.line = lin;
        this.column = colum;
        this.l = new LinkedList<SparseMatrixNode>();
    }
// 
    public Imatrix  sum(Imatrix s) {
        SparseMatrix sm = (SparseMatrix) s;
        SparseMatrix res = new SparseMatrix(this.line, this.column);
        ListIterator<SparseMatrixNode> it = this.l.listIterator();
        ListIterator<SparseMatrixNode> it1 = sm.l.listIterator();
        //ListIterator<SparseMatrixNode> itRes = res.l.listIterator();
        
        SparseMatrixNode cur;
        SparseMatrixNode cur1 = it1.next();
        if (this.column == sm.column && this.line == sm.line) {
            while (it.hasNext()) {
                it1 = sm.l.listIterator();
            
                while (it1.hasNext()) {
                    cur = it.next();
                if (cur.contains(cur1.getLin(), cur1.getColumn())) {
                    res.setElement(cur1.getLin(), cur1.getColumn(), cur1.getValue(cur1.getLin(), cur1.getColumn() + cur.getValue(cur.getLin(), cur.getColumn())));
                }
                else {
                    res.setElement(cur.getLin(), cur.getColumn(), cur.getValue(cur.getLin(), cur.getColumn()));
                }
                }
                cur1 = it.next();
            }
           

        }
        return (Imatrix) res;

    }
    public void setElement(int lin, int colum, int val) {
        SparseMatrixNode n = new SparseMatrixNode(lin, colum, val);
        ListIterator<SparseMatrixNode> it = this.l.listIterator();
        while(it.hasNext()) {
            it.next();
           if(n.equals(it)) {
                it.remove();
                it.add(n);
                return;
           }
        }
        this.l.add(n);
    }

    public void fill() {  /*дописать до правильного варианта
        (уйти от варианта с изм сост к immutable подходу) погуглить поняти функциональное программирование*/
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
    public int getRow() {
        return this.line;
    }
    public int getColuwn() {
        return this.column;
    }
    public int getElement(int lin, int colum) {
        //SparseMatrixNode n = new SparseMatrixNode(lin, colum, 0);
        SparseMatrixNode tmp;
        ListIterator<SparseMatrixNode> it = this.l.listIterator();
        while(it.hasNext()) {

            tmp = it.next();
            if(tmp.contains(lin, colum)) {
                return tmp.getValue(lin, colum);
            }
        }
        return 0;
    }
    public void remove(SparseMatrixNode n) {
        this.l.remove(n);
    }

    public Imatrix product (Imatrix s) {
        SparseMatrix sm = (SparseMatrix ) s;
        SparseMatrix res = new SparseMatrix(this.line, this.column);
        ListIterator<SparseMatrixNode> it = this.l.listIterator();
        ListIterator<SparseMatrixNode> it1 = sm.l.listIterator();

        SparseMatrixNode cur;
        SparseMatrixNode cur1 = it1.next();
        if (this.column == sm.column && this.line == sm.line) {
            while (it.hasNext()) {
                it1 = sm.l.listIterator();
            
                while (it1.hasNext()) {
                    cur = it.next();
                if (cur.contains(cur1.getLin(), cur1.getColumn())) {
                    for(int i = 0; i < this.column; i++)
                    {
                        int num = 0;
                        num = num + cur.getValue(i, cur.getColumn());
                    }
                    res.setElement(cur1.getLin(), cur1.getColumn(), cur1.getValue(cur1.getLin(), cur1.getColumn() + cur.getValue(cur.getLin(), cur.getColumn())));
                }
                else {
                    res.setElement(cur.getLin(), cur.getColumn(), cur.getValue(cur.getLin(), cur.getColumn()));
                }
                }
                cur1 = it.next();
            }
           

        }

        return (Imatrix) res;
    }
}
