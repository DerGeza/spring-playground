package com.gezakonczos.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private MessageSource messageSource;

    @GetMapping(path="/hello-word")
    public String helloWord(){
        return "Hello World REST";
    }

    @GetMapping(path="/hello-word-bean")
    public HelloWordBean helloWordBean(){
        return new HelloWordBean("Hello World");
    }

    @GetMapping(path="/hello-word/path-variable/{name}")
    public HelloWordBean helloWordPathVariable(@PathVariable String name){
        return new HelloWordBean("Hello World " + name);
    }

    @GetMapping(path="/hello-word-internationalized")
    public String helloWordinternationalized(){

        //gives back locale from context header
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message", locale);
    }
}
