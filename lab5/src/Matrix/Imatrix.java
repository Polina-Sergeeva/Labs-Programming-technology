package Matrix;

public interface Imatrix {
    public String toString(); // не должно быть тут
    public boolean equals(Object m); // не должно быть тут
    public Imatrix product(Imatrix m);
    public Imatrix sum(Imatrix m); // разобраться с возвращаемым значением и входным типом
    public void fill();
    public void setElement(int row, int column, int value);
    public int getElement (int row, int column);
    public int getRow();
    public int getColumn();

    
}