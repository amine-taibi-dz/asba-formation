
package dz.acs.hr.rh.manger.biz.rs;

import dz.acs.hr.rh.manger.biz.EmployeeEjb;
import dz.acs.hr.rh.manger.model.Employee;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *EmployeeRS
 * @author ataibi
 */
@Path("employees")
@Stateless
public class EmployeeRS {
    
    @EJB
    private EmployeeEjb employeeEjb;
    
    @Path("/list")
    @GET
    //Type Mime 
    @Produces(value = {"application/json","application/xml"})
    public List<Employee> list(){
        List<Employee> res = null;
        res = employeeEjb.listEmployee();
        return res;
    }
    @Path("create")
    //employees/create
    @POST
    @Produces(value = {"application/json","application/xml"})
    @Consumes(value = {"application/json","application/xml"})
    public Employee createEmp(Employee emp){
        return employeeEjb.createEmployee(emp);        
    }
    
    @Path("delete/{id}")
    //employees/delete
    @DELETE
    @Produces(value = {"application/json"})
    @Consumes(value = {"application/json"})
    public Employee deleteEmployee(@PathParam("id") Long emplId){
        return employeeEjb.delete(emplId.intValue());        
    }

    public EmployeeEjb getEmployeeEjb() {
        return employeeEjb;
    }

    public void setEmployeeEjb(EmployeeEjb employeeEjb) {
        this.employeeEjb = employeeEjb;
    }
    
    
}
