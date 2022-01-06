import java.awt.Point;

/**
 * CS 121 Project 5
 * 
 * This project class uses arrays and logic to create the methods for a tic tac toe game.
 * 
 * @author Gavin Wale
 */

public class TicTacToeGame implements TicTacToe {
	private final int MAX_MOVES = 9; //maximum moves in a tictactoe game
	private int count; //keeps track of number of moves
	private Point[] moves; //array of moves
	private BoardChoice[][] boardChoices; // New 2D array of Board Choices
	private GameState state; 
	private BoardChoice lastPlayer;
	

	/**
	 * Constructor for a TicTacToeGame, calls newGame()
	 * 
	 * @return a new TicTacToeGame (calls newGame())
	 */
	public TicTacToeGame() {
		newGame();
	}

	/**
	 * Creates a new game with a 2D array of board choices
	 * 
	 * @return new TicTacToeGame
	 */
	public void newGame() {

		lastPlayer = null; // instantiate lastPlayer
		boardChoices = new BoardChoice[3][3]; // New instance with dimensions
		count = 0; // move count is zero
		moves = new Point[MAX_MOVES]; // need to keep track of the moves made

		for (int i = 0; i < boardChoices.length; i++) { // Iterate through rows
			for (int j = 0; j < boardChoices[i].length; j++) { // Iterate through columns
				boardChoices[i][j] = BoardChoice.OPEN; // Set each box to OPEN
			}
		}
		
		state = GameState.IN_PROGRESS; // Gamestate is in progress

	}

	
	/**
	 * Decides if a player's choice in the game is valid
	 * 
	 * @param TicTacToe.BoardChoice player
	 * @param int row
	 * @param int col
	 * 
	 * @return boolean
	 */
	public boolean choose(TicTacToe.BoardChoice player, int row, int col) {
		
		if (lastPlayer == null) {
			if (player == BoardChoice.X) {
				lastPlayer = BoardChoice.O;
			} else {
				lastPlayer = BoardChoice.X;
			}
		}

		if (gameOver()) {
			return false;
		} else if (!player.equals(BoardChoice.X) && !player.equals(BoardChoice.O)) {
			return false;
		} else if ((row >= boardChoices.length || row < 0) || (col >= boardChoices.length || col < 0)) {
			return false;
		} else if (!(boardChoices[row][col] == BoardChoice.OPEN)) {
			return false;
		} else if (player.equals(lastPlayer)) {
			return false;
		}
		
		boardChoices[row][col] = player;
		lastPlayer = player;
		moves[count] = new Point(row, col);
		count++;
		return true;

	}
	
	/**
	 * Checks if the game is over
	 * 
	 * @return boolean
	 */
	public boolean gameOver() { // how to get tie into if else

		if (boardChoices[0][0].equals(boardChoices[0][1]) && boardChoices[0][0].equals(boardChoices[0][2])) {
			if (!boardChoices[0][0].equals(BoardChoice.OPEN)) {
				return true;
			}
		} else if (boardChoices[1][0].equals(boardChoices[1][1]) && boardChoices[1][0].equals(boardChoices[1][2])) {
			if (!boardChoices[1][0].equals(BoardChoice.OPEN)) {
				return true;
			}
		} else if (boardChoices[2][0].equals(boardChoices[2][1]) && boardChoices[2][0].equals(boardChoices[2][2])) {
			if (!boardChoices[2][0].equals(BoardChoice.OPEN)) {
				return true;
			}
		} else if (boardChoices[0][0].equals(boardChoices[1][0]) && boardChoices[0][0].equals(boardChoices[2][0])) {
			if (!boardChoices[0][0].equals(BoardChoice.OPEN)) {
				return true;
			}
		} else if (boardChoices[0][1].equals(boardChoices[1][1]) && boardChoices[0][1].equals(boardChoices[2][1])) {
			if (!boardChoices[0][1].equals(BoardChoice.OPEN)) {
				return true;
			}
		} else if (boardChoices[0][2].equals(boardChoices[1][2]) && boardChoices[0][2].equals(boardChoices[2][2])) {
			if (!boardChoices[0][2].equals(BoardChoice.OPEN)) {
				return true;
			}
		} else if (boardChoices[0][0].equals(boardChoices[1][1]) && boardChoices[0][0].equals(boardChoices[2][2])) {
			if (!boardChoices[0][0].equals(BoardChoice.OPEN)) {
				return true;
			}
		} else if (boardChoices[2][0].equals(boardChoices[1][1]) && boardChoices[2][0].equals(boardChoices[0][2])) {
			if (!boardChoices[2][0].equals(BoardChoice.OPEN)) {
				return true;
			}
		}

		for (int i = 0; i < boardChoices.length; i++) {
			for (int j = 0; j < boardChoices[i].length; j++) {

				if (boardChoices[i][j].equals(BoardChoice.OPEN)) {
					return false;

				}
			}
		}
		return true;
	}

