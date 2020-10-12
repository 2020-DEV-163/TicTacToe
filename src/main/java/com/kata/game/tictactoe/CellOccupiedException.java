package com.kata.game.tictactoe;

public class CellOccupiedException extends Exception {

	private String errorMessage;

	public CellOccupiedException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;
	}
}
