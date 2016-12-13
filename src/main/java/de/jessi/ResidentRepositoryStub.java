package de.jessi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentRepositoryStub implements ResidentRepository{
	
	Date d = new Date(12,9,1999);
	private Resident r1= new Resident("Herman", "Mayer", "Brunnenweg1", "Donaueschingen", d);
	private Resident r2= new Resident("Hans", "Hofacker", "Brunnenweg1", "Donaueschingen", d);
	private Resident r3= new Resident("Susi", "Mayer", "Brunnenweg1", "Donaueschingen", d);
	
	List<Resident> l= new ArrayList<Resident>();
	
	
	

	public ResidentRepositoryStub() {
		super();
		l.add(r1);
		l.add(r2);
		l.add(r3);
		
		// TODO Auto-generated constructor stub
	}




	public List<Resident> getResidents() {
		// TODO Auto-generated method stub
	
		return l ;
	}

}
