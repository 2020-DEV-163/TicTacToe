package com.kata.game.tictactoe.tests;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.kata.game.tictactoe.GameBoard;

public class GameBoardTest {

	private static final int THREE = 3;
	private static final char SYMBOL_O = 'O';
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final char SYMBOL_X = 'X';
	private static final int ZERO = 0;

	private GameBoard gameBoard;

	@Before
	public void init() {
		gameBoard = new GameBoard();
	}

	@Test
	public void playerOneShouldBeAbleToPlaceXInAnyCell() {

		gameBoard.drawSymbolAt(ZERO, ZERO);

		assertThat(gameBoard.getSymbolAt(ZERO, ZERO), CoreMatchers.is(SYMBOL_X));
	}

	@Test
	public void symbolsShouldGetChangeAlternatively() {

		gameBoard.drawSymbolAt(ZERO, ZERO);

		assertThat(gameBoard.getCurrentSymbol(), CoreMatchers.is(SYMBOL_X));

		gameBoard.drawSymbolAt(ONE, ONE);

		assertThat(gameBoard.getCurrentSymbol(), CoreMatchers.is(SYMBOL_O));
	}

	@Test
	public void shouldReturnTrueWhenInputCellValuesAreInValidRange() {

		assertThat(gameBoard.isValidCellRange(ZERO, ONE), CoreMatchers.is(true));

	}
	
	@Test
	public void shouldReturnFalseWhenInputCellValuesAreNotInValidRange() {

		assertThat(gameBoard.isValidCellRange(THREE, ONE), CoreMatchers.is(false));

	}
	
	@Test
	public void shouldValidateWhetherAnyHorizontalCellValuesAreMarkedBySameSymbol() {

		gameBoard.drawSymbolAt(ZERO, ZERO);
		gameBoard.drawSymbolAt(TWO, ONE);
		gameBoard.drawSymbolAt(ZERO, ONE);
		gameBoard.drawSymbolAt(ONE, TWO);
		gameBoard.drawSymbolAt(ZERO, TWO);
		
		assertThat(gameBoard.isAnyHorizontalCellsMarkedBySameSymbol(), CoreMatchers.is(true));

	}
	
	@Test
	public void shouldValidateWhetherAnyVerticalCellsAreMarkedBySameSymbol() {

		gameBoard.drawSymbolAt(ZERO, ZERO);
		gameBoard.drawSymbolAt(TWO, TWO);
		gameBoard.drawSymbolAt(ONE, ZERO);
		gameBoard.drawSymbolAt(ONE, TWO);
		gameBoard.drawSymbolAt(TWO, ZERO);
		
		assertThat(gameBoard.isAnyVerticalCellsMarkedBySameSymbol(), CoreMatchers.is(true));

	}
	
	@Test
	public void shouldReturnTrueWhenLeftTopToRightBottomDiagonalCellsAreMarkedBySameSymbol() {

		gameBoard.drawSymbolAt(ZERO, ONE);
		gameBoard.drawSymbolAt(ZERO, ZERO);
		gameBoard.drawSymbolAt(ONE, TWO);
		gameBoard.drawSymbolAt(ONE, ONE);
		gameBoard.drawSymbolAt(TWO, ONE);
		gameBoard.drawSymbolAt(TWO, TWO);
		
		assertThat(gameBoard.isLeftTopToRightBottomDiagonalCellsAreMarkedBySameSymbol(), CoreMatchers.is(true));

	}
	
	@Test
	public void shouldReturnTrueWhenRightTopToLeftBottomDiagonalElementsAreMarkedBySameSymbol() {

		gameBoard.drawSymbolAt(ZERO, TWO);
		gameBoard.drawSymbolAt(ZERO, ZERO);
		gameBoard.drawSymbolAt(ONE, ONE);
		gameBoard.drawSymbolAt(ONE, TWO);
		gameBoard.drawSymbolAt(TWO, ZERO);
		
		assertThat(gameBoard.isRightTopToLeftBottomDiagonalCellsAreMarkedBySameSymbol(), CoreMatchers.is(true));

	}
	
	@Test
	public void shouldReturnTrueWhenAllTheCellsAreMarkedInABoard() {
		
		gameBoard.drawSymbolAt(ONE, ONE);
		gameBoard.drawSymbolAt(ZERO, TWO);
		gameBoard.drawSymbolAt(ONE, TWO);
		gameBoard.drawSymbolAt(ONE, ZERO);
		gameBoard.drawSymbolAt(ZERO, ZERO);
		gameBoard.drawSymbolAt(TWO, TWO);
		gameBoard.drawSymbolAt(TWO, ONE);
		gameBoard.drawSymbolAt(ZERO, ONE);
		gameBoard.drawSymbolAt(TWO, ZERO);
		
		assertThat(gameBoard.isCellsFullyOccupiedBySymbols(), CoreMatchers.is(true));
	}
	
	@Test
	public void shouldBeAbleToPrintTheGameBoardAfterPlayerMoves(){
		
		gameBoard.drawSymbolAt(ONE, ONE);
		gameBoard.drawSymbolAt(ZERO, TWO);
		gameBoard.drawSymbolAt(ONE, TWO);
		
		gameBoard.printBoard();
	}
}
