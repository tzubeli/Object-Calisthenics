package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.user.Jobseeker;
import com.theladders.avital.oc.user.Name;

/**
 * Created by atzubeli on 6/26/14.
 */
public class NoResume implements Resume {

    private Jobseeker jobseeker;

    private Name name = new Name("none");

    public NoResume(Jobseeker jobseeker){

        this.jobseeker = jobseeker;

    }
    public String toString(){

        return name.toString();
    }

    public boolean isNotOwnedBy(Jobseeker thatJobseeker) {

        return !thatJobseeker.equals(jobseeker);
    }


}
