package com.theladders.avital.oc.jobLists;

import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.print.ListPrinter;

import java.util.ArrayList;
import java.util.Collections;
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

    public void addJob(Job job){

        jobs.add(job);
    }

    public void printJobs(ListPrinter printer){

        printer.createHeader();

        for (Job job : jobs){

            job.print(printer);

            printer.clear();

        }

    }

    public JobList sortList(){

        Collections.sort(jobs);

        return new JobList(jobs);

    }



}
