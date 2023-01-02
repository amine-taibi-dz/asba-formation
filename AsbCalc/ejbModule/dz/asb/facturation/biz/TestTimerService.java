package dz.asb.facturation.biz;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class TestTimerService {

	@Schedule( hour = "*",  minute = "*",second = "*/10",persistent = false,info = "Affiche le temps !!") //0,10,20,30
    public void callMe(){
        System.out.println("Timer is Here : " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
    }
}
