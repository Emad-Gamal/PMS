/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iplytics.challenge.project;

import iplytics.challenge.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emad
 */
public class ProjectController {
    
    public List<Project> getAllProjectsFromFile(String fileName){
        List<Project> projects = new ArrayList<>();
        List<String[]>projectsRecords = Utils.readCSV(fileName);
        projectsRecords.remove(0);
        projectsRecords.forEach((record)->{
            Project newProject = new Project();
            boolean duplicate = false;
            newProject.setName(record[0]);
            newProject.setStartDate(Utils.getDateFromUnknownFormat(record[1]));
            if(newProject.getStartDate()==null)
                return;
            newProject.setBuffer(Utils.checkStringInteger(record[2]));
            for(Project pro: projects){
                if(pro.getName().equals(newProject.getName()))
                    duplicate = true;
            }
            if(!duplicate)
                projects.add(newProject);   
        });
        return projects;    
    }

    
    
}
