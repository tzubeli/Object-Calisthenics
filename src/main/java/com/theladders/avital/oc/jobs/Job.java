package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.resumes.Resume;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Jobseeker;
import com.theladders.avital.oc.user.JobseekerInfo;
import com.theladders.avital.oc.user.Name;

import java.util.ArrayList;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Job {

    Employer employer;

    JobDescription description;



    public Job(Employer employer, JobDescription description){

        this.employer = employer;
        this.description = description;

    }

    public boolean requiresResume(){

        return description.requiresResume();
    }

    public ArrayList<Object> getReportDetails(){

        ArrayList<Object> details = new ArrayList<>();

        details.add(this);

        details.add(employer);

        return details;
    }

    public JobseekerInfo createJobSeekerInfo(Jobseeker jobseeker){

        if (this.requiresResume()) return null;

        return new JobseekerInfo(jobseeker, new Resume(jobseeker, new Name("null")));

    }

    public JobseekerInfo createJobSeekerInfo(Jobseeker jobseeker, Resume resume){

        if (this.requiresResume()) return null;

        return new JobseekerInfo(jobseeker, resume);

    }


    public String toString(){

        return description.toString();
    }

    public String toPrint(){

        return employer.toString()+ ": " + description.toString();

    }




}
