package com.kata.game.tictactoe;

import java.util.Scanner;
import java.util.logging.Logger;

import com.kata.game.tictactoe.CellOccupiedException;
import com.kata.game.tictactoe.InvalidCellRangeException;

public class PlayTicTacToe {

	private final static Logger LOGGER = Logger.getLogger(PlayTicTacToe.class.getName());

	public static void main(String[] args) throws CellOccupiedException, InvalidCellRangeException {
		PlayTicTacToe playTicTacToe = new PlayTicTacToe();
		playTicTacToe.playGame();

	}

	public void playGame() throws CellOccupiedException, InvalidCellRangeException {

		displayInstructions();
		getInputfromPlayer();

	}

	public void getInputfromPlayer() throws CellOccupiedException, InvalidCellRangeException {
		try(Scanner scan = new Scanner(System.in)){
			Game game = new Game();
			do {
				game.gameBoard.printBoard();
				int row;
				int col;
				LOGGER.info(
						"Enter row and column separated with space:: Player " + game.gameBoard.getNextSymbol() + ", to set your mark on game board!");
				row = scan.nextInt();
				col = scan.nextInt();
				game.play(row, col);
				game.gameBoard.getNextSymbol();
			} while (!game.isWinner() && !game.gameBoard.isCellsFullyOccupiedBySymbols());

			determineGameState(game);
		}

	}

	private void determineGameState(Game game) {
		if (game.gameBoard.isCellsFullyOccupiedBySymbols() && !game.isWinner()) {
			LOGGER.info("The game was a tie!");
		} else {
			LOGGER.info("Current board layout:");
			game.gameBoard.printBoard();
			game.gameBoard.getNextSymbol();
			LOGGER.info(Character.toUpperCase(game.gameBoard.getCurrentSymbol()) + " Wins!");
		}
	}

	public void displayInstructions() {

		StringBuilder builder = new StringBuilder();

		builder.append("Welcome to Tic Tac Toe! \n");
		builder.append("Below are the rules for playing this game! \n");

		builder.append("X always goes first. \n");
		builder.append("Players cannot play on a played position\n");
		builder.append("Players alternate placing X's and O's on the board until either: \n");
		builder.append("One player has three in a row, horizontally, vertically or diagonally \n");
		builder.append("All nine squares are filled. \n");
		builder.append("If a player is able to draw three X's or three O's in a row, that player wins.\n");
		builder.append("If all nine squares are filled and neither player has three in a row, the game is a draw.\n");

		builder.append("Pass your inputs in commanline arguments in row and column fashion \n");
		builder.append(
				"Your inputs are in the format of row , press enter and then enter column value for which the symbol to be placed in the game board");

		LOGGER.info("Rules \n" + builder.toString());
	}




}
