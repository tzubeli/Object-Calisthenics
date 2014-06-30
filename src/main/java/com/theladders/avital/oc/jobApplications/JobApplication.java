package com.theladders.avital.oc.jobApplications;


import com.theladders.avital.oc.collections.ApplicationsPrinter;
import com.theladders.avital.oc.jobs.Job;
import org.joda.time.LocalDate;

import java.util.ArrayList;

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

    public boolean hasDateOf(LocalDate date){

        return (applicationDetails.isDate(date));

    }

    public void print(ApplicationsPrinter printer){

        applicationDetails.print(printer);

        job.print(printer);

    }

}
