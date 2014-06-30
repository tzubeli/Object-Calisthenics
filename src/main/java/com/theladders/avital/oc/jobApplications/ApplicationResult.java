package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.jobs.Job;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by atzubeli on 6/23/14.
 */
public class ApplicationResult {

    private Map<Boolean, Job> result = new HashMap<>();

    public void addResult(boolean status, Job job){

        result.put(status, job);
    }

}
