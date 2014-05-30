package com.example.objectcalisthenics.Collections;

import com.example.objectcalisthenics.Jobs.JobList;
import com.example.objectcalisthenics.User.Jobseeker;

import java.util.HashMap;

/**
 * Created by atzubeli on 5/28/14.
 */
public class AppliedJobs {

    private HashMap<Jobseeker, JobList> appliedJobs = new HashMap<Jobseeker, JobList>();

    JobList jobList = new JobList();


    public void addJobseekerKey(Jobseeker jobseeker){

        appliedJobs.put(jobseeker, jobList);
    }

    public void addJob(Jobseeker jobseeker, int jobId){

        appliedJobs.get(jobseeker).addJob(jobId);

    }

    public void removeJob(Jobseeker jobseeker, int jobId){

        appliedJobs.get(jobseeker).removeJob(jobId);

    }

}
