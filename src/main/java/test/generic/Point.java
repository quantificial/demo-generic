package test.generic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@ToString(callSuper=true, includeFieldNames=true)
@EqualsAndHashCode
public class Point<T> {			
	private T x;
	private T y;
	
	public Point(T x, T y) {
		this.x = x;
		this.y = y;
	}
	
	public String showMessage() {
		
		String message = "default Message: " + this.toString();				
		
		log.info(message);
		
		return message;
	}
	
	public static Integer identity(Integer x) {
		return x;
	}
	
}
