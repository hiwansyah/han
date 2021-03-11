/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.repository;

import com.iwansyy.ticketview.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iwansy
 */

@Repository
public interface UserRepository extends CrudRepository<Users, String>{
    @Query(value = "Select * From Employee Where email =?1", nativeQuery = true)
    public Users findUserByEmail(String email);
}
