package com.iwansyy.ticketview.repository;

import com.iwansyy.ticketview.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface employeeRepository extends CrudRepository<Employee, String> {

}
