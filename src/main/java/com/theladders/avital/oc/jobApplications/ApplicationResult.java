package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.user.Employer;


import java.util.Collection;
import java.util.HashMap;

/**
 * Created by atzubeli on 6/23/14.
 */
public class ApplicationResult {



    private HashMap<Boolean, Job> result = new HashMap<>();

    public void addResult(boolean status, Job job){

        result.put(status, job);
    }

}
