/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iplytics.challenge;

import iplytics.challenge.employee.Employee;
import iplytics.challenge.project.Project;
import iplytics.challenge.task.Task;
import java.util.Scanner;

/**
 *
 * @author Emad
 */
public class IplyticsChallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProjectManagementSystem managementSystem = new ProjectManagementSystem();
        
//        System.out.println("1: Assign task to project");
//        System.out.println("2: Assign project to employee");
//        System.out.println("3: Delete task");
//        System.out.println("4: Delete project");
//        System.out.println("5: Display all employees");
//        System.out.println("6: Display all tasks for a Project");
//        System.out.println("7: Display all days needed for a list of projects");
//        
        Scanner reader = new Scanner(System.in); 
        int n;
        //once finished
        Task selectedTask;
        Project selectedProject;
        Employee selectedEmployee;
        while(true){
            System.out.println("1: Assign task to project");
            System.out.println("2: Assign a project to employee");
            System.out.println("3: Delete task");
            System.out.println("4: Delete project");
            System.out.println("5: Display all employees");
            System.out.println("6: Display all tasks for a Project");
            System.out.println("7: Display all days needed for a list of projects");
            System.out.println("Enter a number: ");
            n = reader.nextInt();
            switch (n){
                case 1:
                    System.out.println("Choose a task");
                    managementSystem.showTasks();
                    n = reader.nextInt();
                    selectedTask = managementSystem.getTasks().get(n-1);
                    System.out.println("Choose a project to assign task in:");
                    managementSystem.showProjects();
                    n = reader.nextInt();
                    selectedProject = managementSystem.getProjects().get(n-1);
                    selectedProject.addNewtask(selectedTask);
                    selectedTask.setProject(selectedProject);
                    break;
                case 2:
                    System.out.println("Select project to be assigned to employee");
                    managementSystem.showProjects();
                    n = reader.nextInt();
                    selectedProject = managementSystem.getProjects().get(n-1);
                    System.out.println("Select employee to asign project");
                    managementSystem.showAllEmployees();
                    selectedEmployee = managementSystem.getEmployees().get(n-1);
                    managementSystem.addProjectToEmployee(selectedEmployee, selectedProject);
                    break;
                case 3:
                    managementSystem.showTasks();
                    n = reader.nextInt();
                    selectedTask = managementSystem.getTasks().get(n-1);
                    managementSystem.deleteTask(selectedTask);
                    break;
                case 4:
                    managementSystem.showProjects();
                    n = reader.nextInt();
                    selectedProject = managementSystem.getProjects().get(n-1);
                    managementSystem.deleteProject(selectedProject);
                    break;
                case 5:
                    managementSystem.showAllEmployees();
                    break;
                case 6:
                    System.out.println("Select a project");
                    managementSystem.showProjects();
                    n = reader.nextInt();
                    if(managementSystem.getProjects().get(n-1).getTasks().size()==0){
                        System.out.println("There is no ssigned tasks");
                        break;
                    }
                    managementSystem.getProjects().get(n-1).displayTasks();
                    break;
                case 7:
                    //"7: Display all days needed for a list of projects"
                    managementSystem.showProjects();
                    System.out.println("Enter toal number of slected projects ");
                    int length = reader.nextInt();
                    int [] numberOfProjects = new int[length];
                    for(int i=0; i<length; i++ ) {
                       numberOfProjects[i] = reader.nextInt();
                    }
                    int total = 0;
                    for(int x: numberOfProjects){
                        System.out.println("Total number if days in project :"
                                + managementSystem.getProjects().get(x-1).getName());
                        System.out.println(managementSystem.getProjects().get(x-1).getTotalTasksHours());
                        total += managementSystem.getProjects().get(x-1).getTotalTasksHours();
                    }
                    System.out.println("Total Projects Hours:  "+total);
                    break;

            }
        }
        
    }
    
}
