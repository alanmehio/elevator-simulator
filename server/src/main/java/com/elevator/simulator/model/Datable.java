package com.elevator.simulator.model;

import java.util.Date;

/**
 * Interface for the model data for an 
 * elevator
 * @author alan
 *
 */
public interface Datable {
	
	public int getId();
	
	public DoorStatus getDoorStatus();

	public MovingStatus getMovingStatus();

	public int getFloorNumber();
	
	int getWeight();
	
	Date getDate();

}
