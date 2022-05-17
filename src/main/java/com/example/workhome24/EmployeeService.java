package com.example.workhome24;

public interface EmployeeService {
 Employee add(String firstName, String lastName);
 Employee remove(String firstName, String lastName);
 Employee find(String firstName, String lastName);

}
