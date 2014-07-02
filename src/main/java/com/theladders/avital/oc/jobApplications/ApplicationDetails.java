package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.user.JobseekerInfo;
import org.joda.time.LocalDate;

/**
 * Created by atzubeli on 6/13/14.
 */
public class ApplicationDetails {

    private JobseekerInfo jobseekerInfo;

    private LocalDate date;

    public ApplicationDetails(JobseekerInfo jobseekerDetails, LocalDate date){

        this.jobseekerInfo = jobseekerDetails;

        this.date = date;
    }


    public boolean hasDateOf(LocalDate date){

        return (this.date.equals(date));

    }

    public void print(ApplicationsPrinter printer){

        printer.print(date.toString());

        jobseekerInfo.print(printer);




    }
}
