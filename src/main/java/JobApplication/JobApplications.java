package main.java.JobApplication;

import main.java.Collections.ListWrapper;
import main.java.Collections.RecordedMap;
import main.java.Jobs.Job;

import java.util.Date;
import java.util.HashMap;

/**
* Created by atzubeli on 5/22/14.
*/
public class JobApplications implements RecordedMap<Job, JobApplication> {

    private HashMap<Job, ApplicationsList> applications = new HashMap<>();



    public void createKey(Job job){

        if (!applications.containsKey(job))

            applications.put(job, new ApplicationsList());

    }

    public void add(Job job, JobApplication application){

        createKey(job);

        ApplicationsList list = applications.get(job);

        list.addApplication(application);

    }

    public void remove(Job job, JobApplication application){


        ApplicationsList list = applications.get(job);

        list.removeApplication(application);

    }

    public ListWrapper readAll(Job job){

        return applications.get(job);


    }

    public ApplicationsList getByDate(Job job, Date date){

        ApplicationsList list = applications.get(job);

        return new ApplicationsList(list.getByDate(date));  //TODO wrap this

    }

}
