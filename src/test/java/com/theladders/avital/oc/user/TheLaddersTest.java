package com.theladders.avital.oc.user;

import com.theladders.avital.oc.jobApplications.*;
import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.jobs.JobATS;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.jobs.PostedJobs;
import com.theladders.avital.oc.report.CSVGenerator;
import junit.framework.TestCase;
import org.joda.time.LocalDate;

public class TheLaddersTest extends TestCase {

    Jobseeker jay;
    Employer employer;
    JobATS job;
    JobListManager jobListManager = new JobListManager();
    PostedJobs jobs = new PostedJobs();
    TheLadders ladders = new TheLadders();
    JobApplications jobApplications = new JobApplications();
    ApplicationManager manager= new ApplicationManager();



    public void testGetApplicationReport() {

        jay = new Jobseeker(new Name("Jay"));

        employer = new Employer(new Name("theladders"), new JobManager(jobs, jobApplications));

        job = new JobATS(employer, new Name("developer"));

        JobseekerInfo info = new JobseekerInfo(jay, null);

        ApplicationDetails details = new ApplicationDetails(info, new LocalDate());

        JobApplication application = new JobApplication(job, details);

        ladders.getApplicationReport(application, new CSVGenerator());
    }



    public void testGetJobseekerByDay(){




    }



    }
