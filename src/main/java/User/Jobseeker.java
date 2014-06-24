package main.java.User;

import main.java.Collections.ListWrapper;
import main.java.JobApplication.ApplicationManager;
import main.java.JobLists.JobListManager;
import main.java.Jobs.Job;
import main.java.Resumes.Resume;

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

        manager.apply(job, this, employer, resume, jobListManager);

    }

    public void apply(Job job, Employer employer, ApplicationManager manager, JobListManager jobListManager){

        manager.apply(job, this, employer, jobListManager);

    }

    public void unSaveJob(Job job, JobListManager jobListManager){

        jobListManager.unSaveJob(this, job);
    }

    public ListWrapper viewSavedJobs(JobListManager jobListManager){

        return jobListManager.getSavedJobs(this);

    }

    public ListWrapper viewAppliedJobs(JobListManager jobListManager){

        return jobListManager.getAppliedJobs(this);

    }

    public String toString(){

        return name.toString();
    }


}
