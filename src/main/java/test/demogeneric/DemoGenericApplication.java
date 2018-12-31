package test.demogeneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import test.generic.GenericFoo;
import test.generic.GenericList;
import test.generic.Hey;
import test.generic.Point;
import test.generic.Wrapper;

@SpringBootApplication
@Slf4j
public class DemoGenericApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(DemoGenericApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(">>> application start");
		
		GenericFoo<Integer, Boolean> a = new GenericFoo();
		
		Object b = new Integer(10);
		
		a.setChild(100);		
		a.setAnotherChild(false);
		
		log.info(a.getChild().toString());
		log.info(a.getAnotherChild().toString());
		
		Wrapper<GenericFoo<Integer, Boolean>> c = new Wrapper<GenericFoo<Integer, Boolean>>();
		
		
		GenericList<ArrayList> list =new GenericList<ArrayList>();
				
//		ArrayList test = new ArrayList(4);
//		test.add("a");		
//		test.forEach(x -> log.info(x.toString()));
		
		int intArray[] = {1,2,3,4,5,6,7,99,8,9,10,11,12 };
		
		// anonymous class
		OptionalInt i = Arrays.stream(intArray).reduce(new IntBinaryOperator() {
			
			public int applyAsInt(int left, int right) {
			
				return left>right? left:right;
			
			}
		});
		
		// simplified by using lambda
		OptionalInt j = Arrays.stream(intArray).reduce((x,y) -> Math.max(x, y));
		
		// simplified to using double colon operator
		OptionalInt k = Arrays.stream(intArray).reduce(Math::max);
		
		
		log.info("max number: " + i + " " + i.getAsInt());
		log.info("max number: " + j + " " + j.getAsInt());
		log.info("max number: " + k + " " + k.getAsInt());
		
		
		log.info("hey: " + Hey.square(10));
		
		
		Point x = new Point(1,2);
		Point y = new Point(2,4);
		List<Point> pointList = Arrays.asList(x,y);
		
		//pointList.stream().forEach(Point::showMessage);
		
		Function<Point, String> showMessage = Point::showMessage;		
		showMessage.apply(x);
		
		Function<Integer, Integer> identity = Point::identity;
		//Integer result = identity.apply(new Integer(100));
		
		log.info("<<< application end");
		
		
		System.exit(0);
		
	}

}

