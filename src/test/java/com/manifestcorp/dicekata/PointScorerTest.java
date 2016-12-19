package com.manifestcorp.dicekata;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class PointScorerTest {
	
	PointScorer scorer;
	DiceCounter counter;
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
	int[] SCORES_OF_DICE_ARRAYS = {1200, 500, 140, 40, 240, 140, 600,
			300, 240, 400, 340, 200, 600, 600, 140, 1000, 580, 
			480, 700};
	int[] ONES_OR_FOURS_POINTS_OF_ARRAYS = {1200, 0, 140, 40, 240, 140, 100,
			0, 40, 400, 40, 0, 0, 0, 140, 1000, 80, 480, 200};
	int[] NOT_ONES_OR_FOURS_POINTS_OF_ARRAYS = {0, 500, 0, 0, 0, 0, 500,
			300, 200, 0, 300, 200, 600, 600, 0, 0, 500, 0, 500};
			
	@Before
	public void initialize(){
		this.scorer = new PointScorer();
		this.counter = new DiceCounter();
	}

	
	@Test
	public void pointsTest() {
		int points;
		TreeMap<Integer, Integer> dice;
		for(int count = 0; count < DICE_ARRAYS.length; count++){
			this.counter.countDice(DICE_ARRAYS[count]);
			dice = this.counter.getDice();
			points = this.scorer.score(dice);
			assertEquals(SCORES_OF_DICE_ARRAYS[count], points);
		}
	}
	
	@Test
	public void scoreOnesOrFoursTest(){
		for(int onesOrFoursCount = 0; onesOrFoursCount < DICE_ARRAYS.length; onesOrFoursCount++){
			this.counter.countDice(DICE_ARRAYS[onesOrFoursCount]);
			TreeMap<Integer, Integer> onesOrFoursDice = this.counter.getDice();
			int actualScore = scorer.scoreOnesOrFours(onesOrFoursDice);
			int expectedScore = ONES_OR_FOURS_POINTS_OF_ARRAYS[onesOrFoursCount];
			assertEquals(expectedScore, actualScore);
		}
	}
	
	@Test
	public void scoreOnesOrFoursLogicTest(){
		int dieFace = 0;
		int numberOfDice = 1;
		int[][] dieFaceAndNumberOfDice = {{1, 5}, {4, 5}, {1, 4}, {4, 4},
		{1, 3}, {4, 3}, {1, 2}, {4, 2}, {1, 1}, {4, 1}, {1, 0}, {4, 0}};
		
		int[] points = {1200, 480, 1100, 440, 1000, 400, 200, 80,
				100, 40, 0, 0};
		
		for(int count = 0; count < dieFaceAndNumberOfDice.length; count++){
			int[] numbers = dieFaceAndNumberOfDice[count];
			int actualScore = this.scorer.scoreOnesOrFoursPointsLogic(numbers[dieFace], 
					numbers[numberOfDice]);
			int expectedScore = points[count];
			assertEquals(expectedScore, actualScore);
		}
	}
	
	@Test
	public void scoreNotOnesOrFoursTest(){
		for(int notOnesOrFoursCount = 0; notOnesOrFoursCount < DICE_ARRAYS.length; notOnesOrFoursCount++){
			this.counter.countDice(DICE_ARRAYS[notOnesOrFoursCount]);
			TreeMap<Integer, Integer> notOnesOrFoursDice = this.counter.getDice();
			int actualScore = scorer.scoreNotOnesOrFours(notOnesOrFoursDice);
			int expectedScore = NOT_ONES_OR_FOURS_POINTS_OF_ARRAYS[notOnesOrFoursCount];
			assertTrue(actualScore == expectedScore);
		}
	}

}
