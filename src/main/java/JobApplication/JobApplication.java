package main.java.JobApplication;


import main.java.Jobs.Job;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by atzubeli on 5/21/14.
 */
public class JobApplication {

    Job job;

    ApplicationDetails applicationDetails;


    public JobApplication(Job job, ApplicationDetails applicationDetails) {

        this.job = job;

        this.applicationDetails = applicationDetails;
    }

    public boolean isDate(Date date){

        return (applicationDetails.isDate(date));

    }

    public ArrayList<Object> getReportDetails(){

        ArrayList<Object> details = job.getReportDetails();  //job and employer

        ArrayList<Object> jobseekerDetails = applicationDetails.getReportDetails();  //jobseeker, resume, date

        details.addAll(jobseekerDetails);

        return details;

    }
}
