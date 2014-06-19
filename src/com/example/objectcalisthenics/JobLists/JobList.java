package com.example.objectcalisthenics.JobLists;

import com.example.objectcalisthenics.Jobs.Job;
import com.example.objectcalisthenics.User.ID;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by atzubeli on 5/28/14.
 */
public class JobList {

    private ArrayList<Job> jobs = new ArrayList<Job>();

    public boolean exists(Job job){

        return jobs.contains(job);
    }


    public void addJob(Job job){

        jobs.add(job);
    }

    public void removeJob(Job job){

        jobs.remove(job);
    }

    public Collection<Job> readAll(){

        return jobs;
    }


}
