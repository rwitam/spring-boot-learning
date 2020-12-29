package org.microservices.limitsservice;

import org.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations()
	{
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
	
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallBackRetriveConfiguration")
	public LimitConfiguration retrieveConfiguration()
	{
		throw new RuntimeException("Not Available");
	}
	
	
	public LimitConfiguration fallBackRetriveConfiguration()
	{
		return new LimitConfiguration(999, 9);
	}
}
