package test.serviceribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.serviceribbon.service.HelloService;

@RestController
@RequestMapping("/")
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hhhh")
    public  String test (){
        return "test";
    }
    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }
}
