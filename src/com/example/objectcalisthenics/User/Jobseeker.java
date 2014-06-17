package com.example.objectcalisthenics.User;

import com.example.objectcalisthenics.JobLists.JobListManager;

import java.util.Collection;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Jobseeker {

    private Name name;
    private ID id;


    public Jobseeker(Name name, JobListManager manager){

        this.name = name;
        this.id = IdFactory.createId(this);

        manager.createJobseekerLists(this.id);

    }


    public void saveJob(ID jobId, JobListManager jobListManager){

        jobListManager.saveJob(this.id, jobId);

    }

    public void apply(int resumeId, ID jobId){


    }

    public void unSaveJob(ID jobId, JobListManager jobListManager){

        jobListManager.unSaveJob(this.id, jobId);
    }

    public Collection viewSavedJobs(JobListManager jobListManager){

        return jobListManager.getSavedJobs(this.id);

    }

    public Collection viewAppliedJobs(JobListManager jobListManager){

        return jobListManager.getAppliedJobs(this.id);

    }

    public String toString(){

        return name.toString();
    }


}
