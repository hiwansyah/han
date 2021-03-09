/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.repository;

import com.iwansyy.ticketview.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iwansy
 */

@Repository
public interface loginRepository extends CrudRepository<Employee, String>{
    
    
    @Query(value = "select * from employee where email = ?1 and password = ?2 ", nativeQuery = true)
   public Employee getByAuth(
           @Param(value = "email") String email , 
           @Param(value = "password") String password);
   
    @Query(value = "select * from employee where email = ?1 and password = ?2 ", nativeQuery = true)
   public boolean getAuthLogin(
           @Param(value = "email") String email , 
           @Param(value = "password") String password);
//    
//    private static List<Employee> employees;
//    
//    
//    public static Employee checkLogin(Employee employee){
//        for (Employee e : employees){
//            if(e.getEmail().equals(employee.getEmail()) && e.getPassword().equals(employee.getPassword())){
//                
//            }
//        }
//    }
    
        
    
    
}
