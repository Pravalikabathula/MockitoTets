package com.test.PowermockTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.demo.PowerMockito.Notification;
import com.demo.PowerMockito.OrderRequest;
import com.demo.PowerMockito.OrderResponse;
import com.demo.PowerMockito.OrderService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.test.PowermockTests")
public class PowermockApiApplicationTests {

	@InjectMocks
	private OrderService service;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(Notification.class);
	}

	@Test
	public void testStaticMethod() {
		// Given
		String emailid = "Sony@gmail.com";
		PowerMockito.mockStatic(Notification.class);
		// When
		when(Notification.sendEmail(emailid)).thenReturn("success");
		// Then
		OrderRequest request = new OrderRequest(11, "Mobile", 1, 10000, "Sony@gmail.com", true);

		OrderResponse response = service.checkoutOrder(request);

		assertEquals("success", response.getMessage());
	}

	/*
	 * @Test public void testPrivateMethod() throws Exception { // When OrderService
	 * spy = PowerMockito.spy(service);
	 * 
	 * doReturn(2000).when(spy, "addDiscount", ArgumentMatchers.any()); // Then
	 * OrderResponse response = spy.checkoutOrder(request); int price =
	 * response.getResponse().getPrice();// 9000 System.out.println("price : " +
	 * price); assertEquals(8000, price); }
	 */

}