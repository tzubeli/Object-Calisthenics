package com.example.objectcalisthenics.JobApplication;

import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.Jobs.Job;
import com.example.objectcalisthenics.User.ID;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
* Created by atzubeli on 5/22/14.
*/
public class JobApplications implements RecordedMap<Job, ApplicationDetails> {

    private HashMap<Job, ApplicationsList> applications = new HashMap<>();


    public void createKey(Job job){

        if (!applications.containsKey(job))

                applications.put(job, new ApplicationsList());

    }

    public void add(Job job, ApplicationDetails details){

        ApplicationsList list = applications.get(job);

        list.addApplication(details);

    }

    public void remove(Job job, ApplicationDetails details){


        ApplicationsList list = applications.get(job);

        list.removeApplication(details);

    }

    public Collection readAll(Job job){

        ApplicationsList list = applications.get(job);

        return list.readAll();
    }

    public Collection<ApplicationDetails> getByDate(Job job, Date date){

        ApplicationsList list = applications.get(job);

        return list.getByDate(date);

    }

}
