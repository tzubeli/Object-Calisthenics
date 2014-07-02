package com.theladders.avital.oc.jobApplications;


import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.jobs.Job;
import org.joda.time.LocalDate;

/**
 * Created by atzubeli on 5/21/14.
 */
public class JobApplication {

    private Job job;

    private ApplicationDetails applicationDetails;


    public JobApplication(Job job, ApplicationDetails applicationDetails) {

        this.job = job;

        this.applicationDetails = applicationDetails;
    }

    public boolean hasDateOf(LocalDate date){

        return (applicationDetails.hasDateOf(date));

    }

    public void print(ApplicationsPrinter printer){

        applicationDetails.print(printer);

        job.print(printer);

    }

}
