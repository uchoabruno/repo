package com.bctc.kalah.service;

import org.springframework.stereotype.Service;

import com.bctc.kalah.model.House;
import com.bctc.kalah.model.impl.Board;
import com.bctc.kalah.model.impl.Pit;
import com.bctc.kalah.model.impl.Player;

@Service
public class BoardService {

	public boolean playerCanMoveStonesFromPit(House house, Player player) {
		return house.getOwner().equals(player);
	}

	public boolean pitHasStonesAvailable(House house) {
		return house.getQtyStones() > 0;
	}

	public boolean playerHasAvailableMoves(Board board) {
		boolean hasAvailableMoves = false;
		if (board.getCurrentPlayer().equals(board.getPlayerA())) {
			for (int i = 0; i < 6; i++) {
				hasAvailableMoves = hasAvailableMoves || board.getHouses()[i].getQtyStones() > 0;
			}
		}
		if (board.getCurrentPlayer().equals(board.getPlayerB())) {
			for (int i = 7; i < 13; i++) {
				hasAvailableMoves = hasAvailableMoves || board.getHouses()[i].getQtyStones() > 0;
			}
		}
		return hasAvailableMoves;
	}

	public String getAvailabilityMessage(Board board) {
		if (!playerHasAvailableMoves(board)) {
			return String.format("Game Over! Player %s doesn't have any available moves.", board.getCurrentPlayer().getName());
		}
		return null;
	}

	public String getWinnerMessage(Board board) {
		int remainingStones = 0;
		//if (board.getCurrentPlayer().equals(board.getPlayerA())) {
			for (int i = 0; i < 6; i++) {
				remainingStones += ((Pit) board.getHouses()[i]).getAllStones();
			}
			board.getHouses()[6].addStones(board.getPlayerA(), remainingStones);
			//houses[6].addStones(player, stonesToBeAdded);
//		}
		remainingStones = 0;
//		if (board.getCurrentPlayer().equals(board.getPlayerB())) {
			for (int i = 7; i < 13; i++) {
				remainingStones += ((Pit) board.getHouses()[i]).getAllStones();
			}
			board.getHouses()[13].addStones(board.getPlayerB(), remainingStones);
//		}

		if (board.getHouses()[6].getQtyStones() > board.getHouses()[13].getQtyStones()) {
			return String.format("Contgratulations player %s. You've won!", board.getPlayerA().getName()); 
		}
		if (board.getHouses()[6].getQtyStones() < board.getHouses()[13].getQtyStones()) {
			return String.format("Contgratulations player %s. You've won!", board.getPlayerB().getName()); 
		}

		return "We have a draw!";
	}

	public void moveStonesFromSelectedPitAndReturnNextPlayer(Board board, int index) {
		Player pitOwner = board.getHouses()[index].getOwner();
		int lastIndex = distributeStonesAndReturnLastIndex(board.getHouses(), index);
		playerMoveFinishesOnOneOfItsEmptyPits(pitOwner, lastIndex, board.getHouses());
		if (lastIndex == 6 && pitOwner.equals(board.getPlayerA())) {
			board.setCurrentPlayer(board.getPlayerA());
			return;
		} else if (lastIndex == 13 && pitOwner.equals(board.getPlayerB())) {
			board.setCurrentPlayer(board.getPlayerB());
			return;
		}

		if (pitOwner.equals(board.getPlayerA())) {
			board.setCurrentPlayer(board.getPlayerB());
			return;
		}
		board.setCurrentPlayer(board.getPlayerA());
	}
	
	public int distributeStonesAndReturnLastIndex(House[] houses, int selectedPitIndex) {
		Pit selectedPit = (Pit) houses[selectedPitIndex];
		Player player = selectedPit.getOwner();
		int nextIndex = ++selectedPitIndex;
		int stonesToBeDistributed = selectedPit.getAllStones();

		while(stonesToBeDistributed > 0) {
			if (houses[nextIndex].addStones(player, 1)) {
				stonesToBeDistributed--;
			}
			nextIndex++;
			if (nextIndex == 14) {
				nextIndex = 0;
			}
		}
		int lastIndex = --nextIndex;
		if (lastIndex < 0) {
			return 13;
		}
		return lastIndex;
	}

	public void playerMoveFinishesOnOneOfItsEmptyPits(Player player, int lastIndex, House[] houses) {
		House selectedHouse = houses[lastIndex];
		if (selectedHouse instanceof Pit && selectedHouse.getQtyStones() == 1 && player.equals(selectedHouse.getOwner())) {
			int stonesToBeAdded = 0;
			int opposingIndex = 12-lastIndex;
			stonesToBeAdded += ((Pit) houses[lastIndex]).getAllStones();
			stonesToBeAdded += ((Pit) houses[opposingIndex]).getAllStones();
			if (lastIndex < 6) {
				houses[6].addStones(player, stonesToBeAdded);
			}
			if (lastIndex > 6) {
				houses[13].addStones(player, stonesToBeAdded);
			}
		}
	}

	public int getTotalBoardStones(Board board) {
		int totalBoardStones = 0;
		for (House house : board.getHouses()) {
			totalBoardStones += house.getQtyStones();
		}
		return totalBoardStones;
	}
}