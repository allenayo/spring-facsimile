package com.cjp;

public class UserService {

    private String name;

    public void sayHello() {
        System.out.println(this.name + ", Hello World!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
