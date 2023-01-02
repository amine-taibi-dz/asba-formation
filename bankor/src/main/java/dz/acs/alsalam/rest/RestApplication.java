package dz.acs.alsalam.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/v1")
public class RestApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> clazzes = new HashSet<>();
		clazzes.add(CalcResource.class);
		return clazzes ;

	}
}