/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iplytics.challenge.project;

import iplytics.challenge.task.Task;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Emad
 */
public class Project {
    
    private String name;
    private Date startDate;
    private Date endDate;
    private int buffer;
    private List<Task> tasks;
    private float totalTasksHours;

    public Project() {
        this.totalTasksHours = 0;
        tasks = new ArrayList<>();
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public void setEndDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.startDate);
        c.add(Calendar.DATE, (int) Math.ceil(this.totalTasksHours/8));
        this.endDate = c.getTime();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public float getTotalTasksHours() {
        return totalTasksHours;
    }

    public void setTotalTasksHours(float totalTasksHours) {
        this.totalTasksHours = totalTasksHours;
    }
    
    public void addNewtask(Task newTask){
        tasks.add(newTask);
        this.totalTasksHours+= newTask.getEstimatedHours();       
        setEndDate();
    }
    
    public void deleteTask(Task task){
        this.tasks.remove(task);
        this.totalTasksHours -= task.getEstimatedHours();
        setEndDate();
    }
    
    public void displayTasks(){
        this.tasks.forEach((task) -> {
            System.out.println("Name: "+task.getName());
            System.out.println("Descreption: "+task.getDescreption());
            System.out.println("----------------------------------------");
        });
    }
    
}