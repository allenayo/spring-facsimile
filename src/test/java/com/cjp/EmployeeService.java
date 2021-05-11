package com.cjp;

public class EmployeeService {

    private UserService userService;

    public void work() {
        System.out.println(this.userService.getName() + " is a employee!");
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
