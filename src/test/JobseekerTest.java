/**
 * Created by atzubeli on 6/19/14.
 */

import main.java.JobApplication.ApplicationManager;
import main.java.JobApplication.JobApplications;
import main.java.JobLists.JobListManager;
import main.java.Jobs.Job;
import main.java.Jobs.JobDescription;
import main.java.Jobs.JobManager;
import main.java.Jobs.PostedJobs;
import com.example.objectcalisthenics.User.*;
import main.java.User.Employer;
import main.java.User.Jobseeker;
import main.java.User.Name;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class JobseekerTest {

    Jobseeker avital;
    Jobseeker jay;
    Employer employer;
    PostedJobs jobs = new PostedJobs();
    Job job;
    Job job2;
    JobListManager jobListManager = new JobListManager();
    ApplicationManager applicationManager = new ApplicationManager();
    JobApplications jobApplications = new JobApplications();

    @Before
    public void initialize(){


        avital = new Jobseeker(new Name("Avital"), jobListManager);

        jay = new Jobseeker(new Name("Jay"), jobListManager);

        employer = new Employer(new Name("theladders"), new JobManager(jobs, jobApplications));

        job = new Job(employer, new JobDescription(new Name("developer"), false));

        job2 = new Job(employer, new JobDescription(new Name("designer"), true));

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

        ArrayList<Job> collection = jay.viewSavedJobs(jobListManager).getCollection();

        System.out.println("jay's saved jobs: ");

        for (Job job : collection){

            System.out.println(job.toPrint());
        }

        ArrayList<Job> collection2 = avital.viewAppliedJobs(jobListManager).getCollection();

        System.out.println("avital's applied jobs: ");

        for (Job job : collection){

            System.out.println(job.toPrint());
        }


        //Assert.assertTrue(collection.size()==1);


    }

}
