/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dz.acs.demo.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *CommandReader
 * @author ataibi
 */
@MessageDriven(mappedName = "jms/cmds")
public class CommandReader implements MessageListener {
    
    
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage)message;
        try {
            System.out.println("Message received from MDB: " + msg.getText());
        } catch (JMSException ex) {
            Logger.getLogger(CommandReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
