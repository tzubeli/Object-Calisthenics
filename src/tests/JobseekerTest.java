/**
 * Created by atzubeli on 6/19/14.
 */

import com.example.objectcalisthenics.JobLists.RecordedJobManager;
import com.example.objectcalisthenics.Jobs.Job;
import com.example.objectcalisthenics.Jobs.JobDescription;
import com.example.objectcalisthenics.Jobs.JobManager;
import com.example.objectcalisthenics.Jobs.PostedJobs;
import com.example.objectcalisthenics.User.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class JobseekerTest {

    Jobseeker avital;
    Jobseeker jay;
    Employer employer;
    PostedJobs jobs = new PostedJobs();
    Job job;
    Job job2;
    RecordedJobManager manager = new RecordedJobManager();

    @Before
    public void initialize(){


        avital = new Jobseeker(new Name("Avital"), manager);

        jay = new Jobseeker(new Name("Jay"), manager);

        employer = new Employer(new Name("theladders"), new JobManager(jobs));

        job = new Job(employer, new JobDescription(new Name("developer"), false));

        job2 = new Job(employer, new JobDescription(new Name("designer"), true));

        avital.saveJob(job, manager);

        jay.saveJob(job, manager);

        avital.saveJob(job2, manager);

    }

    @Test
    public void saveJobTest(){

        Assert.assertTrue(manager.getSavedJobs(avital).size() == 2);

    }
    @Test
    public void viewSavedJobsTest(){

        Collection<Job> collection = jay.viewSavedJobs(manager);

        System.out.println("jay's saved jobs: ");

        for (Job job : collection){

            System.out.println(job.toString());
        }

        collection = avital.viewSavedJobs(manager);

        System.out.println("avital's saved jobs: ");

        for (Job job : collection){

            System.out.println(job.toString());
        }

        //Assert.assertTrue(collection.size()==1);


    }

}
