package com.elevator.simulator.simulator;

/**
 * Listener  for a given data generated
 * @author alan
 *
 * @param <D>
 */
public interface ListenerInf<D> {
	
	public  void dataGenerated(D d);

}
