package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.jobs.JReqJob;
import com.theladders.avital.oc.print.AggregateCountPrinter;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.print.ListPrinter;
import org.joda.time.DateTime;

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

    public void getPostedJobs(ListPrinter printer){

        jobManager.getPostedJobs(this, printer);

    }
    public void getAllApplications(ApplicationsPrinter printer){

        jobManager.getApplicationsByEmployer(this, printer);
    }

    public void getApplicationsByDate(DateTime date, ApplicationsPrinter printer){

        jobManager.getApplicationsByDate(this, date, printer);

    }
    public void getApplicationsByJobAndDate(Job job, DateTime date, ApplicationsPrinter printer){

        jobManager.getApplicationsByJobAndDate(this,job, date, printer);
    }

    public void getApplicationsByJob(Job job, ApplicationsPrinter printer){

        jobManager.getApplicationsByJob(this, job, printer);
    }


    public void print(ApplicationsPrinter printer){

        name.print(printer);
    }


    public void print(AggregateCountPrinter printer){

        name.print(printer);
    }

    public void print(ListPrinter printer){

        name.print(printer);
    }

    public String toString(){

        return name.toString();
    }


}
