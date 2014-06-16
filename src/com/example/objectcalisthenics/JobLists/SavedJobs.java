package com.example.objectcalisthenics.JobLists;

import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.User.ID;

import java.util.Collection;
import java.util.HashMap;


/**
 * Created by atzubeli on 5/28/14.
 */
public class SavedJobs implements RecordedMap<ID> {


    private HashMap<ID, JobList> savedJobs = new HashMap<ID, JobList>();


    public void createKey(ID jobseekerId) {

        savedJobs.put(jobseekerId, new JobList());

    }

    public void add(ID jobseekerId, ID jobId){

        JobList list = savedJobs.get(jobseekerId);

        list.addJob(jobId);

    }

    public void remove(ID jobseekerId, ID jobId){

        JobList list = savedJobs.get(jobseekerId);

        list.removeJob(jobId);

    }

    public Collection<ID> readAll(ID jobseekerId){

        JobList list = savedJobs.get(jobseekerId);

        return list.readAll();

    }
}


