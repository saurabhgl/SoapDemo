package com.accenturedemo.soapservice;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	public static final String BASE_URL = "/api/soap";
	
	@Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), BASE_URL + "/*");
	}
	
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
	    
		SpringBus springBus = new SpringBus();
		/*
		 * LoggingFeature logFeature = new LoggingFeature();
		 * logFeature.setPrettyLogging(true); logFeature.initialize(springBus);
		 * springBus.getFeatures().add(logFeature);
		 */
	    
	    return springBus;
	}
	
	@Bean
	public Endpoint accountEndpoint() {
	    EndpointImpl accntEndpoint = new EndpointImpl(springBus(), new AccountServiceEndpoint());
	    accntEndpoint.publish("/accounts");
	
	    return accntEndpoint;
	}
	
	@Bean
	public Endpoint studentEndpoint() {
	    EndpointImpl stdEndpoint = new EndpointImpl(springBus(), new StudentServiceEndpoint());
	    stdEndpoint.publish("/student");
	
	    return stdEndpoint;
	}

}
