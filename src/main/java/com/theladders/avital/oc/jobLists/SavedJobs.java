package com.theladders.avital.oc.jobLists;

import com.theladders.avital.oc.collections.RecordedMap;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.user.Jobseeker;

import java.util.HashMap;


/**
 * Created by atzubeli on 5/28/14.
 */
public class SavedJobs implements RecordedMap<Jobseeker, Job> {


    private HashMap<Jobseeker, JobList> savedJobs = new HashMap<>();


    public void createKey(Jobseeker jobseeker) {

        if (! savedJobs.containsKey(jobseeker))

            savedJobs.put(jobseeker, new JobList());

    }

    public void add(Jobseeker jobseeker, Job job){

        JobList list = savedJobs.get(jobseeker);

        if (!list.exists(job))

            list.addJob(job);

    }

    public void remove(Jobseeker jobseeker, Job job){

        JobList list = savedJobs.get(jobseeker);

        list.removeJob(job);

    }

    public JobList readAll(Jobseeker jobseeker){

        return savedJobs.get(jobseeker);

    }

    public int getSize(Jobseeker jobseeker){

        return savedJobs.size();

    }
}


