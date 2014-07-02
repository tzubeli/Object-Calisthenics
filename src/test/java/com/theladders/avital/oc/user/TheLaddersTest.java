package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobs.JobATS;
import com.theladders.avital.oc.jobs.JobJReq;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.jobs.Jobs;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.CountPrinterConsole;
import com.theladders.avital.oc.print.PrintAppToConsole;
import com.theladders.avital.oc.resumes.RealResume;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by atzubeli on 7/1/14.
 */
public class TheLaddersTest {

    Jobs jobs;
    ApplicationManager applicationManager;
    JobATS software, intern;
    JobJReq design;
    Jobseeker avital, jay;
    JobManager jobManager;
    Employer employer, abcde;
    TheLadders theLadders;

    ApplicationsPrinter printer;

    @Before
    public void initialize(){

        jobs = new Jobs();

        jobManager = new JobManager(jobs);

        applicationManager = new ApplicationManager(jobManager);

        employer = new Employer(new Name("employer"), jobManager);

        abcde = new Employer(new Name("abcde"), jobManager);

        avital = new Jobseeker(new Name("avital"));

        jay = new Jobseeker(new Name("jay"));

        printer = new PrintAppToConsole();

        theLadders = new TheLadders(jobManager);
    }

    @Test
    public void getApplicationsByJobTest(){

        software = employer.postATSJob(new Name("software"));

        design = employer.postJREQJob(new Name("design"));

        intern = abcde.postATSJob(new Name("intern"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(intern, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theLadders.getApplicationCountByEmployerAndJob().printCount(new CountPrinterConsole());

    }

    @Test
    public void getApplicationsByDateTest(){

        software = employer.postATSJob(new Name("software"));

        design = employer.postJREQJob(new Name("design"));

        intern = abcde.postATSJob(new Name("intern"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(intern, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        theLadders.getByDate(new LocalDate(2014, 07, 02)).printList(new PrintAppToConsole());

    }

    @Test
    public void getAllApplicationsTest(){

        software = employer.postATSJob(new Name("software"));

        design = employer.postJREQJob(new Name("design"));

        intern = abcde.postATSJob(new Name("intern"));

        avital.apply(software, applicationManager);

        jay.apply(software, applicationManager);

        jay.apply(intern, applicationManager);

        jay.apply(design, new RealResume(jay, new Name("jay resume")), applicationManager);

        assertTrue(theLadders.getNumberOfApplications() == 4);

        theLadders.getAllApplications().printList(new PrintAppToConsole());

    }

}
