package com.elevator.simulator.simulator;

/**
 * This is the Simulator 
 * @author alan
 *
 * @param <D>
 * @param <L>
 * @param <F>
 * @param <T>
 */
public interface SimulatorInf<D, L, F, T> {

	public void start(DataGeneratorInf<D> dataGenerator,
			ConfiguratorInf<L,F,T> configurator);

	public boolean isAlive();

	public void stop();

}
