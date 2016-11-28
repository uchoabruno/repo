package com.bctc.kalah.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bctc.kalah.model.impl.Board;
import com.bctc.kalah.model.impl.Pit;
import com.bctc.kalah.model.impl.Player;

public class BoardServiceTest {

	private BoardService service = new BoardService();
	private Board board;

	@Before
	public void setUp() {
		board = new Board(4);
	}

	@Test
	public void testPlayerAMovingStonesFromPit0_true() {
		assertTrue(service.playerCanMoveStonesFromPit(board.getHouses()[0], board.getPlayerA()));
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testPlayerAMovingStonesFromPit7_false() {
		assertFalse(service.playerCanMoveStonesFromPit(board.getHouses()[7], board.getPlayerA()));
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testPlayerBMovingStonesFromPit3_false() {
		assertFalse(service.playerCanMoveStonesFromPit(board.getHouses()[3], board.getPlayerB()));
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testPlayerBMovingStonesFromPit9_true() {
		assertTrue(service.playerCanMoveStonesFromPit(board.getHouses()[9], board.getPlayerB()));
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testIfAnEmptyPitIsAvailable() {
		((Pit) board.getHouses()[0]).getAllStones();
		assertFalse(service.pitHasStonesAvailable(board.getHouses()[0]));
	}

	@Test
	public void testIfANotEmptyPitIsAvailable() {
		assertTrue(service.pitHasStonesAvailable(board.getHouses()[0]));
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testPlayerAHasAvailableMoves() {
		assertTrue(service.playerHasAvailableMoves(board));
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testPlayerAHasntAvailableMoves() {
		((Pit) board.getHouses()[0]).getAllStones();
		((Pit) board.getHouses()[1]).getAllStones();
		((Pit) board.getHouses()[2]).getAllStones();
		((Pit) board.getHouses()[3]).getAllStones();
		((Pit) board.getHouses()[4]).getAllStones();
		((Pit) board.getHouses()[5]).getAllStones();
		assertFalse(service.playerHasAvailableMoves(board));
	}

	@Test
	public void testPlayerBHasAvailableMoves() {
		board.setCurrentPlayer(board.getPlayerB());
		assertTrue(service.playerHasAvailableMoves(board));
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testPlayerBHasntAvailableMoves() {
		((Pit) board.getHouses()[7]).getAllStones();
		((Pit) board.getHouses()[8]).getAllStones();
		((Pit) board.getHouses()[9]).getAllStones();
		((Pit) board.getHouses()[10]).getAllStones();
		((Pit) board.getHouses()[11]).getAllStones();
		((Pit) board.getHouses()[12]).getAllStones();
		board.setCurrentPlayer(board.getPlayerB());
		assertFalse(service.playerHasAvailableMoves(board));
	}

	@Test
	public void testMovePlayerBLastPitWIthALotOfStones() {
		board.setCurrentPlayer(board.getPlayerB());
		board.getHouses()[12].addStones(board.getCurrentPlayer(), 10);
		service.moveStonesFromSelectedPitAndReturnNextPlayer(board, 12);
		assertEquals("B", board.getCurrentPlayer().getName());
		assertEquals(58, service.getTotalBoardStones(board));
	}
	
	@Test
	public void testMoveWherePlayerAEndsMoveOnItsKalahAndKeepsPlaying() {
		service.moveStonesFromSelectedPitAndReturnNextPlayer(board, 2);
		assertEquals("A", board.getCurrentPlayer().getName());
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testMoveWherePlayerAEndsMoveOnANotEmptyPitPlayerBWillBeNext() {
		service.moveStonesFromSelectedPitAndReturnNextPlayer(board, 0);
		assertEquals("B", board.getCurrentPlayer().getName());
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testMoveWherePlayerBEndsMoveOnItsKalahAndKeepsPlaying() {
		service.moveStonesFromSelectedPitAndReturnNextPlayer(board, 9);
		assertEquals("B", board.getCurrentPlayer().getName());
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testMoveWherePlayerBEndsMoveOnANotEmptyPitPlayerAWillBeNext() {
		service.moveStonesFromSelectedPitAndReturnNextPlayer(board, 7);
		assertEquals("A", board.getCurrentPlayer().getName());
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testDistributeStonesFromPit2() {
		assertEquals(6, service.distributeStonesAndReturnLastIndex(board.getHouses(), 2));
		assertEquals(0, board.getHouses()[2].getQtyStones());
		assertEquals(5, board.getHouses()[3].getQtyStones());
		assertEquals(5, board.getHouses()[4].getQtyStones());
		assertEquals(5, board.getHouses()[5].getQtyStones());
		assertEquals(1, board.getHouses()[6].getQtyStones());
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testDistributeStonesFromPit5() {
		assertEquals(9, service.distributeStonesAndReturnLastIndex(board.getHouses(), 5));
		assertEquals(0, board.getHouses()[5].getQtyStones());
		assertEquals(1, board.getHouses()[6].getQtyStones());
		assertEquals(5, board.getHouses()[7].getQtyStones());
		assertEquals(5, board.getHouses()[8].getQtyStones());
		assertEquals(5, board.getHouses()[9].getQtyStones());
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testDistributeStonesFromPit9() {
		assertEquals(13, service.distributeStonesAndReturnLastIndex(board.getHouses(), 9));
		assertEquals(0, board.getHouses()[9].getQtyStones());
		assertEquals(5, board.getHouses()[10].getQtyStones());
		assertEquals(5, board.getHouses()[11].getQtyStones());
		assertEquals(5, board.getHouses()[12].getQtyStones());
		assertEquals(1, board.getHouses()[13].getQtyStones());
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testDistributeStonesFromPit12() {
		assertEquals(2, service.distributeStonesAndReturnLastIndex(board.getHouses(), 12));
		assertEquals(0, board.getHouses()[12].getQtyStones());
		assertEquals(1, board.getHouses()[13].getQtyStones());
		assertEquals(5, board.getHouses()[0].getQtyStones());
		assertEquals(5, board.getHouses()[1].getQtyStones());
		assertEquals(5, board.getHouses()[2].getQtyStones());
		assertEquals(48, service.getTotalBoardStones(board));
	}

	@Test
	public void testLastMoveEndsInEmptyPit5() {
		Pit lastPit = (Pit) board.getHouses()[5];
		lastPit.getAllStones();
		lastPit.addStones(lastPit.getOwner(), 1);

		service.playerMoveFinishesOnOneOfItsEmptyPits(lastPit.getOwner(), 5, board.getHouses());
		assertEquals(0, board.getHouses()[5].getQtyStones());
		assertEquals(0, board.getHouses()[7].getQtyStones());
		assertEquals(5, board.getHouses()[6].getQtyStones());
	}

	@Test
	public void testLastMoveEndsInEmptyPit5ButNotOneOfPlayersPit() {
		Pit lastPit = (Pit) board.getHouses()[5];
		Player player = ((Pit) board.getHouses()[12]).getOwner();
		lastPit.getAllStones();
		lastPit.addStones(player, 1);

		service.playerMoveFinishesOnOneOfItsEmptyPits(player, 5, board.getHouses());
		assertEquals(1, board.getHouses()[5].getQtyStones());
		assertEquals(4, board.getHouses()[7].getQtyStones());
		assertEquals(0, board.getHouses()[6].getQtyStones());
	}

	@Test
	public void testLastMoveEndsInEmptyPit12() {
		Pit lastPit = (Pit) board.getHouses()[12];
		lastPit.getAllStones();
		lastPit.addStones(lastPit.getOwner(), 1);

		service.playerMoveFinishesOnOneOfItsEmptyPits(lastPit.getOwner(), 12, board.getHouses());
		assertEquals(0, board.getHouses()[12].getQtyStones());
		assertEquals(0, board.getHouses()[0].getQtyStones());
		assertEquals(5, board.getHouses()[13].getQtyStones());
	}

	@Test
	public void testGetAvailabilityMessageNewGame() {
		assertNull(service.getAvailabilityMessage(board));
	}

	@Test
	public void testGetAvailabilityMessageGameOverPlayerA() {
		((Pit)board.getHouses()[0]).getAllStones();
		((Pit)board.getHouses()[1]).getAllStones();
		((Pit)board.getHouses()[2]).getAllStones();
		((Pit)board.getHouses()[3]).getAllStones();
		((Pit)board.getHouses()[4]).getAllStones();
		((Pit)board.getHouses()[5]).getAllStones();
		assertNotNull(service.getAvailabilityMessage(board));
	}
	
	@Test
	public void testGetAvailabilityMessageGameOverPlayerB() {
		((Pit)board.getHouses()[7]).getAllStones();
		((Pit)board.getHouses()[8]).getAllStones();
		((Pit)board.getHouses()[9]).getAllStones();
		((Pit)board.getHouses()[10]).getAllStones();
		((Pit)board.getHouses()[11]).getAllStones();
		((Pit)board.getHouses()[12]).getAllStones();
		board.setCurrentPlayer(board.getPlayerB());
		assertNotNull(service.getAvailabilityMessage(board));
	}

	@Test
	public void testDefaultWinnerMessage() {
		assertNotNull(service.getWinnerMessage(board));
	}

	@Test
	public void testWinnerMessagePlayerB() {
		board.setCurrentPlayer(board.getPlayerB());
		assertNotNull(service.getWinnerMessage(board));
	}
}