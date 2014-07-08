package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.jobs.JReqJob;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobLists.JobseekerJobList;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.print.ListPrinter;
import com.theladders.avital.oc.resumes.*;
import com.theladders.avital.oc.exception.*;

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

    public void apply(ATSJob job, Resume resume, ApplicationManager manager) {

        if (resume.isNotOwnedBy(this)) throw new InvalidResumeException();

        jobList.saveAppliedJob(job);

        JobseekerInfo info = new JobseekerInfo(this, resume);

        manager.apply(job, info);
    }

    public void apply(ATSJob job, ApplicationManager manager){

        jobList.saveAppliedJob(job);

        JobseekerInfo info = new JobseekerInfo(this, new NoResume(this));

        manager.apply(job, info);
    }

    public void apply(JReqJob job, Resume resume, ApplicationManager manager){

        if (resume.isNotOwnedBy(this)) throw new InvalidResumeException();

        jobList.saveAppliedJob(job);

        JobseekerInfo info = new JobseekerInfo(this, resume);

        manager.apply(job, info);

    }

    public void saveJob(Job job){

        jobList.saveJob(job);

    }

    public void viewSavedJobs(ListPrinter printer){

        jobList.printSavedJobs(printer);

    }

    public void viewAppliedJobs(ListPrinter printer){

        jobList.printAppliedJobs(printer);

    }

    public void createResume(Name name, Resumes resumes){

        RealResume resume = new RealResume(this, name);

        resumes.add(this, resume);

    }

    public String toString(){

        return name.toString();
    }

    public void getJobseekerResumes(Resumes resumes, ListPrinter printer){

        resumes.readAll(this, printer);

    }

    public Resume getOneResume(Resumes resumes, int index){

        return resumes.getOneResume(this, index);
    }


    public void print(ApplicationsPrinter printer){

        name.print(printer);

    }




}
