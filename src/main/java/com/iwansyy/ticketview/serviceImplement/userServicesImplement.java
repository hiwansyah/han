/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.serviceImplement;

import com.iwansyy.ticketview.entity.Employee;
import com.iwansyy.ticketview.entity.ThisUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

/**
 *
 * @author iwansy
 */
@Controller
public class userServicesImplement implements UserDetailsService{

    @Autowired
    employeeServicesImplement esi;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("load by username "+ username);
        ThisUser user = userConfig(username);
      User.UserBuilder builder = null;
      if (user != null){
          builder = org.springframework.security.core.userdetails.User.withUsername(username);
//          builder.password(user.getPassword());
//          builder.roles(user.getRoles());
      }
      else{
          System.out.println("user salah");
      }
       return builder.build();
    }
    
    private ThisUser userConfig(String username){
        String pwd = null, role = null;
        Employee emp = esi.getByMail(pwd);
        if (emp != null) {
            username = emp.getEmail();
            pwd = emp.getPassword();
            role = emp.getRoleId().getRoleName();
        } else {
            System.out.println("acces denied");
            System.out.println(pwd);
            System.out.println(role);
        }
        
    if (username.equalsIgnoreCase(username)){
//        return new ThisUser(username, pwd, role);
    }
    return null;
    }
    
}
