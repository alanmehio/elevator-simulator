package com.elevator.simulator.simulator.impl;

import java.util.concurrent.TimeUnit;

import com.elevator.simulator.model.Datable;
import com.elevator.simulator.simulator.ConfiguratorInf;
import com.elevator.simulator.simulator.ListenerInf;

public class Configurator implements ConfiguratorInf<ListenerInf<Datable>, Long, TimeUnit> {
	private ListenerInf<Datable> listener;
	private Long frequency;
	private TimeUnit timeUnit;
	
	public Configurator(ListenerInf<Datable> listener, Long frequency, TimeUnit timeUnit) {
		this.listener = listener;
		this.frequency = frequency;
		this.timeUnit = timeUnit;
	}
	
	public Configurator(ListenerInf<Datable> listener, Long frequency) {
		this.listener = listener;
		this.frequency = frequency;
		this.timeUnit = TimeUnit.SECONDS;
		
	}
	
    public Configurator(ListenerInf<Datable> listener) {
    	this.listener = listener;
    	this.frequency = 500l;
    	this.timeUnit = TimeUnit.MILLISECONDS;
    }
	
	
	@Override
	public ListenerInf<Datable> getListener() {
		return listener;
	}

	@Override
	public Long getFrequency() {
		return frequency;
	}

	@Override
	public TimeUnit getTimeUnit() {
	
	  return timeUnit;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Configurator [listener=" + listener + ", frequency="
				+ frequency + ", timeUnit=" + timeUnit + "]";
	}
	
	

}
