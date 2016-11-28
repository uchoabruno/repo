package com.bctc.kalah.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bctc.kalah.model.impl.Pit;
import com.bctc.kalah.model.impl.Player;

public class PitTest {
	
	private Pit pit;
	private Player playerA;
	
	@Before
	public void setUp() {
		playerA = new Player("A");
		pit = new Pit.PitBuilder(playerA, 4).build();
	}

	@Test
	public void testAdd0Stone() {
		pit.addStones(playerA, 0);
		assertEquals(4, pit.getQtyStones());
	}

	@Test
	public void testAdd1Stone() {
		pit.addStones(playerA, 1);
		assertEquals(5, pit.getQtyStones());
	}
	
	@Test
	public void testAdd99Stone() {
		pit.addStones(playerA, 99);
		assertEquals(103, pit.getQtyStones());
	}

	@Test
	public void testGetAllStones() {
		assertEquals(4, pit.getAllStones());
	}

	@Test
	public void testGetAllStonesAfterAdding3Stones() {
		pit.addStones(playerA, 3);
		assertEquals(7, pit.getAllStones());
	}
	
}
