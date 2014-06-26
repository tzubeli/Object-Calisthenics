package com.theladders.avital.oc.user;

import com.theladders.avital.oc.collections.CollectionWrapper;
import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.resumes.RealResume;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Jobseeker {

    private Name name;


    public Jobseeker(Name name, JobListManager manager){

        this.name = name;

        manager.createJobseekerLists(this);
    }


    public void saveJob(ATSJob job, JobListManager jobListManager){

        jobListManager.saveJob(this, job);

    }

    public void application(Job job, Employer employer, RealResume resume, ApplicationManager applicationManager, JobListManager jobListManager){

        jobListManager.saveAppliedJob(this, job);

        job.apply();
    }

    public void apply(Job job, Employer employer, ApplicationManager manager, JobListManager jobListManager){

        job.apply();

    }

    public void apply(ATSJob job, Employer employer, ApplicationManager manager, JobListManager jobListManager){

        manager.apply(job, this, jobListManager);

    }

    public void saveApplied(Job job, JobListManager jobListManager){


    }

    public void unSaveJob(ATSJob job, JobListManager jobListManager){

        jobListManager.unSaveJob(this, job);
    }

    public CollectionWrapper viewSavedJobs(JobListManager jobListManager){

        return jobListManager.getSavedJobs(this);

    }

    public CollectionWrapper viewAppliedJobs(JobListManager jobListManager){

        return jobListManager.getAppliedJobs(this);

    }

    public void createResume(Name name){

        RealResume resume = new RealResume(this, name);  //TODO then what


    }

    public String toString(){

        return name.toString();
    }




}
