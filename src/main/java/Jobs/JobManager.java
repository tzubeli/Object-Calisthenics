package main.java.Jobs;


import main.java.Collections.ListWrapper;
import main.java.JobApplication.JobApplications;
import main.java.User.Employer;

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
