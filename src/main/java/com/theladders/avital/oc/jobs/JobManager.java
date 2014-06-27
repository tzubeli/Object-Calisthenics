package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;
import org.joda.time.LocalDate;

/**
 * Created by atzubeli on 6/16/14.
 */
public class JobManager {



    Jobs jobs;

    
    public JobManager(Jobs jobsToApplications){

        this.jobs = jobsToApplications;
    }

    public void createEmployerKey(Employer employer){

        jobs.createEmployerKey(employer);
    }

    public void postATSJob(Employer employer, JobDescription description){

        Job job = new JobATS(employer, new Name("job"));  //creates a new job object

        jobs.addJob(employer, job);

    }

    public void postJReqJob(Employer employer, JobDescription description){

        Job job = new JobATS(employer, new Name("job"));  //creates a new job object

        jobs.addJob(employer, job);

    }

    public void addApplication(Job job, JobApplication application){

        jobs.addApplication(job, application);

    }

    public JobList getPostedJobs(Employer employer){

        return jobs.getAllJobsByEmployer(employer);
    }

    public ApplicationsList getAllApplications(){

        return null;
    }

    public ApplicationsList getApplicationsByEmployer(Employer employer){

       return jobs.getAllApplicationsByEmployer(employer);

    }

    public ApplicationsList getApplicationsByJob(Employer employer, Job job){

        return jobs.getByJob(employer, job);

    }

    public ApplicationsList getApplicationsByJobAndDate(Employer employer, Job job, LocalDate date){

        return jobs.getByJobAndDate(employer, job, date);

    }

    public ApplicationsList getApplicationsByDate(Employer employer, LocalDate date){

        return jobs.getByDate(employer, date);

    }


}
