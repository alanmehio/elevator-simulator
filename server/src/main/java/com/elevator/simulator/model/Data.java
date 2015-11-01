package com.elevator.simulator.model;

import java.util.Date;


/**
 * The model data for a given elevator
 * @author alan
 *
 */
public class Data implements Datable {
	private int id;
	private DoorStatus doorStatus;
	private MovingStatus movingStatus;
	private int floorNumber;
	private int weight; // Kg
	private Date date;
	
	public Data(int id,int doorStatus, int movingStatus, int floorNumber, int weight) {
		this.id = id;
		this.doorStatus = DoorStatus.getStatus(doorStatus);
		this.movingStatus = MovingStatus.getStatus(movingStatus);
		this.floorNumber = floorNumber;
		this.weight = weight;
		this.date = new Date();
	}
	
	public Data(int id, DoorStatus doorStatus, MovingStatus movingStatus, int floorNumber, int weight) {
		this.id = id;
		this.doorStatus = doorStatus;
		this.movingStatus = movingStatus;
		this.floorNumber = floorNumber;
		this.weight = weight;
		this.date  = new Date();
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public DoorStatus getDoorStatus() {
		return doorStatus;
	}

	@Override
	public MovingStatus getMovingStatus() {
		return movingStatus;
	}

	@Override
	public int getFloorNumber() {
		return floorNumber;
	}

	@Override
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Data [id=" + id + ", doorStatus=" + doorStatus
				+ ", movingStatus=" + movingStatus + ", floorNumber="
				+ floorNumber + ", weight=" + weight + ", date=" + date + "]";
	}
	
	
	
	

}
