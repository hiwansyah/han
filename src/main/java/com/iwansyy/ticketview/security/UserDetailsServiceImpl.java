/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iwansyy.ticketview.security;

import com.iwansyy.ticketview.entity.Users;
import com.iwansyy.ticketview.serviceImplement.UserServiceImplements;
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
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UserServiceImplements usi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userConfig(username);
        User.UserBuilder builder =null;
        if(user != null){
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getPassword());
            builder.roles(user.getRoles());
        } else {
            System.out.println("User Salah");
        }
        return builder.build();
    }
    
    private Users userConfig(String username){
        String pwd = null, role = null;
        Users user = usi.findUserByEmail(username);
        if(user != null){
            user = usi.findUserByEmail(username);
            if(user != null) {
                username = user.getUsername();
                pwd = user.getPassword();
                role = user.getRoles();
            }else {
                System.out.println("ACCESS DENIED");
            }
        }
        if (username.equalsIgnoreCase(username)){
        return new Users(username, pwd, role);
                }
        return null;
    }


//    private Users userConfig(String username) {
//        String pwd = null, role = null;
//        Users user = (username);
//        if (user != null) {
//            user = usi.loadUserByUsername(username);
//            if (user != null) {
//                username = user.getUsername();
//                pwd = user.getPassword();
//                role = user.getRoles();
//            } else {
//                System.out.println("ACCESS DENIED");
//            }
//        }
//        if (username.equalsIgnoreCase(username)) {
//            return new Users(username, pwd, role);
//        }
//        return null;
//    }
    
    
    
    
    //    @Autowired
//    UserDetailsServiceImpl usi;
//    
    
    
    
    
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = userConfig(username);
//
//        User.UserBuilder builder = null;
//        if (user != null) {
//            builder = org.springframework.security.core.userdetails.User.withUsername(username);
//            builder.password(user.getPassword());
//            builder.roles(user.getRoles());
//        } else {
//            System.out.println("User Salah");
//        }
//        return builder.build();
//    }
//
  
}
