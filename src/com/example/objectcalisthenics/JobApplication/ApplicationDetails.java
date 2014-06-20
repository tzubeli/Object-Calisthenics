package com.example.objectcalisthenics.JobApplication;

import com.example.objectcalisthenics.Report.ApplicationReports;
import com.example.objectcalisthenics.Resumes.Resume;
import com.example.objectcalisthenics.User.Jobseeker;
import com.example.objectcalisthenics.User.JobseekerInfo;

import java.util.Date;

/**
 * Created by atzubeli on 6/13/14.
 */
public class ApplicationDetails {

    JobseekerInfo jobseekerDetails;

    Date date;

    public ApplicationDetails(JobseekerInfo jobseekerDetails, Date date, ApplicationReports reports){

        this.jobseekerDetails = jobseekerDetails;
        this.date = date;

        Object[] details = jobseekerDetails.createApplicationReport(this);

        reports.addReport(details);  //TODO Job
    }


    public boolean isDate(Date date){

        return (this.date == date);


    }

    public Object[] createApplicationReport(Jobseeker jobseeker, Resume resume){

        Object[] details = {jobseeker, resume, date};

        return details;


    }
}
