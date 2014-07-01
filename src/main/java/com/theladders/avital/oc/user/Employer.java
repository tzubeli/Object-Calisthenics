package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobs.JobATS;
import com.theladders.avital.oc.jobs.JobJReq;
import com.theladders.avital.oc.print.AggregateCount;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.print.CountPrinterConsole;
import org.joda.time.LocalDate;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Employer {

    private Name name;

    private JobManager jobManager;

    public Employer(Name name, JobManager jobManager){

        this.jobManager = jobManager;

        this.name = name;

        jobManager.createEmployerKey(this);
    }

    public JobATS postATSJob(Name name){

       return (JobATS)jobManager.postATSJob(this, name, jobManager);
    }

    public JobJReq postJREQJob(Name name){

       return (JobJReq)jobManager.postJReqJob(this, name, jobManager);

    }

    public JobList getPostedJobs(){

        return jobManager.getPostedJobs(this);

    }
    public ApplicationsList getAllApplications(){

        return jobManager.getApplicationsByEmployer(this);
    }

    public ApplicationsList getApplicationsByDate(LocalDate date){

        return jobManager.getApplicationsByDate(this, date);

    }
    public ApplicationsList getApplicationsByJobAndDate(Job job, LocalDate date){

        return jobManager.getApplicationsByJobAndDate(this,job, date);
    }

    public ApplicationsList getApplicationsByJob(Job job){

        return jobManager.getApplicationsByJob(this, job);
    }

    public void print(ApplicationsPrinter printer){

        name.print(printer);

    }

    public AggregateCount getApplicationCountByEmployerAndJob(){

        return jobManager.getApplicationCountByEmployerAndJob();
    }

    public void print(CountPrinterConsole printer){

        name.print(printer);
    }

    public String toString(){

        return name.toString();
    }


}
