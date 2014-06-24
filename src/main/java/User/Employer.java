package main.java.User;

import main.java.Collections.ListWrapper;
import main.java.Jobs.Job;
import main.java.Jobs.JobDescription;
import main.java.Jobs.JobManager;

import java.util.Collection;
import java.util.Date;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Employer {

    private Name name;

    private JobManager jobManager;

    public Employer(Name name, JobManager jobManager){

        this.jobManager = jobManager;

        this.name = name;

        ID id = IdFactory.createId(this); //TODO whats happening with this


    }

    public String toString(){

        return name.toString();
    }

    public void postJob(Name name, boolean requiresResume){

        JobDescription description = new JobDescription(name, requiresResume);

        jobManager.createJob(this, description);

    }

    public ListWrapper viewPostedJobs(){

        return jobManager.viewPostedJobs(this);

    }

    public Collection<Job> viewApplicationsByDate(Date date){

        return null;
    }





}