	/**
	 * Returns who won the game, if the game was a tie
	 * or if the game is in progress.
	 * 
	 * @return GameState
	 */
	public TicTacToe.GameState getGameState() { // DONE DONE DONE DONE DONE DONE DONE

		if (gameOver() == false) {
			state = GameState.IN_PROGRESS;
		} else {

			if (boardChoices[0][0].equals(boardChoices[0][1]) && boardChoices[0][0].equals(boardChoices[0][2])) {
				if (boardChoices[0][0].equals(BoardChoice.X)) {
					state = GameState.X_WON;
				} else {
					state = GameState.O_WON;
				}
			} else if (boardChoices[1][0].equals(boardChoices[1][1]) && boardChoices[1][0].equals(boardChoices[1][2])) {
				if (boardChoices[1][0].equals(BoardChoice.X)) {
					state = GameState.X_WON;
				} else {
					state = GameState.O_WON;
				}
			} else if (boardChoices[2][0].equals(boardChoices[2][1]) && boardChoices[2][0].equals(boardChoices[2][2])) {
				if (boardChoices[2][0].equals(BoardChoice.X)) {
					state = GameState.X_WON;
				} else {
					state = GameState.O_WON;
				}
			} else if (boardChoices[0][0].equals(boardChoices[1][0]) && boardChoices[0][0].equals(boardChoices[2][0])) {
				if (boardChoices[0][0].equals(BoardChoice.X)) {
					state = GameState.X_WON;
				} else {
					state = GameState.O_WON;
				}
			} else if (boardChoices[0][1].equals(boardChoices[1][1]) && boardChoices[0][1].equals(boardChoices[2][1])) {
				if (boardChoices[0][1].equals(BoardChoice.X)) {
					state = GameState.X_WON;
				} else {
					state = GameState.O_WON;
				}
			} else if (boardChoices[0][2].equals(boardChoices[1][2]) && boardChoices[0][2].equals(boardChoices[2][2])) {
				if (boardChoices[0][2].equals(BoardChoice.X)) {
					state = GameState.X_WON;
				} else {
					state = GameState.O_WON;
				}
			} else if (boardChoices[0][0].equals(boardChoices[1][1]) && boardChoices[0][0].equals(boardChoices[2][2])) {
				if (boardChoices[0][0].equals(BoardChoice.X)) {
					state = GameState.X_WON;
				} else {
					state = GameState.O_WON;
				}
			} else if (boardChoices[2][0].equals(boardChoices[1][1]) && boardChoices[2][0].equals(boardChoices[0][2])) {
				if (boardChoices[2][0].equals(BoardChoice.X)) {
					state = GameState.X_WON;
				} else {
					state = GameState.O_WON;
				}
			} else {
				state = GameState.TIE;
			}
		}
		return state;
	}

	/**
	 * Copies boardChoices for the changes made
	 * 
	 * @return boardChoicesCopy
	 */
	public TicTacToe.BoardChoice[][] getGameGrid() {
		TicTacToe.BoardChoice[][] boardChoicesCopy = new TicTacToe.BoardChoice[3][3];
		
		for (int i = 0; i < boardChoices.length; i++) { // Iterate through rows
			for (int j = 0; j < boardChoices[i].length; j++) { // Iterate through columns
				boardChoicesCopy[i][j] = boardChoices[i][j]; 
			}
		}
		
		return boardChoicesCopy;
	}

	/**
	 * Keeps track of moves made throughout a game
	 * 
	 * @return movesCopy
	 */
	public Point[] getMoves() {
		
		if (count == 0) {
			return new Point[MAX_MOVES];
		}
		
		Point[] movesCopy = new Point[count];
		
		for (int i = 0; i < count; i++) {
			movesCopy[i] = moves[i];
		}

		return movesCopy;
	}

}
