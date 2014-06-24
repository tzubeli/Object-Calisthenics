package com.theladders.avital.oc.jobs;


import com.theladders.avital.oc.collections.ListWrapper;
import com.theladders.avital.oc.jobApplications.JobApplications;
import com.theladders.avital.oc.user.Employer;

/**
 * Created by atzubeli on 6/16/14.
 */
public class JobManager {

    PostedJobs jobs;
    JobApplications jobApplications;

    
    public JobManager(PostedJobs jobs, JobApplications jobApplications){

        this.jobs = jobs;

        this.jobApplications = jobApplications;
    }


    public void createJob(Employer employer, JobDescription description){

        Job job = new Job(employer, description);  //creates a new job object

        createKeys(job, employer);

    }

    private void createKeys(Job job, Employer employer){

        jobs.createKey(employer);



        jobApplications.createKey(job);  //adds this id to the applications map (????)

        postJob(employer, job);  //posts job --> sends to list of posted jobs

    }

    private void postJob(Employer employer, Job job){

        jobs.add(employer, job);

    }

    public ListWrapper viewPostedJobs(Employer employer){


        return jobs.readAll(employer);

    }
}
