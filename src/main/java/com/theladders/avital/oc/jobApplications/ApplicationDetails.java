package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.user.JobseekerInfo;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * Created by atzubeli on 6/13/14.
 */
public class ApplicationDetails implements Comparable<ApplicationDetails>{

    private JobseekerInfo jobseekerInfo;

    private DateTime date;

    public ApplicationDetails(JobseekerInfo jobseekerDetails, DateTime date){

        this.jobseekerInfo = jobseekerDetails;

        this.date = date;
    }


    public boolean hasDateOf(DateTime newDate){

        return (date.toLocalDate().equals(newDate.toLocalDate()));

    }

    public void print(ApplicationsPrinter printer){

        LocalDate local = date.toLocalDate();

        String localString = local.toString();

        printer.print(localString);

        jobseekerInfo.print(printer);

    }

    public int compareTo(ApplicationDetails details) {

       return date.compareTo(details.date);
    }
}
