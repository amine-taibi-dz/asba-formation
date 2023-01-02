package dz.acs.hr.rh.manger.ui;
import dz.acs.hr.rh.manger.biz.EmployeeEjb;
import dz.acs.hr.rh.manger.model.Employee;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;


/**
 *EmployeeManagedBean
 * @author ataibi
 */

@Named
@SessionScoped
public class EmployeeManagedBean implements Serializable{
   
    @EJB
    private EmployeeEjb employeeEjb;
    
    private Employee employee2Create;
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    public EmployeeManagedBean() {
        this.employee2Create = new Employee();
    }   
    
    @PostConstruct
    public void init(){
        employees = loadEmployees();
    }
    
    public Employee getEmployee2Create() {
        return employee2Create;
    }
    public void setEmployee2Create(Employee employee2Create) {
        this.employee2Create = employee2Create;
    }
    public List<Employee> loadEmployees(){
        employees = employeeEjb.listEmployee();
        return employees;
    }
    public String save(){
        employee2Create = employeeEjb.createEmployee(employee2Create);
        
        return "list_employee?faces-redirect=true";
    }

    public EmployeeEjb getEmployeeEjb() {
        return employeeEjb;
    }
    public void setEmployeeEjb(EmployeeEjb employeeEjb) {
        this.employeeEjb = employeeEjb;
    }
    
    
    
}
