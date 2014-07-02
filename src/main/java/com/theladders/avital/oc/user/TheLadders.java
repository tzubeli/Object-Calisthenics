package com.theladders.avital.oc.user;

import com.theladders.avital.oc.print.AggregateCount;
import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobs.JobManager;
import org.joda.time.LocalDate;

/**
 * Created by atzubeli on 6/20/14.
 */
public class TheLadders {

    private JobManager jobManager;

    public TheLadders(JobManager jobManager) {

        this.jobManager = jobManager;
    }


    public ApplicationsList getAllApplications(){

        return jobManager.getAllApplications();
    }

    public ApplicationsList getByDate(LocalDate date){

        return jobManager.getByDate(date);
    }

    public AggregateCount getApplicationCountByEmployerAndJob(){

        return jobManager.getApplicationCountByEmployerAndJob();
    }

    public int getNumberOfApplications(){

        return jobManager.getNumberOfApplications();


    }

}
