import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {

    private Queue<int[]> q = new LinkedList<int[]>();

    public PercolationBFS(int size) {
        super(size);
    }

    @Override
    protected void dfs(int row, int col) {
        // out of bounds?
        if (!inBounds(row,col)) return;

        // full or NOT open, don't process
        if (isFull(row, col) || !isOpen(row, col))
            return;

        q.add(new int[]{row,col});
        myGrid[row][col] = FULL;

        while (q.size() != 0) {
            int[] temp = q.remove();
            int r = temp[0];
            int c = temp[1];
            if (inBounds(r - 1, c) && isOpen(r - 1, c) && !isFull(r - 1, c)) {
                myGrid[r - 1][c] = FULL;
                q.add(new int[]{r - 1, c});
            }
            if (inBounds(r + 1, c) && isOpen(r + 1, c) && !isFull(r + 1, c)) {
                myGrid[r + 1][c] = FULL;
                q.add(new int[]{r + 1, c});
            }
            if (inBounds(r, c - 1) && isOpen(r, c - 1) && !isFull(r, c - 1)) {
                myGrid[r][c - 1] = FULL;
                q.add(new int[]{r, c - 1});
            }
            if (inBounds(r, c + 1) && isOpen(r, c + 1) && !isFull(r, c + 1)) {
                myGrid[r][c + 1] = FULL;
                q.add(new int[]{r, c + 1});
            }
        }
    }
}
