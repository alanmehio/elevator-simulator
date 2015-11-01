package com.elevator.simulator.jms.consumer;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Service;

import com.elevator.simulator.dto.DTO;
import com.elevator.simulator.util.GeneralUtils;


@Service
public class SimpleMessageListener {
	final static Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);
	

	
	/**
	 * This is the pusher to the socket which first get the message from the broker
	 * which contain the elevetor data 
	 */
	@Autowired 
	private MessageSendingOperations<String> messagingTemplate;

	
	/**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
	 * The only thing make this class different from a common spring bean is the @JmsListener and @SendTo annotations before the method. 
	 * The @JmsListener tell spring context the following method will be used whenever a message is coming from the destination "SendToRecv" asynchronously. 
	 * The @SendTo annotation specify the destination for return message from the method.
	 * 
	 */
	@JmsListener(destination="queue1", containerFactory="jmsListenerContainerFactory", concurrency="5-10")
	public void processMessage(Message message) {
		try {
			MapMessage msg = (MapMessage) message;
			logger.info("Consumed message: " + msg.getJMSMessageID());
			logger.info("id {}", msg.getIntProperty("id"));
			logger.info("door {}", msg.getIntProperty("door"));
			logger.info("direction {}", msg.getIntProperty("direction"));
			logger.info("floor {}", msg.getIntProperty("floor"));
			logger.info("weight {}",  msg.getIntProperty("weight"));
			logger.info("date {}",  GeneralUtils.formatDate( msg.getLongProperty("date")));
			logger.info("******************************************\n");
		
			DTO dto = new DTO(msg.getIntProperty("id"), msg.getIntProperty("door"),msg.getIntProperty("direction"), msg.getIntProperty("floor"), msg.getIntProperty("weight"),msg.getLongProperty("date"));
			  this.messagingTemplate.convertAndSend(
			            "/topic/elevator", dto);
			message.acknowledge();
		} catch (JMSException e) {
			logger.error(e.getMessage());
		}
	}
	

}