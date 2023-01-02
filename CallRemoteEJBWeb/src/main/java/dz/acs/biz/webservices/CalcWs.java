package dz.acs.biz.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class CalcWs {

	@WebMethod(operationName = "_ADD_")
	public long add(@WebParam(name = "_OP1_") Long op1,@WebParam(name = "_OP2_")Long op2) {
	    return op1+op2;
	}
}
