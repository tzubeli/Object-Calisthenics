package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.resumes.RealResume;
import com.theladders.avital.oc.resumes.Resume;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Jobseeker {

    private Name name;


    public Jobseeker(Name name, JobListManager manager){

        this.name = name;

        manager.createJobseekerLists(this);
    }


    public void saveJob(Job job, JobListManager jobListManager){

        jobListManager.saveJob(this, job);

    }

    public void application(Job job, Employer employer, RealResume resume, ApplicationManager applicationManager, JobListManager jobListManager){

        jobListManager.saveAppliedJob(this, job);

        job.apply();
    }

    public void apply(Job job, Employer employer, ApplicationManager manager, JobListManager jobListManager){

        job.apply();

    }

    public void apply(Job job, Employer employer, Resume resume, ApplicationManager manager, JobListManager jobListManager){



    }

    public void saveApplied(Job job, JobListManager jobListManager){


    }

    public void unSaveJob(Job job, JobListManager jobListManager){

        jobListManager.unSaveJob(this, job);
    }

    public JobList viewSavedJobs(JobListManager jobListManager){

        return jobListManager.getSavedJobs(this);

    }



    public JobList viewAppliedJobs(JobListManager jobListManager){

        return jobListManager.getAppliedJobs(this);

    }

    public void createResume(Name name){

        RealResume resume = new RealResume(this, name);  //TODO then what


    }

    public String toString(){

        return name.toString();
    }




}
