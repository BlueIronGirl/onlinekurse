package springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Employee employee = (Employee) context.getBean("emp");
        System.out.println(employee);

        ShoppingCart shoppingCart = (ShoppingCart) context.getBean("cart");
        System.out.println(shoppingCart);
    }
}
