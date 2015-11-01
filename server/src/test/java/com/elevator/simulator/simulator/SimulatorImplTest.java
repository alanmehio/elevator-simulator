package com.elevator.simulator.simulator;

import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.elevator.simulator.model.Datable;
import com.elevator.simulator.simulator.impl.Configurator;
import com.elevator.simulator.simulator.impl.DataGenerator;
import com.elevator.simulator.simulator.impl.Simulator;

public class SimulatorImplTest {
	
	private SimulatorInf<Datable, ListenerInf<Datable>, Long, TimeUnit> simulator;
	
	
	@Before 
	public void setup() {
	  simulator = new Simulator();	
	}
	
	@After 
	public void tearDown() {
		
	}
	
	@Test
	public void start() throws Exception {
		DataGeneratorInf<Datable> generator = new DataGenerator();
		MyListenerImpl listener = new MyListenerImpl();
		ConfiguratorInf<ListenerInf<Datable>, Long, TimeUnit> configurator =  new Configurator(listener, 200L, TimeUnit.MILLISECONDS);
		simulator.start(generator, configurator);
		assertNotNull(listener);
	}

	
	private class MyListenerImpl implements ListenerInf<Datable> {
		
		private Datable data;

		@Override
		public void dataGenerated(Datable data) {
			this.data = data;
			System.out.println(data);
			
		}
		
		public Datable getData() {
			return data;
		}
		
	}
}
