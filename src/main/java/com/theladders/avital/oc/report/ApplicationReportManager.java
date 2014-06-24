package com.theladders.avital.oc.report;


import com.theladders.avital.oc.jobApplications.JobApplication;

import java.util.ArrayList;

/**
 * Created by atzubeli on 5/21/14.
 */
public class ApplicationReportManager {

    public void printApplicationReport(ReportGenerator generator, JobApplication application){

        ArrayList<Object> details = application.getReportDetails();

        Object[] reportDetails = details.toArray();

        generator.print(reportDetails);



    }


}
