package com.elevator.simulator.model;

/**
 * The moving status which means 
 * weather the elevator is moving up or 
 * it is moving down
 * @author alan
 *
 */
public enum MovingStatus {
	
	UPP(1),DOWN(0);
	
	private int status;
	
	private MovingStatus(int status) {
		this.status = status;
	}
	
	public String toString() {
		return "" + status;
	}
	
	public int status() {
		return status;
	}
	
	public static MovingStatus getStatus(int status) {
		return (status == 1) ? MovingStatus.UPP:MovingStatus.DOWN;
	}

}
