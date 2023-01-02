package dz.acs.alsalam.rest;

import java.util.Objects;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/calc")
public class CalcResource {
	/**
	 * add method ...
	 * @param op1
	 * @param op2
	 * @return op1+op2
	 */
	@GET
	@Path("add/{op1}/{op2}")
	@Produces("application/json")
	public Long add(@PathParam("op1") Long op1, @PathParam("op2")Long op2) {
		if(Objects.isNull(op1)) {
			op1 = 0L;
		}
		if(Objects.isNull(op2)) {
			op2 = 0L;
		}
		return op1+op2;
	}

}
