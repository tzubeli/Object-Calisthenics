package com.example.objectcalisthenics.Jobs;

import java.util.ArrayList;

/**
 * Created by atzubeli on 5/28/14.
 */
public class JobList {

    ArrayList<Integer> jobs = new ArrayList<Integer>();


    public void addJob(int jobId){

        jobs.add(jobId);
    }

    public void removeJob(int jobId){

        jobs.remove(jobId);
    }
}
