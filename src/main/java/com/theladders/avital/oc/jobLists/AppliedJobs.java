package com.theladders.avital.oc.jobLists;

import com.theladders.avital.oc.collections.RecordedMap;
import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.user.Jobseeker;

import java.util.HashMap;

/**
 * Created by atzubeli on 5/28/14.
 */
public class AppliedJobs implements RecordedMap<Jobseeker, ATSJob> {


    private HashMap<Jobseeker, JobList> appliedJobs = new HashMap<>();


    public void createKey(Jobseeker jobseeker) {

        if (!appliedJobs.containsKey(jobseeker))

            appliedJobs.put(jobseeker, new JobList());

    }

    public void add(Jobseeker jobseeker, ATSJob job) {

        JobList list = appliedJobs.get(jobseeker);

        if (!list.exists(job))

            list.addJob(job);

    }

    public void remove(Jobseeker jobseeker, ATSJob job) {

        JobList list = appliedJobs.get(jobseeker);

        list.removeJob(job);

    }

    public JobList readAll(Jobseeker jobseeker) {

        return appliedJobs.get(jobseeker);

    }

    public int getSize(){

        return appliedJobs.size();
    }
}




