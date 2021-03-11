/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.serviceImplement;

import com.iwansyy.ticketview.entity.Employee;
import com.iwansyy.ticketview.repository.EmployeeRepositorys;
import com.iwansyy.ticketview.serviceService.EmployeeServiceInterfacesOne;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author iwansy
 */
public class EmployeeServiceImplements implements EmployeeServiceInterfacesOne{

    @Autowired
    private EmployeeRepositorys repo;
    
    @Override
    public Iterable<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public Iterable<Employee> searchByFirstName(String firstname) {
        return repo.searchByEmail(firstname);
    }
    
}
