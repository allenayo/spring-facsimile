package com.cjp;

public class UserService {

    private String name;

    private EmployeeService employeeService;

    public void sayHello() {
        System.out.print("Hello! ");
        employeeService.work();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
