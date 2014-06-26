package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.user.Employer;

import java.util.HashMap;

/**
 * Created by atzubeli on 5/22/14.
 */
public class PostedJobs {


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

    public JobList readAll(Employer employer){

        return postedJobs.get(employer);

    }

}
