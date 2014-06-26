package com.theladders.avital.oc.jobLists;

import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.user.Jobseeker;

import java.util.HashMap;

/**
 * Created by atzubeli on 5/28/14.
 */
public class AppliedJobs {


    private HashMap<Jobseeker, JobList> appliedJobs = new HashMap<>();


    public void createKey(Jobseeker jobseeker) {

        if (!appliedJobs.containsKey(jobseeker))

            appliedJobs.put(jobseeker, new JobList());

    }

    public void add(Jobseeker jobseeker, Job job) {

        JobList list = appliedJobs.get(jobseeker);

        if (!list.exists(job))

            list.addJob(job);

    }

    public void remove(Jobseeker jobseeker, Job job) {

        JobList list = appliedJobs.get(jobseeker);

        list.removeJob(job);

    }

    public JobList get(Jobseeker jobseeker) {

        return appliedJobs.get(jobseeker);

    }

    public int getSize(){

        return appliedJobs.size();
    }
}




