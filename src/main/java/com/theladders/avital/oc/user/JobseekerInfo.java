package com.theladders.avital.oc.user;

import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.resumes.Resume;

import java.util.ArrayList;

/**
 * Created by atzubeli on 6/20/14.
 */
public class JobseekerInfo {

    Jobseeker jobseeker;

    Resume resume;

    public JobseekerInfo(Jobseeker jobseeker, Resume resume){

        this.jobseeker = jobseeker;
        this.resume = resume;
    }

    public void print(ApplicationsPrinter printer){

        jobseeker.print(printer);

    }
}
