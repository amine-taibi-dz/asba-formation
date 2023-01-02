package dz.acs.biz.calc;

import javax.ejb.Remote;

@Remote
public interface CalcRemote {
	 public Long add(Long op1,Long op2);
	 public Long multi(Long op1,Long op2);
}
