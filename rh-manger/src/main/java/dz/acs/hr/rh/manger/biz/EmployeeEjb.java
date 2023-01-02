/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package dz.acs.hr.rh.manger.biz;
import dz.acs.hr.rh.manger.model.Employee;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.SessionContext;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
/**
 *EmployeeEjb
 * @author ataibi
 */

@Stateless
@Interceptors(TimeInterceptor.class)
@LocalBean
//@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmployeeEjb {

    @Inject
    private JMSContext context;
    
    @Resource(mappedName = "jms/hr_queue")
    private Destination queue;
    
    //@EJB
    //private DeliveryEjb  deliveryEjb;    
    @PersistenceContext(unitName = "rh_pu")
    private EntityManager entityManager;
   // @Transactional(Transactional.TxType.REQUIRED)    
    //@RolesAllowed(value = "ADMIN")    
    public Employee createEmployee(Employee employee){
         entityManager.persist(employee);        
        // envoyer l'emplyer pour impression de badge
        //context.createProducer().send(queue, employee);
        try {
            context.createProducer().send(queue, employee);
            
        } catch (Exception e) {
            e.printStackTrace();
        }        
        System.out.println(employee);        
        return employee;
    }
   // @Transactional(Transactional.TxType.SUPPORTS)    
    public List<Employee> listEmployee(){
        String jpql="SELECT emp FROM Employee emp";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        return query.getResultList();
    }
    //@Transactional(Transactional.TxType.REQUIRED)    
    public Employee delete(Integer id){
        Employee res = entityManager.find(Employee.class, id);
        entityManager.remove(res);
        return res;
    }
    public EntityManager getEntityManager() {
        return entityManager;
    }
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Destination getQueue() {
        return queue;
    }

    public void setQueue(Destination queue) {
        this.queue = queue;
    }

    public JMSContext getContext() {
        return context;
    }

    public void setContext(JMSContext context) {
        this.context = context;
    }
    public EmployeeEjb() {
    } 
}
