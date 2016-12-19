package com.manifestcorp.dicekata;

import java.util.TreeMap;

public class PointScorer {
	
	private TreeMap<Integer, Integer> POINTS_FOR_THREE_OF_A_KINDS;
	private int POINTS_PER_NON_MATCHING_ONE = 100;
	private int POINTS_PER_NON_MATCHING_THREE = 40;
	private int NUMBER_TO_RECIEVE_MATCHING_STATUS = 3;
	
	public PointScorer(){
	}
	
	int score(TreeMap<Integer, Integer> toBeScored){
		int points = 0;
		points += scoreOnesOrFours(toBeScored);
		points += scoreNotOnesOrFours(toBeScored);
		POINTS_FOR_THREE_OF_A_KINDS.put(1, 1000);
		POINTS_FOR_THREE_OF_A_KINDS.put(2, 200);
		POINTS_FOR_THREE_OF_A_KINDS.put(3, 300);
		POINTS_FOR_THREE_OF_A_KINDS.put(4, 400);
		POINTS_FOR_THREE_OF_A_KINDS.put(5, 500);
		POINTS_FOR_THREE_OF_A_KINDS.put(6, 600);
		
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
		if(numberOfNumber >= NUMBER_TO_RECIEVE_MATCHING_STATUS){
			numberOfPoints += ((number == 1) ? 
					POINTS_FOR_THREE_OF_A_KINDS.get(number) + ((numberOfNumber - NUMBER_TO_RECIEVE_MATCHING_STATUS) * POINTS_PER_NON_MATCHING_ONE):
						POINTS_FOR_THREE_OF_A_KINDS.get(number) + ((numberOfNumber - NUMBER_TO_RECIEVE_MATCHING_STATUS) * POINTS_PER_NON_MATCHING_THREE));
		} else {
			numberOfPoints += ((number == 1) ? numberOfNumber*POINTS_PER_NON_MATCHING_ONE:numberOfNumber*POINTS_PER_NON_MATCHING_THREE);
		}
		
		return numberOfPoints;
	}
	
	int scoreNotOnesOrFours(TreeMap<Integer, Integer> scoreNotOnesOrFours){
		int numberOfPoints = 0;
		for(int dieFace = 1; dieFace <= 6; dieFace++){
			if(dieFace != 1 && dieFace != 4){
				assert scoreNotOnesOrFours.containsKey(dieFace);
				int numOfDice = scoreNotOnesOrFours.get(dieFace);
				if(numOfDice >= NUMBER_TO_RECIEVE_MATCHING_STATUS){
					numberOfPoints += (100 * dieFace);
				}
			}
		}
		
		return numberOfPoints;
	}
	
	
}
