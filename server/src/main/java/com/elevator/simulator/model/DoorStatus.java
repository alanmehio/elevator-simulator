package com.elevator.simulator.model;

/**
 * The elevator door weather open or close
 * 
 * @author alan
 *
 */
public enum DoorStatus {
	
	OPEN(1),Close(0);
	
	private int status;
	
  private DoorStatus(int status) {
	  this.status = status;
  }
  
  public String toString() {
	  return "" + status;
  }
  
  public int status() {
	  return status;
  }
  
   public  static DoorStatus getStatus(int status) {
	  return (status == 1 ) ? DoorStatus.OPEN:DoorStatus.Close; 
   }
}
