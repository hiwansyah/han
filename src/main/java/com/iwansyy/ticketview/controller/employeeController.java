/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.controller;

import com.iwansyy.ticketview.entity.Employee;
import com.iwansyy.ticketview.serviceImplement.employeeServicesImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    
    @RequestMapping(value = "/employeeAdd", method = RequestMethod.POST)
    public String showInsertForm(
            @RequestParam(value = "employeeId", required = false) String employeeId,
            @RequestParam(value = "employeeName", required = false) String employeeName,
            @RequestParam(value = "password", required = false) String password
    ) {
        Employee employee = new Employee(employeeId, employeeName, password);
        //System.out.println(employeeId);
        employeeServices.save(employee);
        return "redirect:/employee";}

    @GetMapping("/employee")
    public String viewEmployeePage(Model model) {
        model.addAttribute("employeeList", employeeServices.getAllEmployee());
//        System.out.println(model.addAllAttributes(employeeServices.getAllEmployee()));

        return "employee";
    }

//    @GetMapping("/employee")
//    public String viewEmployeePage(@RequestParam(value = "employeeId") String id, @RequestModel model) {
//        model.addAttribute("employeeList", employeeServices.getAllEmployee());
//        
//        Employee employeecrud = new Employee();
//        model.addAttribute("addEmployee", employeecrud);
//        
//        
//        return "employee/employee";
//    }

    @PostMapping("/employeeAdd")
    public String viewNewEmployeeForm(@ModelAttribute("addEmployee") Employee employee) {
        this.employeeServices.save(employee);
        return "redirect:/employee";
    }

    @PostMapping("/employeeSave")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //System.out.println(employee.getClass());
        this.employeeServices.save(employee);
        return "employee/employeeAdd";

//        return "employee";

    }

    @RequestMapping(value = "employeeUpdate/{id}", method = RequestMethod.POST)
    public String showUpdateForm(
            @RequestParam(value = "employeeId", required = false) String employeeId,
            @RequestParam(value = "employeeName", required = false) String employeeName,
            @RequestParam(value = "password", required = false) String password
    ) {
        Employee employee = new Employee(employeeId, employeeName, password);
        System.out.println(employee.getEmployeeId().equals(employeeId));
        employeeServices.save(employee);
        return "";
    }

    @GetMapping("/employeeDelete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") String id) {
        //System.out.println(id);
        this.employeeServices.deleteById(id);
        return "redirect:/employee";
    }

    //######
    //SPRING SECURITY
    //######
    
    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String homeadmin() {
        System.out.println("homeadmin");
        return "employee";
    }

    @RequestMapping(value = "/developer", method = RequestMethod.GET)
    public String homedev() {
        System.out.println("homedev");
        return "employee";
    }
    
    

//    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
//    public String loginPage() {
//        return "login";
//    }
//    
//    @RequestMapping(value = "/manager", method = RequestMethod.GET)
//    public String homemanager() {
//        
//        System.out.println("homemanager");
//        return "index";
//    }
//    @RequestMapping(value = "/employee", method = RequestMethod.GET)
//    public String homeemployee() {
//        System.out.println("homeemployee");
//        
//        return "index";
//    }
//    
    //    @RequestMapping(value = "/employeeUpdate/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Employee>  employeeUpdate(@PathVariable("id") String id){
//        try {
//            return new ResponseEntity<Employee>(employeeServices.getEmployeById(id), HttpStatus.OK);
//            
//        } catch (Exception e) {
//            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
//        }
//    }
//    
//    
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
//    public class loginController {

//    @Autowired
//    private loginServicesImplement loginServices;
//
//    @RequestMapping()
//    public String home(HttpSession session, Model model) {
//        return "redirect:/login";
//    }
//
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//    
//    

//    @RequestMapping(value = "/loginRequest", method = RequestMethod.POST)
//    public String loginUser(
//            @RequestParam("email") String email, 
//            @RequestParam("password") String password,
//            Model model) 
//    {
//        if (loginServices.getAuthSingIn(email, password)) {
//            Employee employee = loginServices.getAuthBy(email, password);
//            String name = employee.getEmployeeName();
//            System.out.println(name);
//            return "redirect:/employee";
//        }
//        return "redirect:/login";
//    }

//    @GetMapping("/login")
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView("home", "login", new Employee());
//        System.out.println(modelAndView.getModelMap());
//        return modelAndView;
//    }
//    @GetMapping("/employee")
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView("home", "login", new Employee());
//        return modelAndView;
//    }
//
//    @PostMapping(value = "/login")
//    public ModelAndView getAuthLogin(@ModelAttribute("login") Employee employee) {
//        Employee employee1 = repo.getAuthLogin()
//    }
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String getAuthLogin(
//            @RequestParam(value = "email", required = false) String email,
//            @RequestParam(value = "password", required = false) String password
//    ) {
//        return null;
//    }
//}

}
