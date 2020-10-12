package com.kata.game.tictactoe.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kata.tictactoe.CellOccupiedException;
import com.kata.tictactoe.InvalidCellRangeException;
import com.kata.tictactoe.PlayTicTacToe;

public class PlayTicTacToeTest {

	@Test
	public void playTicTacToeInstanceShouldNotBeNull() {

		PlayTicTacToe playTicTacToe = new PlayTicTacToe();
		assertNotNull(playTicTacToe);
	}

}