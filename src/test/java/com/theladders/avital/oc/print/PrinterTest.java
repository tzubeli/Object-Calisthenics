package com.theladders.avital.oc.print;

import com.theladders.avital.oc.jobApplications.ApplicationDetails;
import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobs.*;
import com.theladders.avital.oc.resumes.NoResume;
import com.theladders.avital.oc.resumes.RealResume;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Jobseeker;
import com.theladders.avital.oc.user.JobseekerInfo;
import com.theladders.avital.oc.user.Name;
import org.joda.time.LocalDate;
import org.junit.Test;

/**
 * Created by atzubeli on 6/27/14.
 */
public class PrinterTest {

    private JobManager jobManager;



    @Test
    public void testCSVPrinterOneApplication() {

        jobManager = new JobManager(new Jobs());

        Employer theladders = new Employer(new Name("theladders"), jobManager);

        Job software = new ATSJob(theladders, new Name("engineer"));

        Jobseeker avital = new Jobseeker(new Name("Avital"));

        JobseekerInfo info = new JobseekerInfo(avital, new NoResume(avital));

        ApplicationDetails details = new ApplicationDetails(info, new LocalDate());

        JobApplication application = new JobApplication(software, details);

        ApplicationsPrinter printer = new CSVAppPrinter();

        application.print(printer);
    }

    @Test
    public void testConsolePrinterOneApplication(){

        jobManager = new JobManager(new Jobs());

        Employer theladders = new Employer(new Name("theladders"), jobManager);

        Job software = new ATSJob(theladders, new Name("engineer"));

        Jobseeker avital = new Jobseeker(new Name("Avital"));

        JobseekerInfo info = new JobseekerInfo(avital, new NoResume(avital));

        ApplicationDetails details = new ApplicationDetails(info, new LocalDate());

        JobApplication application = new JobApplication(software, details);

        ApplicationsPrinter printer = new ConsoleAppPrinter();

        application.print(printer);


 }

    @Test
    public void testConsolePrinterApplicationsList(){

        jobManager = new JobManager(new Jobs());

        ApplicationManager applicationManager = new ApplicationManager(jobManager);

        Employer theladders = new Employer(new Name("theladders"), jobManager);

        ATSJob engineer = new ATSJob(theladders, new Name("engineer"));

        JReqJob design = new JReqJob(theladders, new Name("designer"));

        Jobseeker avital = new Jobseeker(new Name("Avital"));

        Jobseeker jay = new Jobseeker(new Name("Jay"));

        avital.apply(engineer, applicationManager);

        jay.apply(engineer, applicationManager);

        avital.apply(design, new RealResume(avital, new Name("avital's resume")), applicationManager);

        theladders.getAllApplications(new HTMLAppPrinter());




    }

}
