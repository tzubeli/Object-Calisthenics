package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.user.JobseekerInfo;
import org.joda.time.LocalDate;

import java.util.Calendar;

/**
 * Created by atzubeli on 6/13/14.
 */
public class ApplicationDetails implements Comparable<ApplicationDetails>{

    private JobseekerInfo jobseekerInfo;

    private Calendar date;

    public ApplicationDetails(JobseekerInfo jobseekerDetails, Calendar date){

        this.jobseekerInfo = jobseekerDetails;

        this.date = date;
    }


    public boolean hasDateOf(Calendar newDate){
//        date
//
//        return (date.get(Calendar.DATE).equals(newDate.get(Calendar.DATE)));

        return false; 
    }

    public void print(ApplicationsPrinter printer){

        printer.print(date.toString());

        jobseekerInfo.print(printer);

    }

    public int compareTo(ApplicationDetails details) {

       return date.compareTo(details.date);
    }
}
