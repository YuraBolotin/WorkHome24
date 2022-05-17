package com.example.workhome24;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
   private final Employee[] employees = new Employee[3];


    @Override
    public Employee add(String firstName, String lastName) {
        int count = -1;
        boolean flag = false;
        Employee emp = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {


            if (employees[i] != null && employees[i].equals(emp)) {
                throw new IsEmployeeException();
            } else if ( employees[i] == null ) {
                if (flag == false) {
                    count = i;
                    flag = true;
                }
            }
        }
        if (count == -1) {
            throw new EmployeeIndexOutOfBoundsException();
        } else {

            employees[count] = new Employee(firstName, lastName);
        }
        return employees[count];

        }


    @Override
    public Employee remove(String firstName, String lastName) {

        Employee emp = new Employee(firstName, lastName);

        for (int i = 0; i < employees.length; i++) {
             if (employees[i] != null && employees[i].equals(emp)) {
                employees[i] = null;
                 return emp;
            }
        }
        throw new NotFoundException();
     }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(emp)) {
                return emp;
            }
        }
        throw new NotFoundException();
    }
}
