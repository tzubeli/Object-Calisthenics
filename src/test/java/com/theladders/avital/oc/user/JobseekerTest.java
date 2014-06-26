package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobApplications.JobApplications;
import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.jobs.JobATS;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.jobs.PostedJobs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by atzubeli on 6/26/14.
 */
public class JobseekerTest {

    Jobseeker avital;
    Jobseeker jay;
    Employer employer;
    PostedJobs jobs = new PostedJobs();
    JobATS job;
    JobATS job2;
    JobListManager jobListManager = new JobListManager();
    ApplicationManager applicationManager = new ApplicationManager();
    JobApplications jobApplications = new JobApplications();

    @Before
    public void initialize(){


        avital = new Jobseeker(new Name("Avital"));

        jay = new Jobseeker(new Name("Jay"));

        employer = new Employer(new Name("theladders"), new JobManager(jobs, jobApplications));

        job = new JobATS(employer, new Name("developer"));

        job2 = new JobATS(employer, new Name("designer"));

        avital.saveJob(job);

        jay.saveJob(job);

        avital.saveJob(job2);

        avital.apply(job2, employer, applicationManager);


    }

    @Test
    public void saveJobTest(){

        Assert.assertTrue(jobListManager.getSizeSaved(avital) == 2);

    }
    @Test
    public void viewSavedJobsTest(){

    }

}