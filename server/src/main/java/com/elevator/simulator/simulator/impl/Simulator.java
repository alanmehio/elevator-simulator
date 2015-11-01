package com.elevator.simulator.simulator.impl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elevator.simulator.model.Datable;
import com.elevator.simulator.simulator.ConfiguratorInf;
import com.elevator.simulator.simulator.CountableInf;
import com.elevator.simulator.simulator.DataGeneratorInf;
import com.elevator.simulator.simulator.ListenerInf;
import com.elevator.simulator.simulator.SimulatorInf;

/**
 * The elevator data simulator
 * @author alan
 *
 */
public class Simulator implements SimulatorInf<Datable, ListenerInf<Datable>, Long, TimeUnit>, CountableInf<Long> {
	final static Logger logger = LoggerFactory.getLogger(Simulator.class);
	private static final int THREADS = 2;
	private static final boolean NO_INTERRUPTION_IF_RUNNING = false;
	private DataGeneratorInf<Datable> generator;
	private ConfiguratorInf<ListenerInf<Datable>, Long, TimeUnit> configurator;
	private ScheduledExecutorService schedule; 
	private  ScheduledFuture<?> scheduledFuture;
	private  long counter;
	@Override
	public void start(DataGeneratorInf<Datable> generator,
			ConfiguratorInf<ListenerInf<Datable>, Long, TimeUnit> configurator) {
		logger.info("starting the Simulator now");
		this.generator = generator;
		this.configurator = configurator;
		 schedule =Executors.newScheduledThreadPool(THREADS);
		 doStart();
	}
	
	private void doStart() {
	   logger.info("call doStart() with the following configuration {}", configurator);
		Runnable repetativeTask = new RepetativeTask();
		Thread t = new Thread(repetativeTask);
		t.start();
	   scheduledFuture = schedule.scheduleAtFixedRate(repetativeTask, 10L, configurator.getFrequency(), configurator.getTimeUnit());
	}
	
	@Override
	public boolean isAlive() {
	 return !schedule.isShutdown();
	}
	@Override
	public void stop() {
		scheduledFuture.cancel(NO_INTERRUPTION_IF_RUNNING);
		schedule.shutdown();
	}
	
	@Override
	public Long getCounter() {
		return counter;
	}

	
	/**
	 * ReperativeTask to do which simulate the case of real data flow
	 * @author alan
	 *
	 */
   private class  RepetativeTask implements Runnable {

	  @Override
	  public void run() {
	        Datable datable = generator.generate();
			configurator.getListener().dataGenerated(datable);	
			logger.info("countuer {}",counter++);
	      }
	  }

}
