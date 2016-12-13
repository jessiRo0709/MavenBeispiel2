package de.jessi;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	Queue object;
	
	@Before
	public void vor(){
	object = new Queue(3);
	}
	
	@Test  
	public void testEnque(){
		
		int eingabe = 1;
		object.enqueue(eingabe);
		 assertEquals("getestet ob Eingabe geht", eingabe, object.dequeue());
		 
		int eingabe1 = 1;
		object.enqueue(eingabe1);
		 
		int eingabe2 = 2;
		object.enqueue(eingabe2);
		
		int eingabe3 = 3;
		object.enqueue(eingabe3);
		
		int eingabe4 = 4;
		object.enqueue(eingabe4);
		
		object.dequeue();
		object.dequeue();
		
		assertEquals("Überschreiben geht", eingabe4, object.dequeue());	 
		
	}
	
	@Test
	public void testDequeue(){
		
		int eingabe1 = 1;
		object.enqueue(eingabe1);
		 
		int eingabe2 = 2;
		object.enqueue(eingabe2);
		
		assertEquals("Erstes wurde genommen", eingabe1, object.dequeue());	
		object.dequeue();
		
		//leer
		
		int eingabe3 = 3;
		object.enqueue(eingabe3);		
		assertEquals("löschen geht", eingabe3, object.dequeue());	 
		
		 try{       object.dequeue(); 
		 			fail("Erwartete Ausnahme wurde nicht geworfen");     
		 			} catch(IllegalStateException e){   
		 }
		
		
	}
}
