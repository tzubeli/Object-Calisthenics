package com.example.objectcalisthenics.Jobs;


import com.example.objectcalisthenics.User.Employer;
import com.example.objectcalisthenics.User.ID;
import com.example.objectcalisthenics.User.IdMap;

import java.util.Collection;

/**
 * Created by atzubeli on 6/16/14.
 */
public class JobManager {

    PostedJobs jobs;
    
    public JobManager(PostedJobs jobs){

        this.jobs = jobs;
    }


    public void createJob(Employer employer, JobDescription description){

        Job job = new Job(employer, description);  //creates a new job object

        createKeys(job, employer);

    }

    private void createKeys(Job job, Employer employer){

        jobs.createKey(employer);

       // JobApplications applications = new JobApplications();

       // applications.createKey(jobId);  //adds this id to the applications map (????)

        postJob(employer, job);  //posts job --> sends to list of posted jobs

    }

    private void postJob(Employer employer, Job job){

        jobs.add(employer, job);

    }

    public Collection<Job> viewPostedJobs(Employer employer){

        ID employerId = IdMap.getKey(employer);

        Collection<Job> collection = jobs.readAll(employer);

        for (Job job : collection) {

            System.out.println(job.toString());

        }


        return jobs.readAll(employer);

    }
}
