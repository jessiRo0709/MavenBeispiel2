package de.jessi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class BaseResidentEasyMockTest {
	 @Test   
	 public void test() throws ResidentServiceException{ 
		 Date d = new Date(12,9,1999);
		 Resident r1= new Resident("Herman", "Mayer", "Brunnenweg1", "Donaueschingen", d);
		 Resident r2= new Resident("Hans", "Hofacker", "Brunnenweg1", "Donaueschingen", d);
		 Resident r3= new Resident("H*", "*", "Brunnenweg1", "Donaueschingen", d);
		 
		 List<Resident> lH1= new ArrayList<Resident>();
		 lH1.add(r1);
		 lH1.add(r2);
		 
		
		 
		 Resident r4= new Resident("Herman", "Mayer", "Brunnenweg1", "Donaueschingen", d);
		 Resident r5= new Resident("Susi", "Hofacker", "Brunnenweg1", "Donaueschingen", d);
		 Resident r6= new Resident("H*", "Mayer", "Brunnenweg1", "Donaueschingen", d);
		 
		 List<Resident> lH2= new ArrayList<Resident>();
		 lH2.add(r1);
		 lH2.add(r2);
		 lH2.add(r5);
		 
		 ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);
		 BaseResidentService service= new BaseResidentService ();
		 
		 expect(residentRepositoryMock.getResidents()).andReturn(lH1); 
		 expect(residentRepositoryMock.getResidents()).andReturn(lH2); 
		 
		
		 
		 replay(residentRepositoryMock);
		 
		 service.setResidentRepository(residentRepositoryMock);	
		 
		 service.getFilteredResidentsList(r3);
		 service.getUniqueResident(r5);
		 
		 verify(residentRepositoryMock);
	 }
	 


}
