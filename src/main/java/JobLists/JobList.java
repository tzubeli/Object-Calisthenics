package main.java.JobLists;

import main.java.Collections.ListWrapper;
import main.java.Jobs.Job;

import java.util.ArrayList;

/**
 * Created by atzubeli on 5/28/14.
 */
public class JobList implements ListWrapper<Job> {

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

    public JobList readAll(){

        return this;
    }

    public int getSize(){

        return jobs.size();
    }

    public ArrayList<Job> getCollection(){

        return jobs;
    }



}
