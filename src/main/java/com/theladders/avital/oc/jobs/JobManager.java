package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.print.AggregateCount;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;
import org.joda.time.LocalDate;

/**
 * Created by atzubeli on 6/16/14.
 */
public class JobManager {

    private Jobs jobs;


    public JobManager(Jobs jobsToApplications){

        this.jobs = jobsToApplications;

    }

    public void createEmployerKey(Employer employer){

        jobs.createEmployer(employer);
    }

    public Job postATSJob(Employer employer, Name name){

        Job job = new ATSJob(employer, name);

        jobs.addJob(employer, job);

        return job;

    }

    public Job postJReqJob(Employer employer, Name name){

        Job job = new JReqJob(employer, name);

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

    public ApplicationsList getByDate(LocalDate date){

        return jobs.getByDate(date);
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

        return jobs.getByDateAndEmployer(employer, date);

    }

    public AggregateCount getApplicationCountByEmployerAndJob(){

        return jobs.getApplicationCountByEmployerAndJob();
    }

    public int getNumberOfApplications(){

        return jobs.numberOfApplications();
    }


}
