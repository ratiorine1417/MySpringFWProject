package mylab.order.di.xml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	@Autowired
	ShoppingCart shoppingCart;
	
	@Autowired
	OrderService orderService;
	
	@Test @Disabled
	void shoppingCartBean() {
		Assertions.assertNotNull(shoppingCart);
		Assertions.assertEquals(2, shoppingCart.getProducts().size());
		Assertions.assertEquals("노트북", shoppingCart.getProducts().get(0).getName());
		Assertions.assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
	}

	@Test
	void orderServiceBean() {
		Assertions.assertNotNull(orderService);
		Assertions.assertNotNull(orderService.getShoppingCart());
		
		ShoppingCart products = orderService.getShoppingCart();
		if (products != null) {
		    for (Product product : products.getProducts()) {
		    	System.out.println(product.getId());
		    	System.out.println(product.getName());
		    	System.out.println(product.getPrice());
		    }
		}
	}
}