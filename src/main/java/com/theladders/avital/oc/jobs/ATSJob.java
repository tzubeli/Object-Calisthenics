package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobApplications.ATSApplication;
import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.resumes.NoResume;
import com.theladders.avital.oc.resumes.RealResume;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Jobseeker;
import com.theladders.avital.oc.user.JobseekerInfo;
import com.theladders.avital.oc.user.Name;

import java.util.ArrayList;

/**
 * Created by atzubeli on 5/21/14.
 */
public class ATSJob {

    Employer employer;

    Name name;



    public ATSJob(Employer employer, Name name){

        this.employer = employer;
        this.name = name;

    }

    public void getReportDetails(){

        //TODO report stuff

        ArrayList<Object> details = new ArrayList<>();

        details.add(this);

        details.add(employer);

        //return details;
    }

    public void apply(Jobseeker jobseeker, RealResume resume, JobListManager jobListManager){

        JobseekerInfo info = new JobseekerInfo(jobseeker, resume);

        new ATSApplication().apply(info, jobListManager);

    }

    public void apply(Jobseeker jobseeker, JobListManager jobListManager){

        JobseekerInfo info = new JobseekerInfo(jobseeker, new NoResume());


    }

    public String toString(){

        return name.toString();
    }

    public String toPrint(){

        return employer.toString()+ ": " + name.toString();

    }




}
