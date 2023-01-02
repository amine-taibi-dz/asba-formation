package dz.asb.facturation.biz;

import java.math.BigDecimal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class FacturationBean
 */
@Stateless
@LocalBean
public class FacturationBean {

    /**
     * Default constructor. 
     */
    public FacturationBean() {}
    // 
    public BigDecimal facturer(BigDecimal montant) {
    	BigDecimal result = BigDecimal.ZERO;
    	// (1000 * (100+19))/100
    	result = montant.multiply(new BigDecimal("1.19")); 
    	return result;
    }
    
    public static void main(String[] args) {
		float val = 1101.0f;
		System.out.println( val/3.0f);
	}

}
