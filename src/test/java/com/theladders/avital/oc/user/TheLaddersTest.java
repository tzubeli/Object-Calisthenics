package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.jobs.JReqJob;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.jobs.Jobs;
import com.theladders.avital.oc.print.*;
import com.theladders.avital.oc.resumes.RealResume;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by atzubeli on 7/1/14.
 */
public class TheLaddersTest {

    private Jobs jobs;
    private ApplicationManager applicationManager;
    private ATSJob software, intern;
    private JReqJob design;
    private Jobseeker avital, jay;
    private JobManager jobManager;
    private Employer employer, abcde;
    private TheLadders theLadders;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void initialize(){

        jobs = new Jobs();

        jobManager = new JobManager(jobs);

        applicationManager = new ApplicationManager(jobManager);

        employer = new Employer(new Name("employer"), jobManager);

        abcde = new Employer(new Name("abcde"), jobManager);

        avital = new Jobseeker(new Name("avital"));

        jay = new Jobseeker(new Name("jay"));

        theLadders = new TheLadders(jobManager);
    }

    @Before
    public void setUpStream(){

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testTheLaddersCanSeeApplicationsByDate(){

        software = employer.postATSJob(new Name("software"));

        design = employer.postJREQJob(new Name("design"));

        intern = abcde.postATSJob(new Name("intern"));

        avital.apply(software, applicationManager);

        try {  Thread.sleep(100);

        }catch(Exception e) {     }

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theLadders.getByDate(new DateTime(), new CSVAppPrinter());

        theLadders.getByDate(new DateTime(), new TestingApplicationPrinter());

        assertEquals("2014-07-08 avital software employer 2014-07-08 jay design employer ", outContent.toString());

    }

    @Test
    public void testTheLaddersCanSeeAllApplications(){  //HTML

        software = employer.postATSJob(new Name("software"));

        design = employer.postJREQJob(new Name("design"));

        intern = abcde.postATSJob(new Name("intern"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(intern, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theLadders.getAllApplications(new HTMLAppPrinter());

        assertTrue(theLadders.getNumberOfApplications() == 4);



    }

    @Test
    public void testTheLaddersCanSeeAggregateJobApplicationNumbers() {

        software = employer.postATSJob(new Name("software"));

        design = employer.postJREQJob(new Name("design"));

        intern = abcde.postATSJob(new Name("intern"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(intern, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theLadders.getApplicationCountByEmployerAndJob(new TestingCountPrinter());

        assertEquals("employer design 1 abcde intern 1 employer software 2 ", outContent.toString());
    }


    @Test
    public void testMoreThanOneJobseekerWithTheSameTitle(){

        avital = new Jobseeker(new Name("avital"));

        jay = new Jobseeker(new Name("avital"));

        software = employer.postATSJob(new Name("software"));

        design = employer.postJREQJob(new Name("design"));

        avital.apply(software, applicationManager);

        try {  Thread.sleep(100);

        }catch(Exception e) {     }

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theLadders.getAllApplications(new TestingApplicationPrinter());

        assertEquals("2014-07-08 avital software employer 2014-07-08 avital design employer ", outContent.toString());

    }

    @Test
    public void testMoreThanOneEmployerWithTheSameTitle(){

        Employer employer = new Employer(new Name("employer"), jobManager);

        Employer employer2 = new Employer(new Name("employer"), jobManager);

        software = employer.postATSJob(new Name("software"));

        intern = employer2.postATSJob(new Name("intern"));

        avital.apply(software, applicationManager);

        try {  Thread.sleep(100);

        }catch(Exception e) {     }

        jay.apply(intern, applicationManager);

        theLadders.getApplicationCountByEmployerAndJob(new TestingCountPrinter());

        assertEquals("employer intern 1 employer software 1 ", outContent.toString());


    }




}
