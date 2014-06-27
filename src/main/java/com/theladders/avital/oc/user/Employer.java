package com.theladders.avital.oc.user;

import com.theladders.avital.oc.collections.ApplicationsPrinter;
import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobLists.JobList;

import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.jobs.JobDescription;
import com.theladders.avital.oc.jobs.JobManager;
import javafx.application.Application;
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

    public void postATSJob(Name name){

        JobDescription description = new JobDescription(name);

        jobManager.postJReqJob(this, description);
    }

    public void postJREQJob(Name name){

        JobDescription description = new JobDescription(name);

        jobManager.postATSJob(this, description);

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

    public String toString(){

        return name.toString();
    }


}
