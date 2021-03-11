/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.serviceImplement;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author iwansy
 */

@Service
@Transactional
public class loginServicesImplement {
}
    
    
//
//    public boolean getAuthSingIn(String email, String password){
//        Employee employee = repo.getByAuth(email, password);
//        if (email == null && password == null){
//            return false;
//        } else {
//            return employee.getEmail().equals(email) && employee.getPassword().equals(password);
//        }
//    }
//}

//public boolean getAuthSingIn(String email, String password){
//        Employee employee = repo.getByAuth(email, password);
//        if (email == null && password == null){
//            return false;
//        } else {
//            return employee.getEmail().equals(email) && employee.getPassword().equals(password);
//        }
//    }
//
//    @Override
//    public Employee getAuthBy(String email, String password) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}



//    public boolean getAuthLogin(String email, String password) {
//        String emp = repo.getAuthLogin(email, password);
//        if (email == null && password == null) {
//            return false;
//        } else {
//            if (emp.getEmail().equals(email) && emp.getPassword().equals(password)) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }
