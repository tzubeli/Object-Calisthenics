package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.resumes.Resume;
import com.theladders.avital.oc.user.Jobseeker;
import com.theladders.avital.oc.user.JobseekerInfo;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by atzubeli on 6/13/14.
 */
public class ApplicationDetails {

    JobseekerInfo jobseekerInfo;

    LocalDate date;

    public ApplicationDetails(JobseekerInfo jobseekerDetails, LocalDate date){

        this.jobseekerInfo = jobseekerDetails;

        this.date = date;
    }


    public boolean isDate(LocalDate date){

        return (this.date == date);

    }

    public Object[] createApplicationReport(Jobseeker jobseeker, Resume resume){

        Object[] details = {jobseeker, resume, date};

        return details;

    }

    public ArrayList<Object> getReportDetails(){

        ArrayList<Object> reportDetails = jobseekerInfo.getReportDetails();

        reportDetails.add(date);

        return reportDetails;

    }
}