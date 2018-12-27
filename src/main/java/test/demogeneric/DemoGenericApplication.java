package test.demogeneric;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import test.generic.GenericFoo;
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
		a.setAnotherChild(true);
		
		log.info(a.getChild().toString());
		log.info(a.getAnotherChild().toString());
		
		Wrapper<GenericFoo<Integer, Boolean>> c = new Wrapper<GenericFoo<Integer, Boolean>>();
						
		
		log.info("<<< application end");
		
		
		System.exit(0);
		
	}

}

