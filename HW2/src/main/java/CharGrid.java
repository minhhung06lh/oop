// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}

	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int minRow = grid.length;
		int maxRow = 0;
		int minCol = grid[0].length;
		int maxCol = 0;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == ch) {
					minRow = Math.min(minRow, i);
					maxRow = Math.max(maxRow, i);
					minCol = Math.min(minCol, j);
					maxCol = Math.max(maxCol, j);
					count++;
				}
			}
		}
		if (count == 0) {
			return 0;
		}
		return (maxRow - minRow + 1) * (maxCol - minCol + 1); // YOUR CODE HERE
	}

	public int directionCount(int i, int j, int dirI, int dirJ) {
		char ch = grid[i][j];
		int count = 1;
		int x = i + dirI;
		int y = j + dirJ;
		while (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == ch) {
			count++;
			x += dirI;
			y += dirJ;
		}
		return count;
	}
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int count = 0;
		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[0].length - 1; j++) {
				int up = directionCount(i, j, -1, 0);
				int down = directionCount(i, j, 1, 0);
				int left = directionCount(i, j, 0, -1);
				int right = directionCount(i, j, 0, 1);
				if (up == down && down == left && left == right && right >= 2) {
					count++;
				}
			}
		}
		return count; // YOUR CODE HERE
	}
}
