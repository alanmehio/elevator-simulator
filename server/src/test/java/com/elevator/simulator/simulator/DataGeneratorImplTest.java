package com.elevator.simulator.simulator;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.elevator.simulator.model.Datable;
import com.elevator.simulator.simulator.DataGeneratorInf;
import com.elevator.simulator.simulator.impl.DataGenerator;

public class DataGeneratorImplTest {
	
	private DataGeneratorInf<Datable> generator; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		generator = new DataGenerator();
	}

	@After
	public void tearDown() throws Exception {
		generator = null;
	}

	@Test
	public void generate() {
		Datable data = generator.generate();
		assertNotNull(data.getDoorStatus());
		assertNotNull(data.getFloorNumber());
		
	}

}
