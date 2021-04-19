package spring5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring5Test {

	@Test
	public void testStart() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

		@SuppressWarnings("unused")
		Object bean = applicationContext.getBean("userDAO");
		System.out.println("AAAAA");
	}
}
