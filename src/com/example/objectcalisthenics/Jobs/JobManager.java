package com.example.objectcalisthenics.Jobs;


import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.JobApplication.JobApplications;
import com.example.objectcalisthenics.User.Employer;
import com.example.objectcalisthenics.User.ID;
import com.example.objectcalisthenics.User.IdFactory;
import com.example.objectcalisthenics.User.IdMap;

import java.util.Collection;

/**
 * Created by atzubeli on 6/16/14.
 */
public class JobManager {

    Jobs jobs;


    public void createJob(Employer employer, JobDescription description, Jobs jobs){

        Job job = new Job(employer, description);  //creates a new job object

        this.jobs = jobs;

        createKeys(job, employer);

    }

    private void postJob(ID employerId, ID jobId){

        jobs.add(employerId, jobId);

    }

    private void createKeys(Job job, Employer employer){

        ID jobId = IdMap.getKey(job);  //creates new ID and puts it in the map

        ID employerId = IdMap.getKey(employer);

        jobs.createKey(employerId);

       // JobApplications applications = new JobApplications();

       // applications.createKey(jobId);  //adds this id to the applications map (????)

        postJob(employerId, jobId);  //posts job --> sends to list of posted jobs

    }

    public Collection<ID> viewPostedJobs(Employer employer){

        ID employerId = IdMap.getKey(employer);

        return jobs.readAll(employerId);

    }
}
