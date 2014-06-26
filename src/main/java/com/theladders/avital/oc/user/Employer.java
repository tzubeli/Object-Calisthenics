package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobLists.JobList;

import com.theladders.avital.oc.jobs.JobDescription;
import com.theladders.avital.oc.jobs.JobManager;

import java.util.Date;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Employer {

    private Name name;

    private JobManager jobManager;

    public Employer(Name name, JobManager jobManager){

        this.jobManager = jobManager;

        this.name = name;

    }

    public void postATSJob(Name name){

        JobDescription description = new JobDescription(name);

        jobManager.createJReqJob(this, description);

    }

    public void postJREQJob(Name name){

        JobDescription description = new JobDescription(name);

        jobManager.createATSJob(this, description);

    }

    public JobList viewPostedJobs(){

        return jobManager.viewPostedJobs(this);

    }

    public void viewApplicationsByDate(Date date){



    }

    public String toString(){

        return name.toString();
    }






}
