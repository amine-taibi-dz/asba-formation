/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package dz.acs.hr.rh.manger.biz.mdb;

import dz.acs.hr.rh.manger.model.Employee;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * PrinEmployeeBadgeMessageBean
 * @author ataibi
 */
@MessageDriven(mappedName = "jms/hr_queue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", 
                              propertyValue = "jms/hr_queue"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", 
                              propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "destinationType",
                              propertyValue = "javax.jms.Queue")
})
public class PrinEmployeeBadgeMessageBean implements MessageListener {
    
    public PrinEmployeeBadgeMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
        System.out.println("Msg : " + message );
        // TextMessage, MapMessage, 
        if(message instanceof ObjectMessage){
            ObjectMessage om = (ObjectMessage)message; 
            Employee emp = om.getBody(Employee.class);
            System.out.println(String.format("Le Badge de Mr. %s %s à été imprimé ",
                    emp.getFirstName(),  emp.getLastName()));
        } else{
            System.out.println(message);
        }   
        } catch (Exception e) {
            // ....
        }
        
                
    }
    
}
