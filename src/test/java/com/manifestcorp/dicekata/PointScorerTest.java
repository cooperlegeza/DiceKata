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
		int[] inputDie = {1, 4};
		int[] expectedPoints = {1000, 0, 0, 400};
		int actualScore;
		
		for(int dieFace : inputDie){
			int numberOfDice = 3;
			actualScore = this.scorer.scoreOnesOrFours(dieFace, numberOfDice);
			int expectedScore = expectedPoints[dieFace - 1];
			assertEquals(expectedScore, actualScore);
		}
	}
	
	@Test
	public void matchingPointsTest(){
		int[] expectedPoints = {1000, 200, 300, 400, 500, 600};
		for(int dieFace = 1; dieFace <= 6; dieFace++){

			int actualScore = this.scorer.matchingPoints(dieFace, 3);
			int expectedScore = expectedPoints[dieFace - 1];
			
			assertEquals(expectedScore, actualScore);
		}
	}

}
