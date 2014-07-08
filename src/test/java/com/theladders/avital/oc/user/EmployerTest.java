package com.theladders.avital.oc.user;


import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobs.*;
import com.theladders.avital.oc.print.*;
import com.theladders.avital.oc.resumes.RealResume;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class EmployerTest{

    private Jobs jobs;
    private ApplicationManager applicationManager;
    private Jobseeker avital, jay;
    private JobManager jobManager;
    private Employer theladders, abc;

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

    }

    @Before
    public void setUpStream(){

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testEmployerCanViewPostedJobs(){

        theladders.postATSJob(new Name("software"));

        theladders.getPostedJobs(new TestingListPrinter());

        assertEquals("theladders software ", outContent.toString());

    }

    @Test
    public void testEmployerCanPostJobs(){

        theladders.postATSJob(new Name("software"));

        abc.postJREQJob(new Name("design"));

        assertTrue(jobs.numberOfJobs() == 2);
    }

    @Test
    public void testPostMoreThanOneJobWithTheSameTitle(){

        theladders.postATSJob(new Name("software"));

        theladders.postJREQJob(new Name("software"));

        theladders.getPostedJobs(new TestingListPrinter());

        assertEquals("theladders software theladders software ", outContent.toString());

    }

    @Test
    public void testEmployersCanSeeApplicationsByJob(){

        ATSJob software = theladders.postATSJob(new Name("software"));

        JReqJob design = theladders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getApplicationsByJob(software, new TestingApplicationPrinter());

        assertEquals("2014-07-08 avital software theladders 2014-07-08 jay software theladders ", outContent.toString());

    }

    @Test
    public void testEmployersCanSeeApplicationsByDate(){

        ATSJob software = theladders.postATSJob(new Name("software"));

        JReqJob design = theladders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        try {  Thread.sleep(100);

        }catch(Exception e) {     }

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getApplicationsByDate(new DateTime(), new TestingApplicationPrinter());

        assertEquals("2014-07-08 avital software theladders 2014-07-08 jay design theladders ", outContent.toString());

    }

    @Test
    public void testEmployersCanSeeApplicationsByJobAndDate(){

        ATSJob software = theladders.postATSJob(new Name("software"));

        JReqJob design = theladders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        try {  Thread.sleep(100);

            }catch(Exception e) {     }

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getApplicationsByJobAndDate(software, new DateTime(), new TestingApplicationPrinter());

        assertEquals("2014-07-08 avital software theladders 2014-07-08 jay software theladders ", outContent.toString());

    }

    @Test
    public void testEmployersCanSeeAllTheirApplications(){

        ATSJob software = theladders.postATSJob(new Name("software"));

        JReqJob design = abc.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theladders.getAllApplications(new TestingApplicationPrinter());

        assertEquals("2014-07-08 avital software theladders 2014-07-08 jay software theladders ", outContent.toString());

        }

    @After
    public void cleanUp(){

       System.setOut(null);
    }

}