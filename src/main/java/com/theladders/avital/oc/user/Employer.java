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

        jobManager.addEmployer(this);
    }

    public ATSJob postATSJob(Name name){

       return (ATSJob)jobManager.postATSJob(this, name);
    }

    public JReqJob postJREQJob(Name name){

       return (JReqJob)jobManager.postJReqJob(this, name);
    }

    public void printPostedJobs(ListPrinter printer){

        jobManager.printPostedJobs(this, printer);
    }

    public void printAllApplications(ApplicationsPrinter printer){

        jobManager.printApplicationsByEmployer(this, printer);
    }

    public void printApplicationsByDate(DateTime date, ApplicationsPrinter printer){

        jobManager.printApplicationsByDate(this, date, printer);
    }

    public void printApplicationsByJobAndDate(Job job, DateTime date, ApplicationsPrinter printer){

        jobManager.printApplicationsByJobAndDate(this, job, date, printer);
    }

    public void printApplicationsByJob(Job job, ApplicationsPrinter printer){

        jobManager.printApplicationsByJob(this, job, printer);
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
