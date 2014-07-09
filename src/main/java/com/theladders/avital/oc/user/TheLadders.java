package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.print.AggregateCountPrinter;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.ListPrinter;
import org.joda.time.DateTime;

/**
 * Created by atzubeli on 6/20/14.
 */
public class TheLadders {

    private JobManager jobManager;

    public TheLadders(JobManager jobManager) {

        this.jobManager = jobManager;
    }


    public void printAllApplications(ApplicationsPrinter printer){

        jobManager.printAllApplications(printer);
    }

    public void printByDate(DateTime date, ApplicationsPrinter printer){

        jobManager.printByDate(date, printer);
    }

    public void printApplicationCountByEmployerAndJob(AggregateCountPrinter printer){

        jobManager.printApplicationCountByEmployerAndJob(printer);
    }

    public int printNumberOfApplications(){

        return jobManager.NumberOfApplications();

    }

    public void printApplicationResultList(ListPrinter printer){

        jobManager.printResultList(printer);
    }

}
