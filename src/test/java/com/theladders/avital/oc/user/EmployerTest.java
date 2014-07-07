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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class EmployerTest{

    private Jobs jobs;
    private ApplicationManager applicationManager;
    private ATSJob software;
    private JReqJob design;
    private Jobseeker avital, jay;
    private JobManager jobManager;
    private Employer theladders, abc;
    private ApplicationsPrinter printer;

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();


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

    @Before
    public void setUpStream(){

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testEmployerCanPostJobs(){

        theladders.postATSJob(new Name("software"));

        abc.postJREQJob(new Name("design"));

        assertTrue(jobs.numberOfJobs() == 2);
    }

    @Test
    public void testEmployerCanViewPostedJobs(){

        theladders.postATSJob(new Name("software"));

        theladders.postJREQJob(new Name("design"));

        theladders.getPostedJobs(new ConsoleListPrinter());

    }

    @Test
    public void testEmployersCanSeeApplicationsByJob(){ //CSV

        software = theladders.postATSJob(new Name("software"));

        design = theladders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getApplicationsByJob(software,new CSVAppPrinter());


    }

    @Test
    public void testEmployersCanSeeApplicationsByDate(){

        software = theladders.postATSJob(new Name("software"));

        design = theladders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getApplicationsByDate(new LocalDate(2014, 07, 02), printer);



    }

    @Test
    public void testEmployersCanSeeApplicationsByJobAndDate(){

        software = theladders.postATSJob(new Name("software"));

        design = theladders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getApplicationsByJobAndDate(software, new LocalDate(2014, 07, 02), printer);

    }

    @Test
    public void testEmployersCanSeeAllTheirApplications(){ //TODO

        software = theladders.postATSJob(new Name("software"));

        design = abc.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getAllApplications(printer);

    }

    @After
    public void cleanUp(){
        System.setOut(null);
    }

}