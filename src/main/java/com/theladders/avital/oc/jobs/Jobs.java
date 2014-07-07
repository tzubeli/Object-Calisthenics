package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobApplications.JobApplications;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.print.AggregateCount;
import com.theladders.avital.oc.print.AggregateCountPrinter;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.ListPrinter;
import com.theladders.avital.oc.user.Employer;
import javafx.application.Application;
import org.joda.time.LocalDate;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

            if (applications.contains(job)){

                applications.addApplication(job, application);

                break;
            }
        }
    }

    public void getAllJobsByEmployer(Employer employer, ListPrinter printer){

        JobApplications applications = postedJobs.get(employer);

        applications.getAllJobsByEmployer(printer);

    }

    public void getAllApplications(ApplicationsPrinter printer){

        ApplicationsList resultList = new ApplicationsList();

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            ApplicationsList list = applications.getAllApplications();

            resultList = resultList.combinedWith(list);

            }
        resultList.printAppList(printer);

    }

    public void getByDate(LocalDate date, ApplicationsPrinter printer){

        ApplicationsList resultList = new ApplicationsList();

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            ApplicationsList list = applications.getByDate(date);

            resultList = resultList.combinedWith(list);

        }
        resultList.printAppList(printer);


    }


    public void getAllApplicationsByEmployer(Employer employer, ApplicationsPrinter printer){

        JobApplications applications = postedJobs.get(employer);

        ApplicationsList list = applications.getAllApplications();

        list.printAppList(printer);

    }

    public void getByJob(Employer employer, Job job, ApplicationsPrinter printer){

        JobApplications applications = postedJobs.get(employer);

        applications.getByJob(job, printer);

    }

    public void getByJobAndDate(Employer employer, Job job, LocalDate date,  ApplicationsPrinter printer){

        JobApplications applications = postedJobs.get(employer);

        applications.getByJobAndDate(job, date, printer);

    }

    public void getByDateAndEmployer(Employer employer, LocalDate date, ApplicationsPrinter printer){

        JobApplications applications = postedJobs.get(employer);

        applications.getByDate(date).printAppList(printer);

    }

    public int numberOfApplications(){

        ApplicationsList resultList = new ApplicationsList();

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            ApplicationsList list = applications.getAllApplications();

            resultList = resultList.combinedWith(list);

        }
        return resultList.size();
    }

    public int numberOfJobs(){

        int numberOfJobs =0;

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            numberOfJobs += applications.numberOfJobs();

        }
        return numberOfJobs;
    }



    public void getApplicationCountByEmployerAndJob(AggregateCountPrinter printer){

        AggregateCount resultList = new AggregateCount();

        for (Employer employer : postedJobs.keySet()) {

            JobApplications applications = postedJobs.get(employer);

            AggregateCount list = applications.getAggregateCount();

            resultList = resultList.combinedWith(list);

        }

         resultList.printCount(printer);

    }



}

