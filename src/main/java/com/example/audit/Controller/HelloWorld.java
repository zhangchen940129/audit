package com.example.audit.Controller;

import com.example.audit.Model.HelloModel;
import com.example.audit.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorld {
    private final HelloService HelloService;

    @Autowired
    public HelloWorld(com.example.audit.Service.HelloService HelloService) {
        this.HelloService = HelloService;

    }

    @RequestMapping("/")
    public String Index() {
        return "Hello World";
    }

    @RequestMapping("/list")
    public List<HelloModel> List() {
        return HelloService.selectAll();
    }
}