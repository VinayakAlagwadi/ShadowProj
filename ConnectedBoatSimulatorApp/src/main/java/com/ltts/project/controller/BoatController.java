package com.ltts.project.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.project.boatScheduler.BoatScheduler;
import com.ltts.project.boatService.BoatService;
import com.ltts.project.model.BoatEssentials;




@RestController

public class BoatController {

	@Autowired
	BoatService bs;
	
	@Autowired 
	BoatScheduler bsh;
	
	/*
	 * @Autowired BoatEngine be;
	 */
	
	
	
	/*
	 * @Autowired private KafkaTemplate<String, BoatEssentials> kafkaTemplate;
	 * 
	 * private static final String TOPIC = "Kafka_Example";
	 */

	HashMap<String,BoatEssentials> BoatList = new HashMap();
	
	@RequestMapping(value="/boat", method=RequestMethod.POST)
	public String boat(HttpServletRequest req, Model model) throws IOException {
		String hull_id = req.getParameter("hull_id");
		int noOfEng = Integer.parseInt(req.getParameter("no"));
		String speed = req.getParameter("rangeInput");
		String log = req.getParameter("log");
		String lat = req.getParameter("lat");
		int eng=2;
		
		String stime = (java.time.LocalTime.now()).toString(); 
		/*
		 * EngineList.put(hull_id, be);
		 */
		
		
		
		
		
		
		BoatList.put(hull_id, new BoatEssentials(hull_id,noOfEng,"running",stime,speed,lat,log));
		System.out.println(BoatList);
		
		bs.startboat(BoatList, hull_id);
		
		bs.postEnginedata();
		bs.postEventdata();
		bs.postLocationdata();
		
		
		  return "Published successfully "+hull_id+" "+speed+" "+log+" "+lat;
		 
		//return null;
	}
		
}
