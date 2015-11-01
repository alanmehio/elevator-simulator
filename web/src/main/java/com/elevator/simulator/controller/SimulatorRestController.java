package com.elevator.simulator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.elevator.simulator.elevator.data.ElevatorDataGenerator;
import com.elevator.simulator.model.Elevator;
import com.elevator.simulator.simulator.BootStrapable;


/**
 * The controller based on spring rest
 * @author alan
 *
 */
@Controller
@RequestMapping("/*")
public class SimulatorRestController {
	
	
	
	

	/**
	 * obtain by spring container inejection 
	 * the httpRequest object
	 */
	@Autowired private HttpServletRequest request;
	
	@Autowired private  BootStrapable bootstrap;
	

	@RequestMapping(value="/elevator/start", method=RequestMethod.GET)
	public ModelAndView viewListGroup(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		List<Elevator> elevators = ElevatorDataGenerator.generateModel(30);
		model.addAttribute("elevators", elevators);
		model.addAttribute("servletContext", request.getServletContext().getContextPath());
		ModelAndView  modelAndView =new ModelAndView("/home", "command", model); 
		bootstrap.start();
		return modelAndView;
	}
	
	@RequestMapping(value="/getData", method=RequestMethod.GET)
	public  @ResponseBody String getData() {   
		return "Elevator Simulator Started"; 
	}
	
	
	
	
	
	
}
