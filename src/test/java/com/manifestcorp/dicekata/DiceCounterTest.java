package com.manifestcorp.dicekata;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class DiceCounterTest {
	
	DiceCounter diceCounter;
	int[][] DICE_ARRAYS = {{1, 1, 1, 1, 1}, {5, 6, 5, 6, 5}, 
			{1, 2, 3, 6, 4}, {6, 5, 4, 3, 2}, 
			
			{1, 6, 4, 6, 1}, {6, 4, 3, 1, 2},
			{5, 5, 5, 5, 1}, {3, 3, 3, 3, 3},
			
			{2, 2, 2, 4, 5}, {4, 5, 3, 4, 4},
			{3, 2, 4, 3, 3}, {2, 2, 2, 3, 2},
			
			{6, 6, 3, 2, 6}, {3, 2, 6, 6, 6},
			{1, 2, 3, 4, 5}, {1, 1, 1, 2, 2},
			
			{5, 4, 5, 4, 5}, {4, 4, 4, 4, 4},
			{1, 5, 5, 5, 1}};
	
	int [][] ARRAYS_OF_TOTALS_OF_DICE = {{5, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 3, 2}, 
			{1, 1, 1, 1, 0, 1}, {0, 1, 1, 1, 1, 1}, 
			
			{2, 0, 0, 1, 0, 2}, {1, 1, 1, 1, 0, 1},
			{1, 0, 0, 0, 4, 0}, {0, 0, 5, 0, 0, 0},
			
			{0, 3, 0, 1, 1, 0}, {0, 0, 1, 3, 1, 0},
			{0, 1, 3, 1, 0, 0}, {0, 4, 1, 0, 0, 0},
			
			{0, 1, 1, 0, 0, 3}, {0, 1, 1, 0, 0, 3},
			{1, 1, 1, 1, 1, 0}, {3, 2, 0, 0, 0, 0},
			{0, 0, 0, 2, 3, 0}, {0, 0, 0, 5, 0, 0},
			
			{2, 0, 0, 0, 3, 0}};
	
	@Before
	public void initialize(){
		this.diceCounter = new DiceCounter();
	}
	
	@Test
	public void diceGetterTest(){
		for(int dieFace = 1; dieFace <= 6; dieFace++){
			TreeMap<Integer, Integer> dice = this.diceCounter.getDice();
			assertTrue(dice.get(dieFace) == 0);
		}
	}
	
	@Test
	public void countDiceTest(){
		for(int count = 0; count < DICE_ARRAYS.length; count++){
			diceCounter.countDice(DICE_ARRAYS[count]);
			TreeMap<Integer, Integer> dice = diceCounter.getDice();
			assertEquals(dice.size(), 6);
			for(int dieFace = 1; dieFace <= 6; dieFace++){
				assertTrue(dice.get(dieFace) == ARRAYS_OF_TOTALS_OF_DICE[count][dieFace - 1]);
			}
		}
	}

}
