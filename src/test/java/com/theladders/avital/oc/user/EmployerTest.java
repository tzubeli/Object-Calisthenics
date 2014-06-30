package com.theladders.avital.oc.user;


import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.jobs.Jobs;
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


}