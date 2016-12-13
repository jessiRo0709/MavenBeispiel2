package de.jessi;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection; 

public class UtilTest {
	

	   
	@Test  
	public void testIstErstesHalbjahr(){
		
		 final int eingabe1= 5;   
		 final boolean sollWert = true;     
		 assertEquals("getestet ob 5 geht", sollWert, Util.istErstesHalbjahr(eingabe1)); 
		 final int eingabe2= 6;     
		 assertEquals("getestet ob 6 geht", sollWert, Util.istErstesHalbjahr(eingabe2));
		 final int eingabe4= 1;     
		 assertEquals("getestet ob 1 geht", sollWert, Util.istErstesHalbjahr(eingabe4));
		 
		 final boolean sollWert2=false;
		 
		 final int eingabe5= 7; 
		 assertEquals("getestet ob 7 nicht geht", sollWert2, Util.istErstesHalbjahr(eingabe5));
		
		 final int eingabe6= 0;     
	 
		 try{      
			 Util.istErstesHalbjahr(eingabe6);
			fail("Erwartete Ausnahme wurde nicht geworfen");     
			} catch(IllegalArgumentException e){ }
		 
		 final int eingabe7= 12;     
		 assertEquals("getestet ob 12 nicht geht", sollWert2, Util.istErstesHalbjahr(eingabe7));
	//	 final int eingabe8= 13;     
		// assertEquals("getestet ob 13 nicht geht", sollWert2, Util.istErstesHalbjahr(eingabe8));
	
	}
}
