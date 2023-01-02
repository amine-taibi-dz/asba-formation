/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dz.acs.hr.rh.manger.biz;

import java.lang.reflect.Method;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author ataibi
 */
public class TimeInterceptor {
    
    
    @AroundInvoke
    public Object call(InvocationContext  ctx){
        Object res = null;
        Method meth = ctx.getMethod();
        long start = System.currentTimeMillis();
        try {
            res = ctx.proceed();            
        } catch (Exception e) {
            
        }
        
        long dur = System.currentTimeMillis() - start;
        System.out.println(meth.getName()+ " Duration : " + dur+" ms");
        return res;
    }
}
