/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.controller;

import com.iwansyy.ticketview.entity.Employee;
import com.iwansyy.ticketview.serviceImplement.employeeServicesImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author iwansy
 */

public class EmployeeControllers {
    
    @Autowired
    private employeeServicesImplement servicesImplement;

    @GetMapping("/thisisHome")
    public String home() {
        System.out.println("Running Index");
        System.out.println("Running Index");
        return "index";
    }

    @RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {

        Iterable<Employee> employee = servicesImplement.getAllEmployee();
        

        for (Employee employeList : employee) {
            System.out.println("employees Email = " + employeList.getEmployeeId()); 
            System.out.println("employees phone number = " + employeList.getEmployeeName());
            System.out.println("employees phone number = " + employeList.getEmail());
            System.out.println("employees phone number = " + employeList.getPassword());

            System.out.println("employees firstname = " + employeList.getEmployeeName());
            System.out.println("employees lastname = " + employeList.getPassword());

        }
        model.addAttribute("employeList", employee);
        return "view/viewAllEmployee";
    }

    @RequestMapping(value = "/searchPageEmployee", method = RequestMethod.GET)
    public String searchEmployeeByFirstname() {
        return "view/searchPageFirstname";
    }

//    @RequestMapping(value = "/selectByName", method = RequestMethod.POST)
//    public String selectByName(Model model,
//            @RequestParam(value = "firstname", required = false) String nama) {
//        
//        Iterable<Employee> employee = servicesImplement.getEmployeById(nama);
//
//        model.addAttribute("listEmployee", employee);
//        return "view/viewSearchFirstname";
//    }
//    
    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String homemanager() {
        
        System.out.println("homeadmin");
        return "index";
    }
    @RequestMapping(value = "/developer", method = RequestMethod.GET)
    public String homeemployee() {
        System.out.println("homedeveloper");
        
        return "index";
    }
    
}
