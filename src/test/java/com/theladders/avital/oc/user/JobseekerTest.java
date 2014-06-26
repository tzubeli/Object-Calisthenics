package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobApplications.JobApplications;
import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.jobs.JobDescription;
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
    ATSJob job;
    ATSJob job2;
    JobListManager jobListManager = new JobListManager();
    ApplicationManager applicationManager = new ApplicationManager();
    JobApplications jobApplications = new JobApplications();

    @Before
    public void initialize(){


        avital = new Jobseeker(new Name("Avital"), jobListManager);

        jay = new Jobseeker(new Name("Jay"), jobListManager);

        employer = new Employer(new Name("theladders"), new JobManager(jobs, jobApplications));

        job = new ATSJob(employer, new JobDescription(new Name("developer"), false));

        job2 = new ATSJob(employer, new JobDescription(new Name("designer"), true));

        avital.saveJob(job, jobListManager);

        jay.saveJob(job, jobListManager);

        avital.saveJob(job2, jobListManager);

        avital.apply(job2, employer, applicationManager, jobListManager);


    }

    @Test
    public void saveJobTest(){

        Assert.assertTrue(jobListManager.getSizeSaved(avital) == 2);

    }
    @Test
    public void viewSavedJobsTest(){

    }

}