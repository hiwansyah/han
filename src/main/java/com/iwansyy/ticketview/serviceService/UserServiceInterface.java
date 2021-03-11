/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.serviceService;

import com.iwansyy.ticketview.entity.Users;

/**
 *
 * @author iwansy
 */

public interface UserServiceInterface {
    Users findUserByEmail(String email);
}
