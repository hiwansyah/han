package com.iwansyy.ticketview.repository;

import com.iwansyy.ticketview.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends CrudRepository<Employee, String> {

//    @Query(value = "SELECT * FROM employee WHERE email = ?1 and password = ?2 ", nativeQuery = true)
//    public Employee getByMailPassword(@Param(value = "email") String email, @Param(value = "password") String password);
    
//    @Query(value = "SELECT * FROM employee WHERE email = ?1", nativeQuery = true)
       @Query(value = "SELECT * FROM Employee WHERE email = :email", nativeQuery = true)
        public Employee getByMail(String email);
    
    
    

}
//    
//   @Query(value = "select * from employee where email = ?1 and password = ?2 ", nativeQuery = true)
//   public Employee getByAuth(@Param(value = "email") String email , @Param(value = "password") String password);
//   
//    private static List<Employee> employees;
//     @Query(value = "SELECT * FROM employees WHERE first_name like %?1%", nativeQuery = true)
//    public Iterable<Employees> searchByName(String keyword);
//    
//    public static Employee checkLogin(Employee employee){
//        for (Employee e : employees){
//            if(e.getEmail().equals(employee.getEmail()) && e.getPassword().equals(employee.getPassword())){
//                
//            }
//        }
//    }
    