package dz.acs.hr.rh.manger.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.eclipse.persistence.oxm.annotations.XmlAccessMethods;

/**
 * Employee model   
 * @author ataibi
 */
@XmlRootElement(name = "employee")
@XmlType(name = "employee")

@Entity
@Table(name = "employees")
public class Employee implements  Serializable{

    @Column(name = "first_name")
    
    private String firstName;    
    @Column(name = "last_name")
    
    private String lastName;    
    
    private Long   matricule;    
    @Column(name = "date_recrute")
    
    private Long   enterYear;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer   id; 
    
    public Employee(String firstName, String lastName, Long matricule, Long enterYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matricule = matricule;
        this.enterYear = enterYear;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", matricule=" + matricule + ", enterYear=" + enterYear + '}';
    }
@XmlElement
    public String getFirstName() {
        return firstName;
    }
@XmlElement
    public String getLastName() {
        return lastName;
    }
@XmlElement
    public Long getMatricule() {
        return matricule;
    }
@XmlElement
    public Long getEnterYear() {
        return enterYear;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMatricule(Long matricule) {
        this.matricule = matricule;
    }

    public void setEnterYear(Long enterYear) {
        this.enterYear = enterYear;
    }
    
@XmlElement
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
}
