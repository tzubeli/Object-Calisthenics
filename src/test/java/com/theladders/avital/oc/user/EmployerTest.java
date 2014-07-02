package com.theladders.avital.oc.user;


import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobs.*;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.CSVAppPrinter;
import com.theladders.avital.oc.print.ConsoleAppPrinter;
import com.theladders.avital.oc.print.ConsoleListPrinter;
import com.theladders.avital.oc.resumes.RealResume;
import static org.junit.Assert.assertTrue;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;



public class EmployerTest{

    private Jobs jobs;
    private ApplicationManager applicationManager;
    private ATSJob software;
    private JReqJob design;
    private Jobseeker avital, jay;
    private JobManager jobManager;
    private Employer theladders, abc;
    private ApplicationsPrinter printer;

    @Before
    public void initialize(){

        jobs = new Jobs();

        jobManager = new JobManager(jobs);

        applicationManager = new ApplicationManager(jobManager);

        theladders = new Employer(new Name("theladders"), jobManager);

        abc = new Employer(new Name("abc"), jobManager);

        avital = new Jobseeker(new Name("avital"));

        jay = new Jobseeker(new Name("jay"));

        printer = new ConsoleAppPrinter();

    }

    @Test
    public void testPostJob(){

        theladders.postATSJob(new Name("software"));

        abc.postJREQJob(new Name("design"));

        System.out.println(jobs.numberOfJobs());

        assertTrue(jobs.numberOfJobs() == 2);
    }

    @Test
    public void testGetPostedJobs(){

        theladders.postATSJob(new Name("software"));

        theladders.postJREQJob(new Name("design"));

        theladders.getPostedJobs().printJobs(new ConsoleListPrinter());

    }

    @Test
    public void testApplicationsByJob(){ //CSV

        software = theladders.postATSJob(new Name("software"));

        design = theladders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getAllApplications().printAppList(new CSVAppPrinter());


    }

    @Test
    public void testGetByDate(){

        software = theladders.postATSJob(new Name("software"));

        design = theladders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getApplicationsByDate(new LocalDate(2014, 07, 02)).printAppList(printer);



    }

    @Test
    public void testGetByJobAndDate(){

        software = theladders.postATSJob(new Name("software"));

        design = theladders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getApplicationsByJobAndDate(software, new LocalDate(2014, 07, 02)).printAppList(printer);

    }

    @Test
    public void testGetByJob(){

        software = theladders.postATSJob(new Name("software"));

        design = abc.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getApplicationsByJob(software).printAppList(printer);

    }

}