package com.bctc.kalah.model.impl;

import com.bctc.kalah.model.House;

public class Board {
	
	private House[] houses = new House[14];
	private Player playerA = new Player("A");
	private Player playerB = new Player("B");
	private Player currentPlayer;

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Player getPlayerA() {
		return playerA;
	}
	
	public Player getPlayerB() {
		return playerB;
	}
	
	public Board(int initialStones) {
		currentPlayer = getPlayerA();
		houses[0] = new Pit.PitBuilder(playerA, initialStones).build();
		houses[1] = new Pit.PitBuilder(playerA, initialStones).build();
		houses[2] = new Pit.PitBuilder(playerA, initialStones).build();
		houses[3] = new Pit.PitBuilder(playerA, initialStones).build();
		houses[4] = new Pit.PitBuilder(playerA, initialStones).build();
		houses[5] = new Pit.PitBuilder(playerA, initialStones).build();
		houses[6] = new Kalah.KalahBuilder(playerA, 0).build(); //Player's A Kalah
		houses[7] = new Pit.PitBuilder(playerB, initialStones).build();
		houses[8] = new Pit.PitBuilder(playerB, initialStones).build();
		houses[9] = new Pit.PitBuilder(playerB, initialStones).build();
		houses[10] = new Pit.PitBuilder(playerB, initialStones).build();
		houses[11] = new Pit.PitBuilder(playerB, initialStones).build();
		houses[12] = new Pit.PitBuilder(playerB, initialStones).build();
		houses[13] = new Kalah.KalahBuilder(playerB, 0).build(); //Player's B Kalah
	}

	public House[] getHouses() {
		return houses;
	}

	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}
}