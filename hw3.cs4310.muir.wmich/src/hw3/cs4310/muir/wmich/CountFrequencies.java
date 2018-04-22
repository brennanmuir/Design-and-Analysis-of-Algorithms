package hw3.cs4310.muir.wmich;

import java.util.*;

/*
 * Brennan Muir
 * Gupta 4310
 * HW 3
 */

public class CountFrequencies {
	
	public static HashMap<Character, Integer> getFrequencies(String text){
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();          
		
		for(int i = 0; i < text.length(); i++){
		   char c = text.charAt(i);
		   Integer val = map.get(new Character(c));
		   if(val != null){
		     map.put(c, new Integer(val + 1));
		   }else{
		     map.put(c,1);
		   }
		}
		
		return map;
		
	}
    
    
    
	
}
