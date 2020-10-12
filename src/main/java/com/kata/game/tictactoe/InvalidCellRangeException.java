package com.kata.game.tictactoe;

public class InvalidCellRangeException extends Exception{

	private String errorMessage;

	public InvalidCellRangeException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;

	}
}
