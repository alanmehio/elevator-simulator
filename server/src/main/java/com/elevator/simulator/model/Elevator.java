package com.elevator.simulator.model;

/**
 * Elevator which we want to simulate
 * @author alan
 *
 */
public class Elevator {

	private int id;
	private String address;

	public Elevator() {

	}
	
	public Elevator(int _id, String _address) {
		this.id = _id;
		this.address = _address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
