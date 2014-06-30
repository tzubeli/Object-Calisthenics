package com.theladders.avital.oc.jobLists;

import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.print.JobPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 5/28/14.
 */
public class JobList {

    private List<Job> jobs = new ArrayList<>();

    public JobList(){

    }

    public JobList(List<Job> jobs){

        this.jobs = jobs;

    }
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

    public void printJobs(JobPrinter printer){
        for (Job job : jobs){

            printer.print(job.toString());
        }
    }




}
