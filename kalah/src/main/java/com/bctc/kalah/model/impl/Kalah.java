package com.bctc.kalah.model.impl;

import com.bctc.kalah.model.House;

public class Kalah implements House {

	private int qtyStones;
	private Player owner;

	public Player getOwner() {
		return owner;
	}

	public boolean addStones(Player player, int stones) {
		if (player.equals(owner)) {
			this.qtyStones += stones;
			return true;
		}
		return false;
	}

	public int getQtyStones() {
		return qtyStones;
	}
	
	public String toString() {
		return String.format("This Kalah has %s stones.", this.getQtyStones()); 
	}

	private Kalah(KalahBuilder builder) {
		this.owner = builder.nestedOwner;
		this.qtyStones = builder.nestedQtyStones;
	}

	public static class KalahBuilder {
		private int nestedQtyStones;
		private Player nestedOwner;

		public KalahBuilder(Player nestedOwner, int nestedQtyStones) {
			this.nestedOwner = nestedOwner;
			this.nestedQtyStones = nestedQtyStones;
		}

		public Kalah build() {
			return new Kalah(this);
		}
	}
}