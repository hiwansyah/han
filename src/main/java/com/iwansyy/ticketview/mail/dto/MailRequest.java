/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.iwansyy.ticketview.mail.dto;

import lombok.Data;

/**
 *
 * @author iwansy
 */

@Data
public class MailRequest {
    private String name;
    private String to;
    private String from;
    private String subject;
    
}
