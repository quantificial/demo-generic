package test.generic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper=true, includeFieldNames=true)
@EqualsAndHashCode
public class Wrapper<T> {

	T wrapped;
	
}
