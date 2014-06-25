package com.theladders.avital.oc.user;

import com.theladders.avital.oc.collections.CollectionWrapper;
import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.jobs.Job;
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

    public void apply(Job job, Employer employer, Resume resume, ApplicationManager manager, JobListManager jobListManager){

        manager.apply(job, this, resume, jobListManager);

    }

    public void apply(Job job, Employer employer, ApplicationManager manager, JobListManager jobListManager){

        manager.apply(job, this, jobListManager);

    }

    public void unSaveJob(Job job, JobListManager jobListManager){

        jobListManager.unSaveJob(this, job);
    }

    public CollectionWrapper viewSavedJobs(JobListManager jobListManager){

        return jobListManager.getSavedJobs(this);

    }

    public CollectionWrapper viewAppliedJobs(JobListManager jobListManager){

        return jobListManager.getAppliedJobs(this);

    }

    public void createResume(Name name){

        Resume resume = new Resume(this, name);  //TODO then what


    }

    public String toString(){

        return name.toString();
    }




}
