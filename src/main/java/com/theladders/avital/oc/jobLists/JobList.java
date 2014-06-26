package com.theladders.avital.oc.jobLists;

import com.theladders.avital.oc.collections.CollectionPrinter;
import com.theladders.avital.oc.jobs.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 5/28/14.
 */
public class JobList {

    private List<Job> jobs = new ArrayList<>();

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


    public void printCollection(CollectionPrinter printer){

        printer.print(jobs);

    }



}
