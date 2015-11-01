package com.elevator.simulator.elevator.data;

import java.util.ArrayList;
import java.util.List;

import com.elevator.simulator.model.Elevator;

public class ElevatorDataGenerator {
	
	private static final String ADDRESS1= "Azadi Road ";
	private static final String ADDRESS2 = ", Hawler, Kurdistan";
	
	public static List<Elevator> generateModel(int number) {
		List<Elevator> elevators = new  ArrayList<Elevator>();
		for(int i = 1; i <= number; i++) {
			Elevator elevator = new Elevator(i, ADDRESS1 + i + ADDRESS2);
			elevators.add(elevator);
		}
		
		return elevators;
	}

}
