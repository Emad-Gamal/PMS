/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iplytics.challenge;

import iplytics.challenge.employee.Employee;
import iplytics.challenge.employee.EmployeeController;
import iplytics.challenge.project.Project;
import iplytics.challenge.project.ProjectController;
import iplytics.challenge.task.Task;
import iplytics.challenge.task.TaskController;
import java.util.List;

/**
 *
 * @author Emad
 */
public class ProjectManagementSystem {
    
    private List<Project> projects;
    private List<Task> tasks;
    private List<Employee> employees;

    public ProjectManagementSystem() {
        
        TaskController taskController = new TaskController();
        ProjectController projectController = new ProjectController();
        EmployeeController employeeController = new EmployeeController();
        
        tasks = taskController.getAlltasks("tasks.csv");
        projects = projectController.getAllProjectsFromFile("projects.csv");
        employees = employeeController.getAllEmployeesFromFile("employees.csv");
    }
    
    public void showAllEmployees(){
        int i = 1;
        for(Employee emp:employees){ 
            System.out.println(i+": Employee Name: "+emp.getFirstName()+" "+emp.getLastName());
            System.out.println("----------------------------------------------");
            i++;
        };
    }
    public void showProjectTasks(Project project){
        int i=1;
        for(Task task:project.getTasks()){
            System.out.println(i+": "+task.getName());
            System.out.println(task.getDescreption());
            System.out.println("------------------------------");
        }
    }
    
    public void totalDaysForProjects(List<Project> projects){
        float total = 0;
        for(Project project: projects){
            total+= project.getTotalTasksHours();
        };
        System.out.println("Total Projects Time: "+((int)total/8)+" Days and "+Math.ceil(total%8)+" Hours");
    }
    
    public void addNewtaskToProject(Task selectedTask,Project selectedProject){
        selectedProject.addNewtask(selectedTask);
        selectedTask.setProject(selectedProject);
    }
    
    public void deleteTask(Task task){
        this.tasks.remove(task);
        this.projects.stream()
                .filter((pro)-> pro.getName().equals(task.getProject().getName()))
                .forEach((project)->project.deleteTask(task));
    }
    
    public void addProjectToEmployee(Employee selectedEmployee, Project selectedProject){
        selectedEmployee.addProject(selectedProject);
    }
    
    public void deleteProject(Project selectedProject){
        this.projects.remove(selectedProject);
        this.employees.forEach((emp) ->emp.getAssignedProjects().remove(selectedProject));
    }
    
    public void showProjects() {
        int choice = 1;
        for(Project project: projects){
            System.out.println(choice+": "+project.getName());
            choice++;
        }
    }
    
    public void showTasks() {
        int choice = 1;
        for(Task task: tasks){
            System.out.println(choice+": "+task.getName());
            choice++;
        }
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}