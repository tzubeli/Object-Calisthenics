package main.java.User;

import main.java.JobApplication.JobApplication;
import main.java.Report.ApplicationReportManager;
import main.java.Report.ReportGenerator;

/**
 * Created by atzubeli on 6/20/14.
 */
public class TheLadders {

    ApplicationReportManager manager = new ApplicationReportManager();

    public void getApplicationReport(JobApplication application, ReportGenerator generator){


        manager.printApplicationReport(generator, application);

    }
}
