package main.java.JobApplication;

import main.java.Resumes.Resume;
import main.java.User.Jobseeker;
import main.java.User.JobseekerInfo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by atzubeli on 6/13/14.
 */
public class ApplicationDetails {

    JobseekerInfo jobseekerInfo;

    Date date;

    public ApplicationDetails(JobseekerInfo jobseekerDetails, Date date){

        this.jobseekerInfo = jobseekerDetails;

        this.date = date;
    }


    public boolean isDate(Date date){

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
