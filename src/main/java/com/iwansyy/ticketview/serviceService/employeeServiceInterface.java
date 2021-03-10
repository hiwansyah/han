package com.iwansyy.ticketview.serviceService;

import com.iwansyy.ticketview.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface employeeServiceInterface {
    void save(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeById(String id);
    void update(Employee employee);
    void delete(Employee employee);
    void deleteById(String id);
   //Employee getByMailPassword(String email, String password); 
    Employee getByMail(String email); 
    
}
