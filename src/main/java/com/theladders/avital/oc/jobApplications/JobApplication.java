package com.theladders.avital.oc.jobApplications;


import com.theladders.avital.oc.jobs.ATSJob;
import org.joda.time.LocalDate;

import java.util.ArrayList;

/**
 * Created by atzubeli on 5/21/14.
 */
public class JobApplication {

    ATSJob job;

    ApplicationDetails applicationDetails;


    public JobApplication(ATSJob job, ApplicationDetails applicationDetails) {

        this.job = job;

        this.applicationDetails = applicationDetails;
    }

    public boolean hasDateOf(LocalDate date){

        return (applicationDetails.isDate(date));

    }

    public ArrayList<Object> getReportDetails(){

//        ArrayList<Object> details = job.getReportDetails();  //job and employer
//
//        ArrayList<Object> jobseekerDetails = applicationDetails.getReportDetails();  //jobseeker, resume, date
//
//        details.addAll(jobseekerDetails);
//
//        return details;

        return null;

    }
}
