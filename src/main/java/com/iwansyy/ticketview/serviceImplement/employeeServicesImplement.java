package com.iwansyy.ticketview.serviceImplement;

import com.iwansyy.ticketview.entity.Employee;
import com.iwansyy.ticketview.repository.employeeRepository;
import com.iwansyy.ticketview.serviceService.employeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class employeeServicesImplement implements employeeServiceInterface {

    @Autowired
    private employeeRepository repo;
    
    @Autowired
    employeeServicesImplement esi;
    
    
    
    public void save(Employee employee) {
        repo.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return (List<Employee>) repo.findAll();
    }


    public void update(Employee employee) {
        repo.save(employee);
    }

    public void delete(Employee employee) {
        repo.delete(employee);
    }

    public void deleteById(String id) {
       repo.deleteById(id);
    }

    @Override
    public Employee getByMail(String username) {
             return repo.getByMail(username);
    }

    @Override
    public Employee getEmployeById(String id) {
        Optional<Employee> optional = repo.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        } else {
            System.out.println("nof found id"+id);
        }
        return employee;
    }
    
}
