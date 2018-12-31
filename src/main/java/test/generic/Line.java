package test.generic;

import lombok.Data;

@Data
public class Line <T> {
	
	private Point<T> i;
	private Point<T> j;
	

}
