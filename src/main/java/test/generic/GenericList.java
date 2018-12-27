package test.generic;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper=true, includeFieldNames=true)
@EqualsAndHashCode
public class GenericList<T extends List> { // only allow the type which extends List
	
	T[] value;

}
