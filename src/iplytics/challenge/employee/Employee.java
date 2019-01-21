/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iplytics.challenge.employee;

import iplytics.challenge.project.Project;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emad
 */
public class Employee {
    
    private String firstName;
    private String lastName;
    private Employee supervisor;
    private List<Project> assignedProjects;

    public Employee() {
        this.assignedProjects = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }
    
    public void addProject(Project p){
        if(assignedProjects.size()<2)
            assignedProjects.add(p);
        else
            System.out.println("No more projects can be assigned");

    }

    public List<Project> getAssignedProjects() {
        return assignedProjects;
    }

    public void setAssignedProjects(List<Project> assignedProjects) {
        this.assignedProjects = assignedProjects;
    }
}
