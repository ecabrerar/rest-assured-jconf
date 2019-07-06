/**
 * 
 */
package com.eudriscabrera.examples.java;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author ecabrerar
 *
 */
@ApplicationPath("/")
public class AplicationConfig extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> classes = new HashSet<>();		
		classes.add(JConfColombiaEndPoint.class);
		
		return classes;
		
	}

}
