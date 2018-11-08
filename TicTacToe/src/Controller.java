public class Controller {

	private View[] _views;
	private RuleEngine _ruleengine;
	private static boolean _gameover = false;
	private int _numberOfViews;

	public Controller(int views, int numPlayers, int sizeOfBoard, int rowToWin) {
		
		_numberOfViews = views;
		_views = new View[views];
		for (int i = 0; i < views; i++) {
			_views[i] = new View(views, sizeOfBoard, this);
		}

		_ruleengine = new RuleEngine(numPlayers, sizeOfBoard, rowToWin);
	}

	public void unitClicked(int _r, int _c) {

		if (_ruleengine.moveRequest(_r, _c)) {

			_ruleengine.makeMove(_r, _c);
			for (int i = 0; i < _numberOfViews; i++) {
				_views[i].updateBoard(_r, _c, _ruleengine.getCurrentPlayer());

			}
			
			if (_ruleengine.checkWinner(_ruleengine.getPlayerId())) {
				for (int i = 0; i < _numberOfViews; i++) {
					_views[i].printWinner(_ruleengine.getCurrentPlayer());

				}
				_gameover = true;
				return;

			}

			_ruleengine.nextPlayer();
			for (int i = 0; i < _numberOfViews; i++) {
				_views[i].printNextPlayer(_ruleengine.getCurrentPlayer());

			}
			

		}
	}

}
