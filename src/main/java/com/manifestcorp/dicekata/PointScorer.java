package com.manifestcorp.dicekata;

import java.util.TreeMap;

public class PointScorer {
	
	private TreeMap<Integer, Integer> POINTS_FOR_THREE_OF_A_KINDS = new TreeMap<Integer, Integer>();
	private int POINTS_PER_NON_MATCHING_ONE = 100;
	private int POINTS_PER_NON_MATCHING_THREE = 40;
	private int NUMBER_TO_RECIEVE_MATCHING_STATUS = 3;
	
	public PointScorer(){
		POINTS_FOR_THREE_OF_A_KINDS.put(1, 1000);
		POINTS_FOR_THREE_OF_A_KINDS.put(2, 200);
		POINTS_FOR_THREE_OF_A_KINDS.put(3, 300);
		POINTS_FOR_THREE_OF_A_KINDS.put(4, 400);
		POINTS_FOR_THREE_OF_A_KINDS.put(5, 500);
		POINTS_FOR_THREE_OF_A_KINDS.put(6, 600);
	}
	
	int score(TreeMap<Integer, Integer> toBeScored){
		int points = 0;
		points += scoreOnesOrFours(toBeScored);
		points += scoreNotOnesOrFours(toBeScored);
		
		return points;
	}
	
	int scoreOnesOrFours(TreeMap<Integer, Integer> scoreOnesAndFours){
		int[] oneAndFour = {1, 4};
		int numberOfPoints = 0;
		
		for(int number : oneAndFour){
			assert scoreOnesAndFours.containsKey(number);
			numberOfPoints += scoreOnesOrFoursPointsLogic(number, scoreOnesAndFours.get(number));
		}
		
		return numberOfPoints;
	}
	
	int scoreOnesOrFoursPointsLogic(int number, int numberOfNumber){
		int numberOfPoints = 0;
		numberOfPoints += matchingPoints(number, numberOfNumber);
		numberOfPoints += ((number == 1) ? (numberOfNumber % NUMBER_TO_RECIEVE_MATCHING_STATUS)*POINTS_PER_NON_MATCHING_ONE:
			(numberOfNumber % NUMBER_TO_RECIEVE_MATCHING_STATUS)*POINTS_PER_NON_MATCHING_THREE);
		
		return numberOfPoints;
	}
	
	int scoreNotOnesOrFours(TreeMap<Integer, Integer> scoreNotOnesOrFours){
		int numberOfPoints = 0;
		for(int dieFace = 1; dieFace <= 6; dieFace++){
			assert scoreNotOnesOrFours.containsKey(dieFace);
			numberOfPoints += notOneOrFourPoints(dieFace, scoreNotOnesOrFours);
		}
		
		return numberOfPoints;
	}
	
	int notOneOrFourPoints(int dieFace, TreeMap<Integer, Integer> totalOfEachDie){
		int points = 0;

		if(dieFace != 1 && dieFace != 4){
			int numOfDice = totalOfEachDie.get(dieFace);
			points = matchingPoints(dieFace, numOfDice);
		}
		
		return points;
	}
	
	int matchingPoints(int dieFace, int numberOfThatDie){
		int points = 0;
		
		if(numberOfThatDie >= 3){
			points = POINTS_FOR_THREE_OF_A_KINDS.get(dieFace);
		}
		
		return points;
	}
	
	
}
