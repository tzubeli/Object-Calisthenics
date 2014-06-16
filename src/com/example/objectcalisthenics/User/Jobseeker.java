package com.example.objectcalisthenics.User;

import com.example.objectcalisthenics.JobLists.JobListManager;
import com.example.objectcalisthenics.User.ID;
import com.example.objectcalisthenics.User.IdFactory;
import com.example.objectcalisthenics.User.Name;

import java.util.Collection;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Jobseeker {

    private Name name;
    private ID id;


    public Jobseeker(Name name){

        this.name = name;
        this.id = IdFactory.createId();

        JobListManager.createJobseekerLists(this.id);

    }


    public void saveJob(ID jobId){

        JobListManager.saveJob(this.id, jobId);

    }

    public void apply(int resumeId, ID jobId){


    }

    public Collection viewSavedJobs(){

        return JobListManager.getSavedJobs(this.id);

    }

    public Collection viewAppliedJobs(){

        return JobListManager.getAppliedJobs(this.id);

    }

    public String toString(){

        return name.toString();
    }


}
