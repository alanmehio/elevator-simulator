package com.elevator.simulator.simulator;

/**
 * Configurator for a given simulator
 * @author alan
 *
 * @param <L>
 * @param <F>
 * @param <T>
 */
public interface ConfiguratorInf<L, F, T>{
		
	public L getListener();
	
	public F getFrequency();
	
	public T getTimeUnit(); 
	
	
}
