package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.print.*;
import org.joda.time.DateTime;

import java.util.*;

/**
* Created by atzubeli on 5/22/14.
*/
public class JobApplications{

    private Map<Job, ApplicationsList> applications = new HashMap<>();

    public void addJob(Job job){

        if (!applications.containsKey(job))

            applications.put(job, new ApplicationsList());

    }

    public void addApplication(Job job, JobApplication application){

        if (applications.containsKey(job)) {

            ApplicationsList list = applications.get(job);

            list.addApplication(application);
        }
    }

    public void printAllJobsByEmployer(ListPrinter printer){

        List<Job> jobList = new ArrayList<>(applications.keySet());

        JobList newList =  new JobList(jobList);

        newList = newList.sortList();

        newList.printJobs(printer);

    }

    public void printByJob(Job job, ApplicationsPrinter printer){

        ApplicationsList list =  applications.get(job);

        list.printAppList(printer);
    }

    public void printByJobAndDate(Job job, DateTime date, ApplicationsPrinter printer){

        ApplicationsList list = applications.get(job);

        list = list.filteredByDate(date);

        list = list.sortList();

        list.printAppList(printer);

    }

    public ApplicationsList filterByDate(DateTime date){

        ApplicationsList resultList = new ApplicationsList();

        for (Job job : new ArrayList<>(applications.keySet()))
        {
            ApplicationsList list = applications.get(job);

            resultList = resultList.combinedWith(list.filteredByDate(date));
        }


        return resultList.sortList();
    }

    public ApplicationsList getAllApplications(){ //return list!

        ApplicationsList resultList = new ApplicationsList();

        for (Job job : new ArrayList<>(applications.keySet()))
        {
            ApplicationsList list = applications.get(job);

            resultList = resultList.combinedWith(list);
        }
        return resultList.sortList();

    }

    public int numberOfJobs(){

        return applications.size();
    }

    public AggregateCount getAggregateCount(){

        AggregateCount aggregateCount = new AggregateCount();

        for (Job job : applications.keySet())
        {
            ApplicationsList list = applications.get(job);

            aggregateCount.add(job, list.size());
        }

        return aggregateCount;

    }

}
