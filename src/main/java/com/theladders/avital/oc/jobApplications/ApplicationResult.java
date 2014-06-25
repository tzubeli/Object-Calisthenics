package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.jobs.ATSJob;


import java.util.HashMap;

/**
 * Created by atzubeli on 6/23/14.
 */
public class ApplicationResult {



    private HashMap<Boolean, ATSJob> result = new HashMap<>();

    public void addResult(boolean status, ATSJob job){

        result.put(status, job);
    }

}
