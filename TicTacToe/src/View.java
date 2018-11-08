import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {

	private Controller _controller;
	private int _sizeOfBoard;
	private JButton[][] buttons;
	private JPanel myButtonPanel;
	private JFrame frame;
	private JLabel myLabel;
	private JPanel myTextPanel;
	private JPanel myMainPanel;

	public View(int numberOfViews, int sizeOfBoard, Controller controller) {

		_sizeOfBoard = sizeOfBoard;
		_controller = controller;
		frame = new JFrame("TicTacToe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myButtonPanel = new JPanel();
		myButtonPanel.setLayout(new GridLayout(_sizeOfBoard, _sizeOfBoard));

		buttons = new JButton[_sizeOfBoard][_sizeOfBoard];

		myTextPanel = new JPanel();
		myTextPanel.setLayout(new GridLayout(1, 1));
		myTextPanel.setPreferredSize(new Dimension(150, 50));

		myLabel = new JLabel("its X's turn", SwingConstants.CENTER);
		myTextPanel.add(myLabel);

		myMainPanel = new JPanel();
		myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
		myMainPanel.add(myButtonPanel);
		myMainPanel.add(myTextPanel);

		for (int r = 0; r < _sizeOfBoard; r++) {
			for (int c = 0; c < _sizeOfBoard; c++) {
				final int _r = r;
				final int _c = c;
				JButton button = buttons[r][c] = new JButton();
				button.setPreferredSize(new Dimension(50, 50));
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						_controller.unitClicked(_r, _c);

					}
				});

				myButtonPanel.add(button);

			}

			myMainPanel = new JPanel();
			myMainPanel.add(myButtonPanel);
			myMainPanel.add(myTextPanel);
		}

		frame.getContentPane().add(myMainPanel);
		frame.pack();
		frame.setVisible(true);
	}

	public void updateBoard(int row, int column, String currentPlayer) {

		buttons[row][column].setText(currentPlayer);

		frame.pack();
		frame.setVisible(true);

	}

	public void printNextPlayer(String nextPlayer) {

		myLabel.setText("its " + nextPlayer + "'s turn");
	}

	public void printWinner(String winner) {

		myLabel.setText(winner + " won the game");
	}

}
