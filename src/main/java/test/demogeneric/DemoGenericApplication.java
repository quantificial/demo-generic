package test.demogeneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import test.generic.GenericFoo;
import test.generic.GenericList;
import test.generic.Hey;
import test.generic.Point;
import test.generic.Wrapper;
import test.generic.func.EmptyInput;
import test.generic.func.Finder;
import test.generic.func.Information;

import com.google.common.base.Preconditions;

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
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		// testing function
		
		Function<Point, String> showMessage = Point::showMessage;		
		showMessage.apply(x);
		
		Function<Integer, Integer> identity = Point::identity;
		//Integer result = identity.apply(new Integer(100));
						
		///////////////////////////////////////////////////////////////////////////////////////////////////
		// Lambda expression is stateless
		Information information = input -> input;		
		log.info(information.showDetails("hello"));
		
		Information info2 = new Information( ) {
			// anonymous class is stateful and it could be used to keep
			private int callCount = 0;
			@Override
			public String showDetails(String detailLevel) {
				callCount++;
				return String.format("Detail Level [%s], Call Count [%s]", detailLevel, callCount);
			}			
		};
		
		log.info(info2.showDetails("hello 2"));
		log.info(info2.showDetails("hello 3"));
		log.info(info2.showDetails("hello 4"));
		
		EmptyInput emptyInput = () -> { return 10; };
		
		log.info("empty input: " + emptyInput.getRandom());
		
		// simpify
		
		Information sInfo1 = (z) -> (StringUtils.capitalize(z));
		log.info("sInfo1: " + sInfo1.showDetails("test sInfo1"));
		
		Information sInfo2 = StringUtils::capitalize;
		log.info("sInfo2: " + sInfo1.showDetails("test sInfo2"));
		
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		// Method Reference
				
		Finder finder = DemoGenericApplication::doFind;
		log.info(""+finder.find("this is a testing", "is"));
		
		// parameter method reference, try to match the method of the first parameter
		Finder finder2 = String::lastIndexOf;
		log.info(""+finder.find("this is a testing", "is"));
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		// Guava

		Optional<Integer> oi = Optional.ofNullable(null);		
		Preconditions.checkNotNull(null);
		
		
		
		
		
		log.info("<<< application end");				
		System.exit(0);
		
	}
	
    public static int doFind(String s1, String s2){
        return s1.lastIndexOf(s2);
    }	

}

