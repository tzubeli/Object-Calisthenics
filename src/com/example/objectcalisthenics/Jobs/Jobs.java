package com.example.objectcalisthenics.Jobs;

import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.JobLists.JobList;
import com.example.objectcalisthenics.User.ID;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by atzubeli on 5/22/14.
 */
public class Jobs implements RecordedMap<ID>{

    private HashMap<ID, JobList> jobs = new HashMap<ID, JobList>();
    //perhaps create a map for each of those jobs in joblist so that they map to their applications


    public void createKey(ID employerId) {

       if( !jobs.containsKey(employerId))

             jobs.put(employerId, new JobList());

    }

    public void add(ID employerId, ID jobId) {

       JobList list = jobs.get(employerId);

       list.addJob(jobId);

    }

    public void remove(ID employerId, ID jobId) {

        JobList list = jobs.get(employerId);

        list.removeJob(jobId);

    }

    public Collection<ID> readAll(ID employerId) {

        JobList list = jobs.get(employerId);

        return list.readAll();
    }

}
