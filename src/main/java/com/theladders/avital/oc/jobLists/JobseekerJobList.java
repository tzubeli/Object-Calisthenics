package com.theladders.avital.oc.jobLists;

import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.print.ListPrinter;

/**
 * Created by atzubeli on 6/26/14.
 */
public class JobseekerJobList {

    private JobList saved = new JobList();

    private JobList applied = new JobList();


    public void saveJob(Job job){

        saved.addJob(job);

    }

    public void getSavedJobs(ListPrinter printer){

        saved.printJobs(printer);

    }

    public void saveAppliedJob(Job job){

        applied.addJob(job);

    }

    public void getAppliedJobs(ListPrinter printer){

        applied.printJobs(printer);

    }
}
