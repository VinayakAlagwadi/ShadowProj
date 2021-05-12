package com.ltts.project.boatScheduler;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ltts.project.boatService.BoatService;
import com.ltts.project.controller.BoatController;



@Component
@EnableScheduling
public class BoatScheduler {

	@Autowired
    BoatService boatService;
	

	
	
	
	
	  @Scheduled(initialDelayString="${TIMEOUT_SCHEDULER_INTIAL_DELAY}",
	  fixedRateString="${TIMEOUT_SCHEDULER_DELAY}") public void postBoat() throws
	  IOException {
	  
	  
		  
	  System.out.println("hi"); 
	  boatService.postLocationdata();
	  
	  }
	 
    }





