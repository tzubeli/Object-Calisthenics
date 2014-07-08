package com.theladders.avital.oc.user;

import com.theladders.avital.oc.exception.InvalidResumeException;
import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.jobs.JReqJob;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.jobs.Jobs;
import com.theladders.avital.oc.print.ConsoleListPrinter;
import com.theladders.avital.oc.print.TestingListPrinter;
import com.theladders.avital.oc.resumes.RealResume;
import com.theladders.avital.oc.resumes.Resume;
import com.theladders.avital.oc.resumes.Resumes;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by atzubeli on 7/1/14.
 */
public class JobseekerTest {


    private ApplicationManager manager;
    private Employer theladders;
    private Jobseeker avital, jay;
    private Resume avitalResume, jayResume;
    private ATSJob software, intern;
    private JReqJob design;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void initialize(){

        Jobs jobs = new Jobs();

        JobManager jobManager = new JobManager(jobs);

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

    @Before
    public void setUpStream(){

        System.setOut(new PrintStream(outContent));
    }


    @Test (expected = InvalidResumeException.class)
    public void applyToATSJobWithWrongResume(){

        avital.apply(software, jayResume, manager);



    }
    @Test
    public void applyToATSJobWithoutResume(){

        jay.apply(software, manager);

       }

    @Test
    public void viewAppliedJobs(){

        avital.apply(design, avitalResume, manager);
        avital.apply(intern, manager);
        jay.apply(software, manager);

        avital.viewAppliedJobs(new TestingListPrinter());

        assertEquals("theladders design theladders intern ", outContent.toString());

    }

    @Test
    public void viewSavedJobs(){

        avital.saveJob(intern);
        jay.saveJob(design);
        avital.saveJob(software);
        avital.viewSavedJobs(new TestingListPrinter());

        assertEquals("theladders intern theladders software ", outContent.toString());
    }

    @Test
    public void createAndViewResumes(){

        Resumes resumes = new Resumes();

        avital.createResume(new Name("resume.doc"), resumes);
        avital.createResume(new Name("resume.pdf"), resumes);

        avital.getResumes(resumes).printResumes(new TestingListPrinter()); //TODO
        assertEquals("resume.doc resume.pdf ", outContent.toString());
    }

    @After
    public void cleanUp(){

        System.setOut(null);
    }


}
