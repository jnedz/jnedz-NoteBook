package utils;

import java.util.LinkedHashSet;
import java.util.Set;

public class IdGenerator {
	
	public Set<Long> list = new LinkedHashSet<>();
	int min;
	int max;
	
	public IdGenerator(Set<Long> list){
		this.list = list;
	}
	
	public IdGenerator(Set<Long> list, int min, int max){
		this.list = list;
		this.min = min;
		this.max = max;
	}

	public  long getID(int min, int max){
		this.min = min;
		this.max = max;
		
		 Long id = (long) Math.floor(Math.random()* (max-min+1))+min;
		
		 if (list.isEmpty()) {
			 list.add(id);
			 return id;
		 }
		 
		 while (list.contains(id)){
			 id = (long) Math.floor(Math.random()* (max-min+1))+min; 
					
		 }
		 list.add(id);
		 return id;
	}
	

}
