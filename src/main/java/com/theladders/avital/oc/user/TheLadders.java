package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.print.AggregateCountPrinter;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import org.joda.time.DateTime;

/**
 * Created by atzubeli on 6/20/14.
 */
public class TheLadders {

    private JobManager jobManager;

    public TheLadders(JobManager jobManager) {

        this.jobManager = jobManager;
    }


    public void getAllApplications(ApplicationsPrinter printer){

        jobManager.getAllApplications(printer);
    }

    public void getByDate(DateTime date, ApplicationsPrinter printer){

        jobManager.getByDate(date, printer);
    }

    public void getApplicationCountByEmployerAndJob(AggregateCountPrinter printer){

        jobManager.getApplicationCountByEmployerAndJob(printer);
    }

    public int getNumberOfApplications(){

        return jobManager.getNumberOfApplications();

    }

    public void getApplicationSuccess(){

        //TODO
    }

}
