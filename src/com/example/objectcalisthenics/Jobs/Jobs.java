package com.example.objectcalisthenics.Jobs;

import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.JobLists.JobList;
import com.example.objectcalisthenics.User.ID;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by atzubeli on 5/22/14.
 */
public class Jobs implements RecordedMap<ID>{

    private HashMap<ID, JobList> jobs = new HashMap<ID, JobList>();
    //perhaps create a map for each of those jobs in joblist so that they map to their applications


    public void createKey(ID employerId) {

        jobs.put(employerId, new JobList());

    }

    public void add(ID employerId, ID jobId) {

    }

    public void remove(ID employerId, ID jobId) {

    }

    public Collection<ID> readAll(ID employerId) {

        return null;
    }
}
