/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iplytics.challenge.task;

import iplytics.challenge.Utils;
import iplytics.challenge.employee.Employee;
import iplytics.challenge.project.Project;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emad
 */
public class TaskController {
    
    public List<Task> getAlltasks(String fileName){
        
        List<Task> tasks = new ArrayList<>();
        List<String[]>tasksRecords = Utils.readCSV(fileName);
        tasksRecords.remove(0);
        
        tasksRecords.forEach((record)->{
            Task newTask = new Task();
            boolean duplicate = false;
            newTask.setName(record[0]);
            newTask.setDescreption(record[1]);
            if(record.length==3)
                newTask.setEstimatedHours(Utils.checkStringInteger(record[2]));
            for(Task task: tasks){
                if(task.getName().equals(newTask.getName()))
                    duplicate = true;
            }
            if(!duplicate)
                tasks.add(newTask);
        });
        return tasks;
    }
    
}
