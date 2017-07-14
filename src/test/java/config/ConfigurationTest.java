package config;

import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.Test;

import simulator.grocery.GroceryInterface;

public class ConfigurationTest {


	@Test (timeout = 100)
	public void testQueueSet() {
		if(Configuration.getQueueImplementation() == null)
			fail("You have not set your queue in the configuration class.");
	}
	
	@Test (timeout = 100)
	public void testReceiptSet() {
		if(Configuration.getReceiptImplementation(new LinkedList<GroceryInterface>(), 0.0) == null)
			fail("You have not set your receipt implementation in the configuration class.");
	}
	
	@Test (timeout = 100)
	public void testNormalLine() {
		if(Configuration.getNormalLine() == null)
			fail("You have not set your normal line implementation in the configuration class.");
	}
	
	@Test (timeout = 100)
	public void testExpressLine() {
		if(Configuration.getExpressLine() == null)
			fail("You have not set your express line implementation in the configuration class.");
	}

	
}
