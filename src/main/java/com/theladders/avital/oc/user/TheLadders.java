package com.theladders.avital.oc.user;

import com.theladders.avital.oc.print.AggregateCount;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.print.CountPrinterConsole;
import org.joda.time.LocalDate;

/**
 * Created by atzubeli on 6/20/14.
 */
public class TheLadders {



    private JobManager jobManager;

    public TheLadders(JobManager jobManager) {

        this.jobManager = jobManager;
    }


    public void getJobApplicationsByDate(LocalDate date){

        //jobManager.getApplicationsByDate(date);

    }

    public void getJobApplicationsByJobAndDate(LocalDate date, Job job, ApplicationsPrinter printer){

        //applications.getByJobAndDate(job, date);

    }

    public void getJobApplicationsByJob(Job job, ApplicationsPrinter printer){


    }

    public ApplicationsList getAllApplications(){

        return jobManager.getAllApplications();
    }

    public AggregateCount getApplicationCountByEmployerAndJob(){

        return jobManager.getApplicationCountByEmployerAndJob();
    }

}
