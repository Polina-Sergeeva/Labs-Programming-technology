package mtxPack;

interface IMatrix{
    public IMatrix sum(IMatrix a);
    public IMatrix prod(IMatrix a);
    public int getElement(int rows, int columns);
    public void setElement(int rows, int columns, int value);
    public int getRows();
    public int getColumns();
    public String toString();
}