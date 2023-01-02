package dz.acs.biz.calc;

import java.util.Objects;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import org.jboss.logging.Logger;


/**
 * Session Bean implementation class Calc
 */
@Stateless(mappedName = "calc")
@LocalBean
public class Calc implements CalcRemote {
	
	private static final Logger LOGGER = Logger.getLogger(Calc.class);


    /**
     * Default constructor. 
     */
    public Calc() {
    }
    public Long add(Long op1,Long op2) {
    	if(Objects.isNull(op1)) {
    		op1 = 0L;
    	}
    	if(Objects.isNull(op2)) {
    		op2 = 0L;
    	}
    	LOGGER.info(String.format("adding %d & %d",op1,op2));
    	return op1+op2;
    }
    public Long multi(Long op1,Long op2) {
    	if(Objects.isNull(op1)) {
    		op1 = 0L;
    	}
    	if(Objects.isNull(op2)) {
    		op2 = 0L;
    	}
    	LOGGER.info(String.format("multiplying %d & %d",op1,op2));
    	return op1*op2;
    }
}
