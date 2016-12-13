package de.jessi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

public class BaseResidentServiceTest {
	
	 @Test   
	 public void testgetFilteredResidentsList(){ 
		 Date d = new Date(12,9,1999);
		 Resident r1= new Resident("Herman", "Mayer", "Brunnenweg1", "Donaueschingen", d);
		 Resident r2= new Resident("Hans", "Hofacker", "Brunnenweg1", "Donaueschingen", d);
		 Resident r3= new Resident("H*", "*", "Brunnenweg1", "Donaueschingen", d);
		 
		 List<Resident> lH1= new ArrayList<Resident>();
		 lH1.add(r1);
		 lH1.add(r2);
		 
		 ResidentRepository stub = new ResidentRepositoryStub();
		 BaseResidentService service= new BaseResidentService ();
		 service.setResidentRepository(stub);
		 
		 assertEquals("H* und *", lH1.size(), service.getFilteredResidentsList(r3).size());
		 
		 
		 Resident r4= new Resident("Herman", "Mayer", "Brunnenweg1", "Donaueschingen", d);
		 Resident r5= new Resident("Hans", "Hofacker", "Brunnenweg1", "Donaueschingen", d);
		 Resident r6= new Resident("H*", "Mayer", "Brunnenweg1", "Donaueschingen", d);
		 
		 List<Resident> lH2= new ArrayList<Resident>();
		 lH2.add(r1);
		 
		 ResidentRepository stub2 = new ResidentRepositoryStub();
		 BaseResidentService service2= new BaseResidentService ();
		 service.setResidentRepository(stub2);
		 
		 assertEquals("H*", lH2.size(), service.getFilteredResidentsList(r6).size());
	 }
	 
	 @Test  
	 public void testGetUniqueResident() throws ResidentServiceException{
		 Date d = new Date(12,9,1999);
		 Resident r1= new Resident("Herman", "Mayer", "Brunnenweg1", "Donaueschingen", d); 	
		 Resident r2= new Resident("Hans", "Hofacker", "Brunnenweg1", "Donaueschingen", d);
		 Resident r3= new Resident("H*", "*", "Brunnenweg1", "Donaueschingen", d);
		 
		 List<Resident> lH1= new ArrayList<Resident>();
		 lH1.add(r1);
		 lH1.add(r2);
		 lH1.add(r3);
		 
		 ResidentRepository stub = new ResidentRepositoryStub();
		 BaseResidentService service= new BaseResidentService ();
		 service.setResidentRepository(stub);
		 
		 assertEquals("Herman vorhanden?", lH1.get(0).getGivenName(), service.getUniqueResident(r1).getGivenName());
		 
		 Resident r4= new Resident("Susi", "Mayer", "Brunnenweg1", "Donaueschingen", d);
		     
		 
		 try{      
			 service.getUniqueResident(r3);
			fail("Erwartete Ausnahme wurde nicht geworfen");     
			} catch(ResidentServiceException e){ }
		 
		 try{      
			 service.getUniqueResident(r4);
			fail("Erwartete Ausnahme wurde nicht geworfen");     
			} catch(ResidentServiceException e){ }


	 }

}
