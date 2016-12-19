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
		
		for(int dieFace = 1; dieFace <= 6; dieFace++){
			int numberOfDice = toBeScored.get(dieFace);
			assert toBeScored.containsKey(dieFace);
			if(dieFace == 1 || dieFace == 4){
				points += scoreOnesOrFours(dieFace, numberOfDice);
			} else {
				points += matchingPoints(dieFace, numberOfDice);
			}	
		}
		
		return points;
	}
	
	int scoreOnesOrFours(int dieFace, int numberOfThatDie){
		int numberOfPoints = 0;
		numberOfPoints += matchingPoints(dieFace, numberOfThatDie);
		numberOfPoints += ((dieFace == 1) ? (numberOfThatDie % NUMBER_TO_RECIEVE_MATCHING_STATUS)*POINTS_PER_NON_MATCHING_ONE:
			(numberOfThatDie % NUMBER_TO_RECIEVE_MATCHING_STATUS)*POINTS_PER_NON_MATCHING_THREE);
		
		return numberOfPoints;
	}
	
	int matchingPoints(int dieFace, int numberOfThatDie){
		return (numberOfThatDie >= 3) ? POINTS_FOR_THREE_OF_A_KINDS.get(dieFace):0;
	}
	
	
}
