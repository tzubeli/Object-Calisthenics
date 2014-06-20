package com.example.objectcalisthenics.User;

import com.example.objectcalisthenics.JobApplication.ApplicationDetails;
import com.example.objectcalisthenics.Resumes.Resume;
import javafx.application.Application;

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

    public JobseekerInfo(Jobseeker jobseeker){

        this.jobseeker = jobseeker;
    }

    public Object[] createApplicationReport(ApplicationDetails details){

        return details.createApplicationReport(jobseeker, resume);
    }
}
