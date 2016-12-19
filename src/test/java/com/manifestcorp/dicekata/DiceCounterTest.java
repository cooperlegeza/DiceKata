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
			{5, 5, 5, 5, 1}, {3, 3, 3, 3, 3}};
	int [][] NUM_OF_DICE_ARRAYS = {{5, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 3, 2}, 
			{1, 1, 1, 1, 0, 1}, {0, 1, 1, 1, 1, 1}, 
			{2, 0, 0, 1, 0, 2}, {1, 1, 1, 1, 0, 1},
			{1, 0, 0, 0, 4, 0}, {0, 0, 5, 0, 0}};
	int DIE_FACE_ONE = 1;
	int DIE_FACE_TWO = 2;
	int DIE_FACE_THREE = 3;
	int DIE_FACE_FOUR = 4;
	int DIE_FACE_FIVE = 5;
	int DIE_FACE_SIX = 6;
	
	@Before
	public void initialize(){
		this.diceCounter = new DiceCounter();
	}
	
	@Test
	public void diceGetterTest(){
		TreeMap<Integer, Integer> dice = this.diceCounter.getDice();
		assertEquals(dice.size(), 6);
		for(int dieFace = 1; dieFace <= 6; dieFace++){
			assertTrue(dice.get(dieFace) == 0);
		}
	}
	
	@Test
	public void countDiceTestOne(){
		for(int[] dice: DICE_ARRAYS){
			diceCounter.countDice(dice);
			assertEquals(diceCounter.getDice().size(), 6);
			for(int[] numDice: NUM_OF_DICE_ARRAYS){
				for(int dieFace = 1; dieFace <= 6; dieFace++){
					assertTrue(diceCounter.getDice().get(dieFace) == numDice[dieFace - 1]);
				}
			}
		}
	}

}