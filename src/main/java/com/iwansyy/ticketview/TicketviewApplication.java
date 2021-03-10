package com.iwansyy.ticketview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

//
@SpringBootApplication
//@RestController
public class TicketviewApplication {
    
//    @Autowired
//    private EmailService service;
//    
//    @PostMapping("/sendingEmail")
//    public  MailResponse sendEmail(@RequestBody MailRequest request) {
//        Map<String, Object> model = new HashMap<>();
//        model.put("Name", request.getName());
//        model.put("Location", "Indonesia");
//        return service.sendMail(request, model);
//    }
//    
    
    public static void main(String[] args) {
        SpringApplication.run(TicketviewApplication.class, args);
    }
}