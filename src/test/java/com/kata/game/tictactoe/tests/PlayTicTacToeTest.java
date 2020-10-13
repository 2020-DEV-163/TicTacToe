package com.kata.game.tictactoe.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kata.game.tictactoe.CellOccupiedException;
import com.kata.game.tictactoe.InvalidCellRangeException;
import com.kata.game.tictactoe.PlayTicTacToe;



public class PlayTicTacToeTest {

	@Test
	public void playTicTacToeInstanceShouldNotBeNull() {

		PlayTicTacToe playTicTacToe = new PlayTicTacToe();
		assertNotNull(playTicTacToe);
	}
	
	@Test
	public void shouldBeAbleToDisplayInstructions() throws CellOccupiedException, InvalidCellRangeException {
		
		PlayTicTacToe playTicTacToe = new PlayTicTacToe();
		playTicTacToe.displayInstructions();
	}
	
	

}
