package com.controller;

import com.service.ReachedContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/confi")
public class ContactsDeleteAll {


    @Autowired
    ReachedContactService service;


    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        service.deleteAll();
    }
}
