/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.controller;

import com.iwansyy.ticketview.entity.Employee;
import com.iwansyy.ticketview.serviceImplement.employeeServicesImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author iwansy
 */
@Controller
public class employeeController {

    @Autowired
    private employeeServicesImplement employeeServices;

    @GetMapping("/employee")
    public String viewEmployeePage(Model model) {
        model.addAttribute("employeeList", employeeServices.getAllEmployee());
        return "employee";
    }

    @GetMapping("employeeAdd")
    public String viewNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        //System.out.println(model.addAttribute("employee", employee));
        model.addAttribute("employee", employee);
        return "employeeAdd";
    }

    @PostMapping("employeeSave")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
       //System.out.println(employee.getClass());
        this.employeeServices.save(employee);
        return "employee";
    }

//    @RequestMapping(value = "employeeUpdate/{id}", method = RequestMethod.POST)
//    public String showUpdateForm(
//            @RequestParam(value = "employeeId", required = false) String employeeId,
//            @RequestParam(value = "employeeName", required = false) String employeeName,
//            @RequestParam(value = "password", required = false) String password
//    ) {
//        Employee employee = new Employee(employeeId, employeeName, password);
//        //System.out.println(employeeId);
//        employeeServices.save(employee);
//        return "redirect:/employee";
//    }
    
    @RequestMapping(value = "employeeUpdate/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee>  employeeUpdate(@PathVariable("id") String id){
        try {
            return new ResponseEntity<Employee>(employeeServices.getEmployeById(id), HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
        }
    }
    
    
//    
//    @GetMapping("/employeeUpdate/{id}")
//    public String shaowFormUpdate(@PathVariable(value = "id") String id, Model model){
//        Employee employee = employeeServices.getEmployeById(id);
//        model.addAttribute("employee", employee);
//        //System.out.println(id);
//        //System.out.println(employee.getEmployeeId());
//        return "employee";
//    }
//    
    @GetMapping("/employeeDelete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") String id){
        //System.out.println(id);
        this.employeeServices.deleteById(id);
        return "redirect:/employee";
    }
   
}
