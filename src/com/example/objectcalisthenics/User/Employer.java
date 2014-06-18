package com.example.objectcalisthenics.User;

import com.example.objectcalisthenics.Jobs.JobDescription;
import com.example.objectcalisthenics.Jobs.JobManager;

import java.util.List;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Employer {

    private Name name;

    private JobManager jobManager;

    public Employer(JobManager jobManager){

        this.jobManager = jobManager;

        ID id = IdFactory.createId(this);
    }

    public String toString(){

        return name.toString();
    }

    public void postJob(String newName, boolean requiresResume){

        JobDescription description = new JobDescription(new Name(newName), requiresResume);  //no

        jobManager.createJob(this, description);


    }

    public List viewPostedJobs(){

        return null;
    }





}
