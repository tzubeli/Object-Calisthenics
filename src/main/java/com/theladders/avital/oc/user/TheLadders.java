package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.report.ApplicationReportManager;
import com.theladders.avital.oc.report.ReportGenerator;

/**
 * Created by atzubeli on 6/20/14.
 */
public class TheLadders {

    ApplicationReportManager manager = new ApplicationReportManager();

    public void getApplicationReport(JobApplication application, ReportGenerator generator){


        manager.printApplicationReport(generator, application);

    }
}
