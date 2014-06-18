package com.example.objectcalisthenics.User;

import com.example.objectcalisthenics.Jobs.JobDescription;
import com.example.objectcalisthenics.Jobs.JobManager;
import com.example.objectcalisthenics.Jobs.Jobs;

import java.util.Collection;
import java.util.List;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Employer {

    private Name name;

    private JobManager jobManager;

    public Employer(Name name, JobManager jobManager){

        this.jobManager = jobManager;

        this.name = name;

        ID id = IdFactory.createId(this);
    }

    public String toString(){

        return name.toString();
    }

    public void postJob(String newName, boolean requiresResume, Jobs jobs){

        JobDescription description = new JobDescription(new Name(newName), requiresResume);  //no

        jobManager.createJob(this, description, jobs);


    }

    public Collection<ID> viewPostedJobs(){

        return jobManager.viewPostedJobs(this);


    }





}
