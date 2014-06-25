package com.theladders.avital.oc.user;

import com.theladders.avital.oc.collections.CollectionWrapper;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.jobs.JobDescription;
import com.theladders.avital.oc.jobs.JobManager;

import java.util.Collection;
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

    public String toString(){

        return name.toString();
    }

    public void postJob(Name name, boolean requiresResume){

        JobDescription description = new JobDescription(name, requiresResume);

        jobManager.createJob(this, description);

    }

    public CollectionWrapper viewPostedJobs(){

        return jobManager.viewPostedJobs(this);

    }

    public Collection<Job> viewApplicationsByDate(Date date){

        return null;
    }





}
