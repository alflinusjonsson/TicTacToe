public class RuleEngine {

	private Board _theBoard;
	private int _players, _rowToWin;
	private int _currentPlayer;
	private int _size;

	public RuleEngine(int players, int sizeOfBoard, int rowToWin) {
		_players = players;
		_rowToWin = rowToWin;
		_theBoard = new Board(sizeOfBoard);
		_currentPlayer = 1;
		_size = sizeOfBoard;
	}

	public boolean checkRows(int player) {
		int numFound = 0;

		for (int y = 0; y < _size; y++) {

			numFound = 0;

			for (int x = 0; x < _size; x++) {
				if (_theBoard.getCellContent(x, y) == player) {
					numFound++;
				}
				else
					numFound = 0;
				

				if (numFound == _rowToWin)
					return true;
			}
		}

		return false;
	}

	public boolean checkColums(int player) {
		int numFound = 0;

		for (int x = 0; x < _size; x++) {

			numFound = 0;

			for (int y = 0; y < _size; y++) {
				if (_theBoard.getCellContent(x, y) == player)
					numFound++;
				else
					numFound = 0;

				if (numFound == _rowToWin)
					return true;
			}
		}

		return false;
	}

	public boolean checkRightDiag(int player) {
		int numFound = 0;

		for (int x_y = 0; x_y < _size; x_y++) {
			if (_theBoard.getCellContent(x_y, x_y) == player)
				numFound++;
			else
				numFound = 0;

			if (numFound == _rowToWin)
				return true;
		}

		return false;
	}

	public boolean checkLeftDiag(int player) {
		int numFound = 0;
		int y = 0;

		for (int x = 0; x < _size; x++) {
			y = (_size-1) - x;
			if (_theBoard.getCellContent(x, y) == player) 
				numFound++;
			else
				numFound = 0;

			if (numFound == _rowToWin)
				return true;
		}

		return false;
	}

	public boolean moveRequest(int x, int y) {
		if (_theBoard.isEmpty(x, y)) {
			return true;
		}
		return false;
	}

	public boolean checkWinner(int player) {

		if (checkLeftDiag(player) || checkRightDiag(player) || checkRows(player) || checkColums(player))
			return true;

		return false;
	}

	public void makeMove(int row, int colum) {
		_theBoard.setCellValue(row, colum, _currentPlayer);
	}

	public void nextPlayer() {
		_currentPlayer++;
		if (_currentPlayer == _players + 1) {
			_currentPlayer = 1;
		}
	}

	public int getPlayerId() {
		return _currentPlayer;
	}

	public String getCurrentPlayer() {

		int player = (_currentPlayer);

		switch (player) {

		case 1:
			return "X";
		case 2:
			return "O";
		case 3:
			return "A";
		default:
			return "none";
		}
	}

}
