package com.theladders.avital.oc.user;


import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobs.*;
import com.theladders.avital.oc.print.*;
import com.theladders.avital.oc.resumes.RealResume;
import static org.junit.Assert.assertEquals;
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
    private Employer theLadders, abc;
    private String today = new DateTime().toLocalDate().toString();
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void initialize(){

        jobs = new Jobs();

        JobManager jobManager = new JobManager(jobs);

        applicationManager = new ApplicationManager(jobManager);

        theLadders = new Employer(new Name("theLadders"), jobManager);

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

        theLadders.postATSJob(new Name("software"));

        theLadders.printPostedJobs(new TestingListPrinter());

        assertEquals("theLadders software ", outContent.toString());

    }

    @Test
    public void testEmployerCanPostJobs(){

        theLadders.postATSJob(new Name("software"));

        abc.postJREQJob(new Name("design"));

        assertEquals(jobs.numberOfJobs(), 2);
    }

    @Test
    public void testPostMoreThanOneJobWithTheSameTitle(){

        theLadders.postATSJob(new Name("software"));

        theLadders.postJREQJob(new Name("software"));

        theLadders.printPostedJobs(new TestingListPrinter());

        assertEquals("theLadders software theLadders software ", outContent.toString());

    }

    @Test
    public void testEmployersCanSeeApplicationsByJob(){

        ATSJob software = theLadders.postATSJob(new Name("software"));

        JReqJob design = theLadders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theLadders.printApplicationsByJob(software, new TestingApplicationPrinter());

        assertEquals(today+" avital software theLadders "+today+ " jay software theLadders ", outContent.toString());

    }

    @Test
    public void testEmployersCanSeeApplicationsByDate(){

        ATSJob software = theLadders.postATSJob(new Name("software"));

        JReqJob design = theLadders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        try {
          Thread.sleep(100);
        } catch(Exception e) {
          // Do  nothing
        }

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theLadders.printApplicationsByDate(new DateTime(), new TestingApplicationPrinter());

        assertEquals(today+" avital software theLadders "+today+ " jay design theLadders ", outContent.toString());

    }

    @Test
    public void testEmployersCanSeeApplicationsByJobAndDate(){

        ATSJob software = theLadders.postATSJob(new Name("software"));

        JReqJob design = theLadders.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        try {
          Thread.sleep(100);
        }catch(Exception e) {
          // Do nothing
        }

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theLadders.printApplicationsByJobAndDate(software, new DateTime(), new TestingApplicationPrinter());

        assertEquals(today+" avital software theLadders "+today+ " jay software theLadders ", outContent.toString());

    }

    @Test
    public void testEmployersCanSeeAllTheirApplications(){

        ATSJob software = theLadders.postATSJob(new Name("software"));

        JReqJob design = abc.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theLadders.printAllApplications(new TestingApplicationPrinter());

        assertEquals(today+" avital software theLadders "+today+ " jay software theLadders ", outContent.toString());
    }

    @After
    public void cleanUp(){

       System.setOut(null);
    }

}