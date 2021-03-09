/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwansyy.ticketview.controller;

import com.iwansyy.ticketview.entity.Employee;
import com.iwansyy.ticketview.serviceImplement.loginServicesImplement;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author iwansy
 */
@Controller
public class loginController {

    @Autowired
    private loginServicesImplement loginServices;

    @RequestMapping()
    public String home(HttpSession session, Model model) {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginRequest", method = RequestMethod.POST)
    public String loginUser(
            @RequestParam("email") String email, 
            @RequestParam("password") String password,
            Model model) 
    {
        Employee emp = new Employee(email, password);
        if (loginServices.getAuthSingIn(email, password)) {
            Employee employee = loginServices.getAuthBy(email, password);
            return "redirect:/employee";
        }
        return "redirect:login";
    }

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
}
