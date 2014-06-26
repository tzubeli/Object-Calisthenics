package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.collections.CollectionPrinter;
import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.jobs.Job;
import org.joda.time.LocalDate;

import java.util.HashMap;

/**
* Created by atzubeli on 5/22/14.
*/
public class JobApplications{

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

    public void getByJob(Job job, CollectionPrinter printer){

        ApplicationsList list = applications.get(job);

        list.printCollection(printer);
    }

    public void getByJobAndDate(Job job, LocalDate date, CollectionPrinter printer){

        ApplicationsList list = applications.get(job);

        ApplicationsList resultList = list.filteredByDate(date);

        resultList.printCollection(printer);

    }

    public void getByDate(LocalDate date, CollectionPrinter printer){

        ApplicationsList apps = new ApplicationsList();

        for (Job job : applications.keySet())
        {
            ApplicationsList list = applications.get(job);

            apps = apps.combinedWith(list.filteredByDate(date));
        }

        apps.printCollection(printer);
    }

}
