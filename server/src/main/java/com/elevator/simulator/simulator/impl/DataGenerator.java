package com.elevator.simulator.simulator.impl;

import java.util.Random;

import com.elevator.simulator.model.Data;
import com.elevator.simulator.model.Datable;
import com.elevator.simulator.simulator.DataGeneratorInf;

public class DataGenerator implements DataGeneratorInf<Datable> {
    private Random   randomId;// 1,2,....30
	private Random  randomStatus; // 0, 1
    private Random  randomFloorNumber; // from 0 to 8
    private Random randomWeight; // 0 to 500 Kg
    
    public DataGenerator() {
    	randomId = new Random();
    	randomStatus = new Random();
    	randomFloorNumber = new Random();
    	randomWeight = new Random();
    }
	
	public Datable generate() {
		return new Data(generateId(),generateStatus(), generateStatus(), generateFloorNumber(),generateWeight());
	}
	
    private int generateId() { // 1, 2, 3, ....30  ( 30 elevators)
      return (randomId.nextInt(30) + 1);
    }
	
	private int generateStatus() {
		return randomStatus.nextInt(2);
	}
	
	private int generateFloorNumber() {
		return randomFloorNumber.nextInt(9); 
	}
	
	private int generateWeight() {
		return randomWeight.nextInt(51)*10;
	}
}
