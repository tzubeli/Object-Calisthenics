package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobApplications.JobApplications;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;
import org.joda.time.LocalDate;

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

    public void createATSJob(Employer employer, JobDescription description){

        Job job = new JobATS(employer, new Name("job"));  //creates a new job object

        createKeys(job, employer);

    }

    public void createJReqJob(Employer employer, JobDescription description){ //TODO what is happening here

        Job job = new JobATS(employer, new Name("job"));  //creates a new job object

        createKeys(job, employer);

    }

    private void createKeys(Job job, Employer employer){ //TODO and here

        jobs.createKey(employer);

        jobApplications.createKey(job);  //adds this id to the applications map (????)

        postJob(employer, job);  //posts job --> sends to list of posted jobs

    }

    private void postJob(Employer employer, Job job){

        jobs.add(employer, job);

    }

    public JobList viewPostedJobs(Employer employer){

        return jobs.readAll(employer);

    }

    public void getApplicationsByEmployer(Employer employer){

       //TODO change name of classes

    }

    public void getApplicationsByJob(Employer employer, Job job){


    }

    public void getApplicationsByJobAndDate(Employer employer, Job job, LocalDate date){


    }

    public void getApplicationsByDate(Employer employer, LocalDate date){


    }


}
