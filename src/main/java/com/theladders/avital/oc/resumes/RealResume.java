package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.user.Jobseeker;
import com.theladders.avital.oc.user.Name;

/**
 * Created by atzubeli on 5/21/14.
 */
public class RealResume implements Resume{

    private Jobseeker jobseeker;

    private Name name;

    public RealResume(Jobseeker jobseeker, Name name) {

        this.jobseeker = jobseeker;

        this.name = name;
    }

    public String toString(){

        return name.toString();
    }

    public boolean isNotOwnedBy(Jobseeker thatJobseeker){

        return !thatJobseeker.equals(jobseeker);
    }
}

