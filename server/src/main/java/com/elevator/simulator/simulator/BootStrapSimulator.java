package com.elevator.simulator.simulator;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.elevator.simulator.model.Datable;
import com.elevator.simulator.simulator.impl.Configurator;
import com.elevator.simulator.simulator.impl.DataGenerator;
import com.elevator.simulator.simulator.impl.Listener;
import com.elevator.simulator.simulator.impl.Simulator;


/*
 * @Component same as @Service but service is better for usage in put cut i.e association with aspect 
 */
@Service
public class BootStrapSimulator implements BootStrapable {
	final static Logger logger = LoggerFactory.getLogger(BootStrapSimulator.class);

	
	@Autowired
	private JmsTemplate jmsTemplate;


	  /**
	   * Send text message to a specified destination
	   * @param text
	   */
	  public void send(final Destination dest,final String text) {
	      
	    this.jmsTemplate.send(dest,new MessageCreator() {
	      @Override
	      public Message createMessage(Session session) throws JMSException {
	        Message message = session.createTextMessage(text);
	        return message;
	      }
	    });
	  }
 
	 public void start() {
		 doStart();
	 }
			
	private void doStart() {
		logger.info("Starting the BootStrapSimulator call to doStart() method ");
		SimulatorInf<Datable, ListenerInf<Datable>, Long, TimeUnit> simulator = new Simulator();
		DataGeneratorInf<Datable> generator = new DataGenerator();    
		ListenerInf<Datable> listener = new JmsMessageProducer(jmsTemplate);
		ConfiguratorInf<ListenerInf<Datable>, Long, TimeUnit> configurator = new Configurator(listener, 200L, TimeUnit.MILLISECONDS);
		simulator.start(generator, configurator);
	}
	
//	private void publishObject() {
//		for(int i = 0; i < 1; i++) {
//			logger.info("before publishing the data for " + i);
//			jmsTemplate.send(new MessageCreator() {
//	            public Message createMessage(Session session) throws JMSException {
//	            	logger.info("******************");
//	    			logger.info("publish data ok");
//	    			logger.info("*******************");
//	            	MapMessage objMsg = session.createMapMessage();
//	        		objMsg.setIntProperty("id",23);
//	            	objMsg.setIntProperty("door", 1);
//	            	objMsg.setIntProperty("direction",1);
//	            	objMsg.setIntProperty("floor",2);
//	            	objMsg.setIntProperty("weight",23);
//	            	objMsg.setLongProperty("date", System.currentTimeMillis());
//	            	logger.warn("objMsg created and send ..");
//	            	logger.info("after publishing the data for ");
//	            	return objMsg;
//	            }
//	        });
//		}
//	}
	
	 @PostConstruct 
	 public void postConstruct() {
		 logger.info("after constructing the bean"); 
	 }
	
	@PreDestroy
	public void cleanUp() {
		logger.info("cleanUp before destroying the bean");
	}
	
	
	private static class JmsMessageProducer extends Listener {
		
		private JmsTemplate jmsTemplate;
		
		public JmsMessageProducer(JmsTemplate jmsTemplate) {
			this.jmsTemplate = jmsTemplate;
		}
		
		@Override
		public void dataGenerated(Datable data) {
			publishObject(data);			
		}
		
		
		private void publishObject(Datable data) {
			for(int i = 0; i < 10; i++) {
				logger.info("before publishing the data for " + i);
				jmsTemplate.send(new MessageCreator() {
		            public Message createMessage(Session session) throws JMSException {
		            	logger.info("******************");
		    			logger.info("publish data ok  {}", data);
		            	MapMessage objMsg = session.createMapMessage();
		        		objMsg.setIntProperty("id", data.getId());
		            	objMsg.setIntProperty("door", data.getDoorStatus().status());
		            	objMsg.setIntProperty("direction",data.getMovingStatus().status());
		            	objMsg.setIntProperty("floor",data.getFloorNumber());
		            	objMsg.setIntProperty("weight",data.getWeight());
		            	objMsg.setLongProperty("date", data.getDate().getTime());
		            	logger.info("after publishing the data for ");
		            	logger.info("*******************");
		            	return objMsg;
		            }
		        });
			}
			
		}
		
	}

}
