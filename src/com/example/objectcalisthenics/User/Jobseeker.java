package com.example.objectcalisthenics.User;

import com.example.objectcalisthenics.JobLists.RecordedJobManager;
import com.example.objectcalisthenics.Jobs.Job;
import com.example.objectcalisthenics.Resumes.Resume;

import java.util.Collection;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Jobseeker {

    private Name name;




    public Jobseeker(Name name, RecordedJobManager manager){

        this.name = name;

        ID id = IdFactory.createId(this);

        manager.createJobseekerLists(this);

    }


    public void saveJob(Job job, RecordedJobManager jobListManager){

        jobListManager.saveJob(this, job);

    }

    public void apply(Resume resume, Job job){


    }

    public void unSaveJob(Job job, RecordedJobManager jobListManager){

        jobListManager.unSaveJob(this, job);
    }

    public Collection viewSavedJobs(RecordedJobManager jobListManager){

        return jobListManager.getSavedJobs(this);

    }

    public Collection viewAppliedJobs(RecordedJobManager jobListManager){

        return jobListManager.getAppliedJobs(this);

    }

    public String toString(){

        return name.toString();
    }


}
