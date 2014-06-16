package com.example.objectcalisthenics.JobLists;

import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.User.ID;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by atzubeli on 5/28/14.
 */
public class AppliedJobs implements RecordedMap<ID> {



    private HashMap<ID, JobList> appliedJobs = new HashMap<ID, JobList>();


    public void createKey(ID jobseekerId){

        appliedJobs.put(jobseekerId, new JobList());

    }

    public void add(ID jobseekerId, ID jobId){

        JobList list = appliedJobs.get(jobseekerId);

        list.addJob(jobId);

    }

    public void remove(ID jobseekerId, ID jobId){

        JobList list = appliedJobs.get(jobseekerId);

        list.removeJob(jobId);

    }

    public Collection<ID> readAll(ID jobseekerId){

        JobList list = appliedJobs.get(jobseekerId);

        return list.readAll();

    }



}
