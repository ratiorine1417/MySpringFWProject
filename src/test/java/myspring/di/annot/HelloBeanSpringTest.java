package myspring.di.annot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	HelloBean hello;
	
	@Autowired
	@Qualifier("stringPrinterBean")
	PrinterBean printer;

	// 전략2의 constructor injection 설정을 테스트
	@Test @Disabled
	void helloBeanConstructor() {
		Assertions.assertEquals("Hello 생성자 어노테이션", hello.sayHello());
		
		hello.print();
		
		Assertions.assertEquals("Hello 생성자 어노테이션", printer.toString());
	}
	
	// 전략2의 setter injection 설정을 테스트
	@Test //@Disabled
	void helloBean() {
		Assertions.assertEquals("Hello 어노테이션", hello.sayHello());
		
		hello.print();
		
		Assertions.assertEquals("Hello 어노테이션", printer.toString());
		
		Assertions.assertEquals(3, hello.getNames().size());
		
		for (String name: hello.getNames()) {
			System.out.println(name);
		}
	}
}
