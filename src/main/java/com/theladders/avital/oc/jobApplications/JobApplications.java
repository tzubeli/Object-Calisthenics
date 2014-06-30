package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.print.PrintToCSVReport;
import com.theladders.avital.oc.print.PrintToConsole;
import org.joda.time.LocalDate;

import java.util.*;

/**
* Created by atzubeli on 5/22/14.
*/
public class JobApplications{

    private Map<Job, ApplicationsList> applications = new HashMap<>();


    public void createKey(Job job){

        if (!applications.containsKey(job))

            applications.put(job, new ApplicationsList());
    }

    public boolean contains(Job job){

        return applications.containsKey(job);
    }

    public void add(Job job, JobApplication application){

        createKey(job);

        ApplicationsList list = applications.get(job);

        list.addApplication(application);

    }

    public JobList getAllJobsByEmployer(){

        Set<Job> jobSet = applications.keySet();

        List<Job> jobList = new ArrayList<>(jobSet);

        return new JobList(jobList);

    }

    public ApplicationsList getByJob(Job job){

        ApplicationsList list = applications.get(job);

        return list;
    }

    public ApplicationsList getByJobAndDate(Job job, LocalDate date){

        ApplicationsList list = applications.get(job);

        ApplicationsList resultList = list.filteredByDate(date);

        return resultList;

    }

    public ApplicationsList getByDate(LocalDate date){

        ApplicationsList resultList = new ApplicationsList();

        for (Job job : applications.keySet())
        {
            ApplicationsList list = applications.get(job);

            resultList = resultList.combinedWith(list.filteredByDate(date));
        }

        return resultList;
    }

    public ApplicationsList getAllApplications(){

        ApplicationsList resultList = new ApplicationsList();

        for (Job job : applications.keySet())
        {
            ApplicationsList list = applications.get(job);

            resultList = resultList.combinedWith(list);
        }
        return resultList;

    }

    public int numberOfJobs(){

        return applications.size();
    }

}
