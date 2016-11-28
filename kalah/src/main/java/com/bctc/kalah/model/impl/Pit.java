package com.bctc.kalah.model.impl;

import com.bctc.kalah.model.House;

public class Pit implements House {

	private int qtyStones;
	private Player owner;
	
	public int getQtyStones() {
		return qtyStones;
	}

	public Player getOwner() {
		return owner;
	}
	
	public boolean addStones(Player player, int stones) {
		this.qtyStones += stones;
		return true;
	}
	
	public int getAllStones() {
		int stones = qtyStones;
		qtyStones = 0;
		return stones;
	}
	
	public String toString() {
		return String.format("This Pit has %s stones.", this.getQtyStones()); 
	}

	private Pit(PitBuilder builder) {
		this.owner = builder.nestedOwner;
		this.qtyStones = builder.nestedQtyStones;
	}

	public static class PitBuilder {
		private int nestedQtyStones;
		private Player nestedOwner;
		
		public PitBuilder(Player nestedOwner, int nestedQtyStones) {
			this.nestedOwner = nestedOwner;
			this.nestedQtyStones = nestedQtyStones;
		}

		public Pit build() {
			return new Pit(this);
		}
	}
}