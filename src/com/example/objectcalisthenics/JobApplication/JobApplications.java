package com.example.objectcalisthenics.JobApplication;

import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.User.ID;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by atzubeli on 5/22/14.
 */
public class JobApplications implements RecordedMap<ApplicationDetails> {

    private HashMap<ID, ApplicationsList> applications = new HashMap<ID, ApplicationsList>();


    public void createKey(ID jobId){

        applications.put(jobId, new ApplicationsList());

    }

    public void add(ID jobId, ApplicationDetails details){

        ApplicationsList list = applications.get(jobId);

        list.addApplication(details);

    }

    public void remove(ID jobId, ApplicationDetails details){


        ApplicationsList list = applications.get(jobId);

        list.removeApplication(details);

    }

    public Collection readAll(ID jobId){

        ApplicationsList list = applications.get(jobId);

        return list.readAll();
    }

    public Collection<ApplicationDetails> getByDate(ID jobId, Date date){

        ApplicationsList list = applications.get(jobId);

        return list.getByDate(date);

    }

}
