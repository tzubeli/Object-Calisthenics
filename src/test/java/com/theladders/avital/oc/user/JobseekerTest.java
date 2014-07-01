package com.theladders.avital.oc.user;

import com.theladders.avital.oc.exception.InvalidResumeException;
import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobs.JobATS;
import com.theladders.avital.oc.jobs.JobJReq;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.jobs.Jobs;
import com.theladders.avital.oc.print.ListPrinterConsole;
import com.theladders.avital.oc.resumes.RealResume;
import com.theladders.avital.oc.resumes.Resume;
import com.theladders.avital.oc.resumes.Resumes;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by atzubeli on 7/1/14.
 */
public class JobseekerTest {


    ApplicationManager manager;
    Employer theladders;
    Jobseeker avital, jay;
    Resume avitalResume, jayResume;
    JobATS software, intern;
    JobJReq design;

    @Before
    public void initialize(){

        Jobs jobs = new Jobs();

        JobManager jobManager = new JobManager(jobs, new Resumes());

        manager = new ApplicationManager(jobManager);

        theladders = new Employer(new Name("theladders"), jobManager);

        avital = new Jobseeker(new Name("avital"));

        jay = new Jobseeker(new Name("jay"));

        avitalResume = new RealResume(avital, new Name("avital resume"));

        jayResume = new RealResume(jay, new Name("jay resume"));

        software = theladders.postATSJob(new Name("software"));

        design = theladders.postJREQJob(new Name("design"));

        intern = theladders.postATSJob(new Name("intern"));

    }

    @Test(expected= InvalidResumeException.class)
    public void applyATSJobWithWrongResume(){

        avital.apply(software, jayResume, manager);

    }
    @Test
    public void applyATSJobNoResume(){

        jay.apply(software, manager);


    }
    @Test
    public void viewAppliedJobs(){

        avital.apply(design, avitalResume, manager);
        avital.apply(software, manager);
        avital.apply(intern, manager);

        avital.viewAppliedJobs().printJobs(new ListPrinterConsole());
    }

    @Test
    public void viewSavedJobs(){

        avital.saveJob(intern);
        avital.saveJob(design);
        avital.saveJob(software);
        avital.viewSavedJobs().printJobs(new ListPrinterConsole());
    }

    @Test
    public void createAndViewResumes(){

        Resumes resumes = new Resumes();

        avital.createResume(new Name("resume.doc"), resumes);
        avital.createResume(new Name("resume.pdf"), resumes);

        avital.getResumes(resumes).printResumes(new ListPrinterConsole());
    }

}