package com.manifestcorp.dicekata;

import java.util.TreeMap;

public class PointScorer {
	
	public int score(TreeMap<Integer, Integer> toBeScored){
		int points = 0;
		points += scoreOnesOrFours(toBeScored);
		points += scoreNotOnesOrFours(toBeScored);
		
		return points;
	}
	
	public int scoreOnesOrFours(TreeMap<Integer, Integer> scoreOnesAndFours){
		int[] oneAndFour = {1, 4};
		int numberOfPoints = 0;
		
		for(int number : oneAndFour){
			assert scoreOnesAndFours.containsKey(number);
			numberOfPoints += scoreOnesOrFoursPointsLogic(number, scoreOnesAndFours.get(number));
		}
		
		return numberOfPoints;
	}
	
	public int scoreOnesOrFoursPointsLogic(int number, int numberOfNumbers){
		int numberOfPoints = 0;
		if(numberOfNumbers >= 3){
			numberOfPoints += ((number == 1) ? 
					1000 + ((numberOfNumbers - 3) * 100):
						400 + ((numberOfNumbers - 3) * 40));
		} else {
			numberOfPoints += ((number == 1) ? numberOfNumbers*100:numberOfNumbers*40);
		}
		
		return numberOfPoints;
	}
	
	public int scoreNotOnesOrFours(TreeMap<Integer, Integer> scoreNotOnesOrFours){
		int numberOfPoints = 0;
		for(int dieFace = 1; dieFace <= 6; dieFace++){
			if(dieFace != 1 && dieFace != 4){
				assert scoreNotOnesOrFours.containsKey(dieFace);
				int numOfDice = scoreNotOnesOrFours.get(dieFace);
				if(numOfDice >= 3){
					numberOfPoints += (100 * dieFace);
				}
			}
		}
		
		return numberOfPoints;
	}
	
	
	
	
	
}
