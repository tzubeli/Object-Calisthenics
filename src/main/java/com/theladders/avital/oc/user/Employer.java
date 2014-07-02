package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.jobs.JReqJob;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.print.ConsoleCountPrinter;
import com.theladders.avital.oc.print.ListPrinter;
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

    public ATSJob postATSJob(Name name){

       return (ATSJob)jobManager.postATSJob(this, name);
    }

    public JReqJob postJREQJob(Name name){

       return (JReqJob)jobManager.postJReqJob(this, name);

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


    public void print(ConsoleCountPrinter printer){

        name.print(printer);
    }

    public void print(ListPrinter printer){

        name.print(printer);
    }

    public String toString(){

        return name.toString();
    }


}
