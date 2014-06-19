package com.example.objectcalisthenics.Jobs;

import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.JobLists.JobList;
import com.example.objectcalisthenics.User.Employer;
import com.example.objectcalisthenics.User.ID;
import com.example.objectcalisthenics.User.Jobseeker;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by atzubeli on 5/22/14.
 */
public class PostedJobs implements RecordedMap<Employer, Job>{


    private HashMap<Employer, JobList> postedJobs = new HashMap<>();


    public void createKey(Employer employer) {

        if (! postedJobs.containsKey(employer))

            postedJobs.put(employer, new JobList());

    }

    public void add(Employer employer, Job job){

        JobList list = postedJobs.get(employer);

        list.addJob(job);

    }

    public void remove(Employer employer, Job job){

        JobList list = postedJobs.get(employer);

        list.removeJob(job);

    }

    public Collection<Job> readAll(Employer employer){

        JobList list = postedJobs.get(employer);

        return list.readAll();

    }

}
