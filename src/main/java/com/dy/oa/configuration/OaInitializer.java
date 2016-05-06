package com.dy.oa.configuration;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OaInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { OaConfiguration.class };
    }
   
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
   
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
     
    @Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = { new CORSFilter() };
        return singleton;
    }
    
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
    	registration.setInitParameter("contextConfigLocation", "classpath:config/applicationContext.xml");
    	registration.setInitParameter("log4jConfigLocation", "classpath:config/log4j.properties");
	}
}
