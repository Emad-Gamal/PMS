/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iplytics.challenge.employee;

import iplytics.challenge.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emad
 */
public class EmployeeController {
    
    public List<Employee> getAllEmployeesFromFile(String fileName){
        List<Employee> employees = new ArrayList<>();
        List<String[]>employeesRecords = Utils.readCSV(fileName);
        employeesRecords.remove(0);
        employeesRecords.forEach((record) -> {
            boolean duplicate = false;
            Employee newEmployee = new Employee();
            newEmployee.setFirstName(record[0]);
            newEmployee.setLastName(record[1]);
            if(record.length==3)
                newEmployee.setSupervisor(findSupervisor(employees, record[2]));
            
            for(Employee emp: employees){
                if(checkNameDuplicate(emp,newEmployee)){
                    duplicate = true;
                    break;
                }
            }
            if(!duplicate)
                employees.add(newEmployee);
        });
        return employees;
    }

    private boolean checkNameDuplicate(Employee emp, Employee emp2) {
        return emp.getFirstName().equals(emp2.getFirstName())&&emp.getLastName().equals(emp2.getLastName());
    }

    private Employee findSupervisor(List<Employee> employees, String svLastName) {
        for(Employee emp: employees){
            if(emp.getLastName() == null ? svLastName == null : emp.getLastName().equals(svLastName)){
                return emp;
            }
        }
        return null;
    }
    
}
