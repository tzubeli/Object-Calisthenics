package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.user.Jobseeker;
import com.theladders.avital.oc.user.Name;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Resume {

    Jobseeker jobseeker;

    Name name;

    public Resume(Jobseeker jobseeker, Name name) {

        this.jobseeker = jobseeker;

        this.name = name;
    }
}

