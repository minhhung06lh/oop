//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

import java.util.Arrays;

public class TetrisGrid {
	private boolean[][] grid;

	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}


	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int rows = grid.length;
		int cols = grid[0].length;
		int lastRows = rows - 1;
		for (int i = rows - 1; i >= 0; i--) {
			int count = 0;
			for (int j = 0; j < cols; j++) {
				if (grid[i][j]) count++;
			}
			if (count < cols) {
				for (int j = 0; j < cols; j++) {
					grid[lastRows][j] = grid[i][j];
				}
				lastRows--;
			}
		}
		for (int i = lastRows; i >= 0; i--) {
			for (int j = 0; j < cols; j++) {
				grid[i][j] = false;
			}
		}
	}

	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return this.grid; // YOUR CODE HERE
	}
}
