package com.theladders.avital.oc.user;


import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.jobs.*;
import com.theladders.avital.oc.print.JobPrinterConsole;
import com.theladders.avital.oc.print.PrintToConsole;
import com.theladders.avital.oc.resumes.RealResume;
import com.theladders.avital.oc.resumes.Resumes;
import static org.junit.Assert.assertTrue;
import org.junit.Test;



public class EmployerTest{

    Jobs jobs = new Jobs();

    JobManager jobManager = new JobManager(jobs, new Resumes());

    Employer theladders = new Employer(new Name("theladders"), jobManager);

    Employer abc = new Employer(new Name("abc"), jobManager);

    @Test
    public void testPostJob(){

        theladders.postATSJob(new Name("software"));
        abc.postJREQJob(new Name("design"));

        assertTrue(jobs.numberOfJobs() == 2);
    }

    @Test
    public void testPostedJobs(){

        theladders.postATSJob(new Name("software"));
        theladders.postJREQJob(new Name("design"));


        theladders.getPostedJobs().printJobs(new JobPrinterConsole());

    }

    @Test
    public void testApplicationsByJob(){



        ApplicationManager manager = new ApplicationManager(jobManager);

        JobATS software = theladders.postATSJob(new Name("software"));

        JobJReq design = theladders.postJREQJob(new Name("design"));

        Jobseeker avital = new Jobseeker(new Name("avital"));
        Jobseeker jay = new Jobseeker(new Name("jay"));

        avital.apply(software, theladders, manager);

        jay.apply(design, theladders, new RealResume(avital, new Name("avital resume")), manager);


        theladders.getAllApplications(); //TODO FIX THIS !!!!!!!!


    }


}