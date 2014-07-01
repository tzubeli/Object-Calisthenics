package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.resumes.Resumes;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;
import org.joda.time.LocalDate;

/**
 * Created by atzubeli on 6/16/14.
 */
public class JobManager {

    Jobs jobs;

    Resumes resumes;

    
    public JobManager(Jobs jobsToApplications, Resumes resumes){

        this.jobs = jobsToApplications;

        this.resumes = resumes;
    }

    public void createEmployerKey(Employer employer){

        jobs.createEmployerKey(employer);
    }

    public void createJobKey(Employer employer, Job job){

        jobs.createJobKey(employer, job);

    }

    public Job postATSJob(Employer employer, Name name, JobManager jobManager){

        Job job = new JobATS(employer, name, jobManager);

        jobs.addJob(employer, job);

        return job;

    }

    public Job postJReqJob(Employer employer, Name name, JobManager jobManager){

        Job job = new JobJReq(employer, name, jobManager);

        jobs.addJob(employer, job);

        return job;

    }

    public void addApplication(Job job, JobApplication application){

        jobs.addApplication(job, application);

    }

    public JobList getPostedJobs(Employer employer){

        return jobs.getAllJobsByEmployer(employer);
    }

    public ApplicationsList getAllApplications(){

        return jobs.getAllApplications();
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
