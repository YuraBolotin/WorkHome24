package com.example.workhome24;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    Employee[] employees = new Employee[3];


    @Override
    public String add(String firstName, String lastName) {
        int count = 0;
        Employee emp = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {

            if (employees[i] != null && employees[i].equals(emp)) {
                throw new IsEmployeeException();
            } else if (count > employees.length) {
                throw  new EmployeeIndexOutOfBoundsException();
            } else if (employees[i] != null) {
                count++;
            } else {
                employees[count] = new Employee(firstName, lastName);
            }
            }
            return "Сотрудник " + employees[count].getFirstName() + " " + employees[count].getLastName();

        }


    @Override
    public String remove(String firstName, String lastName) {

        Employee emp = new Employee(firstName, lastName);

        for (int i = 0; i < employees.length; i++) {
             if (employees[i] != null && employees[i].equals(emp)) {
                employees[i] = null;
                break;
            } else if (i == employees.length - 1){ throw new NotFoundException();
            }
        }
        return "Сотрудник " + emp.getFirstName() + " " + emp.getLastName();
    }

    @Override
    public String find(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(emp)) {
                               break;
            } else if (i == employees.length - 1){ throw new NotFoundException();

            }
        }
        return "Сотрудник " + emp.getFirstName() + " " + emp.getLastName();
    }
}
