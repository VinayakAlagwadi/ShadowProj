package com.ltts.project.boatService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ltts.project.model.BoatEngine;
import com.ltts.project.model.BoatEssentials;
import com.ltts.project.model.BoatEvents;
import com.ltts.project.model.BoatLocation;



@Service
public class BoatService {
	
	
	String hull_id;
	
	@Value("${excelFile.url}") 
	private String excelFileUrl;
	
	public static int rc=0;

	
	
	HashMap<String,BoatEssentials> boatVehicle = new HashMap<>(); 
	
	/*
	 * String hull_id; String imei; String speed; String log; String lat;
	 */
	    
	@Autowired
	    private KafkaTemplate<String, BoatEngine> kafkaTempEngine;

	    private static final String EngineTOPIC = "boatEngine";
	
		@Autowired
	    private KafkaTemplate<String, BoatEvents> kafkaTempEvent;

	    private static final String EventTOPIC = "boatEvent";
	
		@Autowired
	    private KafkaTemplate<String, BoatLocation> kafkaTempLocation;

	    private static final String LocationTOPIC = "boatlocation";
	    
		@Autowired
	    private KafkaTemplate<String, BoatLocation> kafkaTempSensor;

	    private static final String SensorTOPIC = "boatSensor";
		@Autowired
	    private KafkaTemplate<String, BoatLocation> kafkaTempLog;

	    private static final String LogTOPIC = "boatlog";
	    	    
	
	
	  
		

		public void postEnginedata() {
			
			
		
		BoatEssentials bs = boatVehicle.get(hull_id);
		 
		String hull =  bs.getHull_Id();
		
		int n = bs.getNoofEngines(); 
		
		System.out.println("hull"+hull);
		
		for(int i=0 ;i<n;i++) {
				
				
		BoatEngine b = new BoatEngine();
		b.setHull_id(hull);
		b.setEngine_id(i+1);
		b.setEngine_rpm(getRandomNumberDouble(2000, 3000));
		b.setOil_pressure(getRandomNumberDouble(0, 55));
		b.setOil_temperature(getRandomNumberDouble(175, 200));
		b.setEngine_runtime(getRandomNumberDouble(0, 10));
		b.setEngine_temp(getRandomNumberDouble(125,150));
		
		b.setEngine_fuel_rate(getRandomNumberDouble(1, 6));
		
	    	 kafkaTempEngine.send(EngineTOPIC,b);

			// TODO Auto-generated method stub
		
			}
		}
		
		
		public void postEventdata() {
			
			
			
			 BoatEssentials bs = boatVehicle.get(hull_id);
			 
			String hull =  bs.getHull_Id();
			double speed = Double.parseDouble(bs.getBoat_Speed());
			
			System.out.println("hull"+hull);
			
			JSONObject json = new JSONObject();
			json.put(hull, new BoatEvents(hull,false,speed,"20"));
				
		    	 kafkaTempEvent.send(EventTOPIC,new BoatEvents(hull,false,speed,"20"));

				// TODO Auto-generated method stub
				
			}
		
		
		public void postboat() {
			
			
			
		}
		
		public void postLocationdata() throws IOException {
			
			
			
			 BoatEssentials bs = boatVehicle.get(hull_id);
			 
			int sp = Integer.parseInt(bs.getBoat_Speed());
			
			String hull =  bs.getHull_Id();
			
			if(sp >0) { 
			BoatLocation bl = new BoatLocation();
			bl.setHull_id(hull);
			readBoatLocation(bl);
			bl.setAltitude(getRandomNumberDouble(0, 4));
			bl.setHeading(getRandomNumberDouble(0, 4));
			bl.setTimestamp((java.time.LocalTime.now()).toString());
			//bl.setLatitude(null);
			
			//double lat = Double.parseDouble(bs.getLatitude());
			//double longt = Double.parseDouble(bs.getLongitude());
			
			
			
				
		    	 kafkaTempLocation.send(LocationTOPIC,bl);

				// TODO Auto-generated method stub
				
			}
			else {
				System.out.println("boat idle");
			}
		}


		public void startboat(HashMap<String, BoatEssentials> boatList, String hull) {
			
			
			 BoatEssentials bs = boatList.get(hull);
			 
				 hull_id =  bs.getHull_Id();
				
				boatVehicle.put(hull_id, bs);
			// TODO Auto-generated method stub
			
			
		}
		
		public Double getRandomNumberDouble(int min, int max) {
			DecimalFormat df = new DecimalFormat("###.##");
			Double randomNumber = (Math.random() * (max - min + 1) + min);
			return Double.parseDouble(df.format(randomNumber));
		}
		
		public void readBoatLocation(BoatLocation loc) throws IOException
		{  
			try {
			 InputStream file= (InputStream) this.getClass().getResourceAsStream(excelFileUrl);
	    	  XSSFWorkbook myExcelBook = new XSSFWorkbook(file);
	    	   XSSFSheet myExcelSheet =myExcelBook.getSheetAt(0); 
				if(rc<98)
				{ 
					Row row = myExcelSheet.getRow(rc); 
					if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){ 
						double latitude = row.getCell(0).getNumericCellValue(); 
						loc.setLatitude(latitude);
					}
					if(row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
						double longitude= row.getCell(1).getNumericCellValue(); 
						loc.setLongitude(longitude);
					}
				}
				else
				{
					Row row = myExcelSheet.getRow(rc); 
					if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){ 
						double latitude = row.getCell(0).getNumericCellValue(); 
						loc.setLatitude(latitude);
					}
					if(row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
						double longitude= row.getCell(1).getNumericCellValue(); 
						loc.setLongitude(longitude);
					}
					rc=0;	
					
				}
				rc++;
			}catch(FileNotFoundException e) {
				System.out.println("Exception  "+e);
			}
		}
		
		
		
}
