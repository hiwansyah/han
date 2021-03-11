/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.serviceImplement;

import com.iwansyy.ticketview.entity.Users;
import com.iwansyy.ticketview.repository.UserRepository;
import com.iwansyy.ticketview.serviceService.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author iwansy
 */

@Service
public class UserServiceImplements implements UserServiceInterface{
    @Autowired
    private UserRepository repo;
    
    @Autowired
    UserServiceInterface userServiceInterface;
    
    @Override
    public Users findUserByEmail(String email) {
        return repo.findUserByEmail(email);
    }
   
}
