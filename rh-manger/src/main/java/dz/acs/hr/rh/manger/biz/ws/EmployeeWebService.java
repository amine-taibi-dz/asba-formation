package dz.acs.hr.rh.manger.biz.ws;

import dz.acs.hr.rh.manger.biz.EmployeeEjb;
import dz.acs.hr.rh.manger.model.Employee;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author ataibi
 */
@WebService()
@Stateless
@LocalBean
public class EmployeeWebService {
   
    @EJB
    private EmployeeEjb employeeEjb;
    // ---- methode webservice
    @WebMethod( operationName = "employee_create")
    public Employee createEmployee(Employee employee){
       return employeeEjb.createEmployee(employee);
    }    

    @WebMethod(exclude = true)
    public EmployeeEjb getEmployeeEjb() {
        return employeeEjb;
    }

    @WebMethod(exclude = true)
    public void setEmployeeEjb(EmployeeEjb employeeEjb) {
        this.employeeEjb = employeeEjb;
    }
    
}
