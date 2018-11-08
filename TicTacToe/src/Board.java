public class Board {

	private int _size;
	private int[][] _theCells;

	public Board(int size) {
		_theCells = new int[size][size];

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {

				_theCells[i][j] = 0;
			}
		}

	}

	public int getSize() {
		return _size;
	}

	public boolean isEmpty(int x, int y) {

		if (_theCells[x][y] == 0) {
			return true;
		}

		return false;
	}

	public void setCellValue(int x, int y, int player) {

		_theCells[x][y] = player;
	}

	public int getCellContent(int row, int column) {

		return _theCells[row][column];
	}

}
