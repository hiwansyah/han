package com.iwansyy.ticketview.serviceService;

import com.iwansyy.ticketview.entity.Employee;

public interface employeeServiceInterface {
    void save(Employee employee);
    Iterable<Employee> getAllEmployee();
    Employee getEmployeById(String id);
    void update(Employee employee);
    void delete(Employee employee);
    void deleteById(String id);
    void getAuthLogin();
}
