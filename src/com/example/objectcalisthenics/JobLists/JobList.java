package com.example.objectcalisthenics.JobLists;

import com.example.objectcalisthenics.User.ID;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by atzubeli on 5/28/14.
 */
public class JobList {

    private ArrayList<ID> jobs = new ArrayList<ID>();


    public void addJob(ID jobId){

        jobs.add(jobId);
    }

    public void removeJob(ID jobId){

        jobs.remove(jobId);
    }

    public Collection<ID> readAll(){

        return jobs;
    }


}
