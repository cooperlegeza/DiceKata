package com.manifestcorp.dicekata;

import java.util.TreeMap;

public class DiceCounter {
	
	private TreeMap<Integer, Integer> dice;
	
	public DiceCounter(){
		this.dice = new TreeMap<Integer, Integer>();
		for(int dieFace = 1; dieFace <= 6; dieFace++){
			this.dice.put(dieFace, 0);
		}
	}
	
	public TreeMap<Integer, Integer> getDice(){
		return this.dice;
	}
	
	public void countDice(int[] diceInputArray){
		int[] countArray = {0, 0, 0, 0, 0, 0};
		for(int die : diceInputArray){
			countArray[die - 1]++;
		}
		for(int count = 1; count <= 6; count++){
			dice.put(count, countArray[count - 1]);
		}
	}

}
