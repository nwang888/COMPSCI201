import java.util.Arrays;

public class PercolationUF implements IPercolate{

    private IUnionFind myFinder;
    private boolean[][] myGrid;
    private final int VTOP, VBOTTOM;
    private int myOpenCount;

    public PercolationUF(IUnionFind finder, int size) {
        finder.initialize(size*size + 2); //# of sets determined by grid + the top + the bottom
        myFinder = finder;
        VTOP = size*size;
        VBOTTOM = size*size + 1;

        myGrid = new boolean[size][size];

        for(boolean row[]: myGrid)
            Arrays.fill(row, false);
    }

    private int getIndex(int row, int col) {
        return row * myGrid.length + col;
    }

    @Override
    public void open(int row, int col) {

        if (!inBounds(row,col))
            throw new IndexOutOfBoundsException("row or column exceeds grid dimensions");

        if (isOpen(row,col))
            return;

        myGrid[row][col] = true;
        myOpenCount++;
        int cell = getIndex(row, col);

        if (row == 0)
            myFinder.union(cell, VTOP);

        if (row == myGrid.length - 1)
            myFinder.union(cell, VBOTTOM);

        if (inBoundsAndOpen(row, col + 1))
            myFinder.union(cell, cell + 1);
        if (inBoundsAndOpen(row, col - 1))
            myFinder.union(cell, cell - 1);
        if (inBoundsAndOpen(row + 1, col))
            myFinder.union(cell, cell + myGrid.length);
        if (inBoundsAndOpen(row - 1, col))
            myFinder.union(cell, cell - myGrid.length);
    }

    private boolean inBoundsAndOpen(int row, int col) {
        return (inBounds(row, col) && isOpen(row, col));
    }

    @Override
    public boolean isOpen(int row, int col) {
        if (!inBounds(row,col))
            throw new IndexOutOfBoundsException("row or column exceeds grid dimensions");
        return myGrid[row][col];
    }

    @Override
    public boolean isFull(int row, int col) {
        if (!inBounds(row,col))
            throw new IndexOutOfBoundsException("row or column exceeds grid dimensions");
        return myFinder.connected(getIndex(row,col), VTOP);
    }

    @Override
    public boolean percolates() {
        return myFinder.connected(VTOP, VBOTTOM);
    }

    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }

    private boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
        if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }
}
