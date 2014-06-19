package com.example.objectcalisthenics.JobLists;

import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.Jobs.Job;
import com.example.objectcalisthenics.User.Jobseeker;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by atzubeli on 5/28/14.
 */
public class AppliedJobs implements RecordedMap<Jobseeker, Job> {


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

    public Collection<Job> readAll(Jobseeker jobseeker) {

        JobList list = appliedJobs.get(jobseeker);

        return list.readAll();

    }
}




