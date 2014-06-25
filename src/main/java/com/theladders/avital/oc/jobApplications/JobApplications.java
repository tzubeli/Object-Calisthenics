package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.collections.CollectionPrinter;
import com.theladders.avital.oc.collections.CollectionWrapper;
import com.theladders.avital.oc.collections.RecordedMap;
import com.theladders.avital.oc.jobs.Job;
import org.joda.time.LocalDate;

import java.util.ArrayList;
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

    public CollectionWrapper readAll(Job job){

        return applications.get(job);

    }

    public void getByJob(Job job, CollectionPrinter printer){

        applications.get(job).printCollection(printer);
    }

    public void getByJobAndDate(Job job, LocalDate date, CollectionPrinter printer){

        ApplicationsList list = applications.get(job);

        ArrayList<JobApplication> newList = new ArrayList<>();

        ApplicationsList resultList = new ApplicationsList(list.addApplicationsHavingDateOf(date, newList));

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
