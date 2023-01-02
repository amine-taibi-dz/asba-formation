package dz.acs.biz.calc;

import java.util.Objects;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Calculator
 */
@Stateless(mappedName = "calculator")
@LocalBean
public class Calculator {

    /**
     * Default constructor. 
     */
    public Calculator() {
    }
    
    public Long add(Long op1,Long op2) {
    	if(Objects.isNull(op1)) {
    		op1 = 0L;
    	}
    	if(Objects.isNull(op2)) {
    		op2 = 0L;
    	}
    	return op1+op2;
    }

}
