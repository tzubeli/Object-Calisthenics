package com.theladders.avital.oc.jobLists;

import com.theladders.avital.oc.jobs.Job;

/**
 * Created by atzubeli on 6/26/14.
 */
public class JobseekerJobList {

    private JobList saved = new JobList();

    private JobList applied = new JobList();


    public void saveJob(Job job){

        saved.addJob(job);

    }

    public void unSaveJob(Job job){

        saved.removeJob(job);
    }

    public JobList getSavedJobs(){

        return saved;

    }

    public void saveAppliedJob(Job job){

        applied.addJob(job);

    }

    public JobList getAppliedJobs(){

        return applied;

    }
}
