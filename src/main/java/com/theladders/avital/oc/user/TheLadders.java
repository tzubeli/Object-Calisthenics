package com.theladders.avital.oc.user;

import com.theladders.avital.oc.collections.ApplicationsPrinter;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobApplications.JobApplications;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.report.ApplicationReportManager;
import com.theladders.avital.oc.report.ReportGenerator;
import org.joda.time.LocalDate;

/**
 * Created by atzubeli on 6/20/14.
 */
public class TheLadders {

    ApplicationReportManager manager = new ApplicationReportManager();
    JobApplications applications = new JobApplications();

    public void getApplicationReport(JobApplication application, ReportGenerator generator){


        manager.printApplicationReport(generator, application);

    }

    public void getJobApplicationsByDate(LocalDate date, ApplicationsPrinter printer){

        applications.getByDate(date);

    }

    public void getJobApplicationsByJobAndDate(LocalDate date, Job job, ApplicationsPrinter printer){

        applications.getByJobAndDate(job, date);

    }

    public void getJobApplicationsByJob(Job job, ApplicationsPrinter printer){


    }
}
