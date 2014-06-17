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
    }

    public String toString(){

        return name.toString();
    }

    public void postJob(String newName){

        JobDescription description = new JobDescription(new Name(newName), true);  //no

        jobManager.createJob(this, description);


    }

    public List viewPostedJobs(){

        return null;
    }





}
