package com.gezakonczos.webservices.restfulwebservices.helloworld;

public class HelloWordBean {
    @Override
    public String toString() {
        return "HelloWordBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;
    public HelloWordBean(String message) {
        this.message = message;
    }
}
