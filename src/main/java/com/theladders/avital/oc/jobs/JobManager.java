package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobApplications.ResultList;
import com.theladders.avital.oc.print.AggregateCountPrinter;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.ListPrinter;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;
import org.joda.time.DateTime;

/**
 * Created by atzubeli on 6/16/14.
 */
public class JobManager {

    private Jobs jobs;
    private ResultList resultList;


    public JobManager(Jobs jobs){

        this.jobs = jobs;
        resultList = new ResultList();

    }

    public void createEmployerKey(Employer employer){

        jobs.createEmployer(employer);
    }

    public Job postATSJob(Employer employer, Name name){

        Job job = new ATSJob(employer, name);

        jobs.addJob(employer, job);

        return job;

    }

    public Job postJReqJob(Employer employer, Name name){

        Job job = new JReqJob(employer, name);

        jobs.addJob(employer, job);

        return job;

    }

    public void addApplication(Job job, JobApplication application){

        resultList.addSuccess(job);
        jobs.addApplication(job, application);

    }

    public void addFailure(Job job){

        resultList.addFailure(job);

    }

    public void printResultList(ListPrinter printer){

        resultList.printResultList(printer);

    }

    public void printPostedJobs(Employer employer, ListPrinter printer){

         jobs.printAllJobsByEmployer(employer, printer);
    }

    public void printAllApplications(ApplicationsPrinter printer){

        jobs.printAllApplications(printer);
    }

    public void printByDate(DateTime date, ApplicationsPrinter printer){

        jobs.getByDate(date, printer);
    }

    public void printApplicationsByEmployer(Employer employer, ApplicationsPrinter printer){

       jobs.printAllApplicationsByEmployer(employer, printer);

    }

    public void printApplicationsByJob(Employer employer, Job job, ApplicationsPrinter printer){

        jobs.printByJob(employer, job, printer);

    }

    public void printApplicationsByJobAndDate(Employer employer, Job job, DateTime date, ApplicationsPrinter printer){

        jobs.printByJobAndDate(employer, job, date, printer);

    }

    public void printApplicationsByDate(Employer employer, DateTime date, ApplicationsPrinter printer){

        jobs.printByDateAndEmployer(employer, date, printer);

    }

    public void printApplicationCountByEmployerAndJob(AggregateCountPrinter printer){

        jobs.printApplicationCountByEmployerAndJob(printer);
    }

    public int NumberOfApplications(){

        return jobs.numberOfApplications();
    }


}
