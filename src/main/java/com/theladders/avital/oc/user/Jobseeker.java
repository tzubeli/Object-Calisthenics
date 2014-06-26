package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.jobLists.JobseekerJobList;
import com.theladders.avital.oc.jobs.JobATS;
import com.theladders.avital.oc.jobs.JobJREQ;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.resumes.NoResume;
import com.theladders.avital.oc.resumes.RealResume;
import com.theladders.avital.oc.resumes.Resume;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Jobseeker {

    private Name name;

    private JobseekerJobList jobList;


    public Jobseeker(Name name){

        this.name = name;

        this.jobList = new JobseekerJobList();

    }

    public void apply(JobATS job, Employer employer, RealResume resume, ApplicationManager manager) {

        jobList.saveAppliedJob(job);

        JobseekerInfo info = new JobseekerInfo(this, resume);

        manager.apply(job, info);
    }

    public void apply(JobATS job, Employer employer, ApplicationManager manager){

        jobList.saveAppliedJob(job);

        JobseekerInfo info = new JobseekerInfo(this, new NoResume());

        manager.apply(job, info);
    }

    public void apply(JobJREQ job, Employer employer, Resume resume, ApplicationManager manager){

        jobList.saveAppliedJob(job);

        JobseekerInfo info = new JobseekerInfo(this, resume);

        manager.apply(job, info);

    }

    public void saveJob(Job job){

        jobList.saveJob(job);

    }

    public void unSaveJob(Job job){

        jobList.unSaveJob(job);
    }

    public JobList viewSavedJobs(){

        return jobList.getSavedJobs();

    }

    public JobList viewAppliedJobs(){

        return jobList.getAppliedJobs();

    }

    public void createResume(Name name){

        RealResume resume = new RealResume(this, name);  //TODO then what

    }

    public String toString(){

        return name.toString();
    }




}
