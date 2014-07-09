package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobApplications.JobApplications;
import com.theladders.avital.oc.print.AggregateCount;
import com.theladders.avital.oc.print.AggregateCountPrinter;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.ListPrinter;
import com.theladders.avital.oc.user.Employer;
import org.joda.time.DateTime;


import java.util.*;

/**
 * Created by atzubeli on 6/26/14.
 */
public class Jobs {

private Map<Employer, JobApplications> postedJobs = new HashMap<>();

    public void createEmployer(Employer employer) {

        if (! postedJobs.containsKey(employer))

            postedJobs.put(employer, new JobApplications());
    }

    public void addJob(Employer employer, Job job){

       createEmployer(employer);

       JobApplications applications = postedJobs.get(employer);

       applications.createJobKey(job);
    }

    public void addApplication(Job job, JobApplication application){

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            applications.addApplication(job, application);

            }
    }

    public void printAllJobsByEmployer(Employer employer, ListPrinter printer){

        JobApplications applications = postedJobs.get(employer);

        applications.printAllJobsByEmployer(printer);

    }

    public void printAllApplications(ApplicationsPrinter printer){

        ApplicationsList resultList = new ApplicationsList();

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            ApplicationsList list = applications.getAllApplications();

            resultList = resultList.combinedWith(list);

            }
        resultList.printAppList(printer);

    }

    public void getByDate(DateTime date, ApplicationsPrinter printer){

        ApplicationsList resultList = new ApplicationsList();

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            ApplicationsList list = applications.filterByDate(date);

            resultList = resultList.combinedWith(list);

        }
        resultList.printAppList(printer);
    }

    public void printAllApplicationsByEmployer(Employer employer, ApplicationsPrinter printer){

        JobApplications applications = postedJobs.get(employer);

        ApplicationsList list = applications.getAllApplications();

        list.printAppList(printer);

    }

    public void printByJob(Employer employer, Job job, ApplicationsPrinter printer){

        JobApplications applications = postedJobs.get(employer);

        applications.printByJob(job, printer);

    }

    public void printByJobAndDate(Employer employer, Job job, DateTime date, ApplicationsPrinter printer){

        JobApplications applications = postedJobs.get(employer);

        applications.printByJobAndDate(job, date, printer);

    }

    public void printByDateAndEmployer(Employer employer, DateTime date, ApplicationsPrinter printer){

        JobApplications applications = postedJobs.get(employer);

        ApplicationsList newList = applications.filterByDate(date);

        newList = newList.sortList();

        newList.printAppList(printer);

    }

    public void printApplicationCountByEmployerAndJob(AggregateCountPrinter printer){

        AggregateCount resultList = new AggregateCount();

        for (Employer employer : postedJobs.keySet()) {

            JobApplications applications = postedJobs.get(employer);

            AggregateCount list = applications.getAggregateCount();

            resultList = resultList.combinedWith(list);
        }

        resultList.printCount(printer);
    }

    //for testing only
    public int numberOfApplications(){

        ApplicationsList resultList = new ApplicationsList();

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            ApplicationsList list = applications.getAllApplications();

            resultList = resultList.combinedWith(list);

        }
        return resultList.size();
    }

    //for testing only
    public int numberOfJobs(){

        int numberOfJobs =0;

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            numberOfJobs += applications.numberOfJobs();

        }
        return numberOfJobs;
    }


}

