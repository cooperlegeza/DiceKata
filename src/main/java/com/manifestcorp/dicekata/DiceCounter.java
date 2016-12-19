package com.manifestcorp.dicekata;

import java.util.TreeMap;

public class DiceCounter {
	
	private TreeMap<Integer, Integer> dieFaceAndTotalOfEach;
	
	public DiceCounter(){
		this.dieFaceAndTotalOfEach = new TreeMap<Integer, Integer>();
		for(int dieFace = 1; dieFace <= 6; dieFace++){
			this.dieFaceAndTotalOfEach.put(dieFace, 0);
		}
	}
	
	public TreeMap<Integer, Integer> getDice(){
		return this.dieFaceAndTotalOfEach;
	}
	
	public void countDice(int[] diceInput){
		int[] totalCounts = {0, 0, 0, 0, 0, 0};
		for(int die : diceInput){
			totalCounts[die - 1]++;
		}
		for(int dieFace = 1; dieFace <= 6; dieFace++){
			dieFaceAndTotalOfEach.put(dieFace, totalCounts[dieFace - 1]);
		}
	}

}
