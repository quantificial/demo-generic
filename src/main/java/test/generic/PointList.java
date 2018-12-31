package test.generic;

import java.util.ArrayList;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@ToString(callSuper=true, includeFieldNames=true)
@EqualsAndHashCode
public class PointList<T> {
	
	private ArrayList<Point<T>> arrayList = new ArrayList<Point<T>>(); 

	
}
