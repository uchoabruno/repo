package com.bctc.kalah.model;

import com.bctc.kalah.model.impl.Player;

public interface House {

	Player getOwner();

	boolean addStones(Player player, int stones);

	int getQtyStones();
}
