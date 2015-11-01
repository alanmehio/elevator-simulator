package com.elevator.simulator.dto;

import java.io.Serializable;

import com.elevator.simulator.model.Datable;
import com.elevator.simulator.util.GeneralUtils;

/**
 * Light weighted Data Transfer Object
 * @author alan
 *
 */
public class DTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int door;
	private int direction;
	private int floor;
	private int weight;
	private String date;
	
	
	public DTO(int _id, int _door, int _direction, int _floor, int _weight, long date) {
		this.id = _id;
		this.door = _door;
		this.direction = _direction;
		this.floor = _floor;
		this.weight = _weight;
		this.date = GeneralUtils.formatDate(date);
	}
	
	public DTO(Datable datable) {
		this.id = datable.getId();
		this.door = datable.getDoorStatus().status();
		this.direction= datable.getMovingStatus().status();
		this.floor = datable.getFloorNumber();
		this.weight = datable.getWeight();
		this.date = GeneralUtils.formatDate(datable.getDate(), true);
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}

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

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	

	

}
