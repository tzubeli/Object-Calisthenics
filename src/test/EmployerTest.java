
import main.java.JobApplication.JobApplications;
import main.java.Jobs.JobManager;
import main.java.Jobs.PostedJobs;
import main.java.User.Employer;

import main.java.User.Name;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;


/**
 * Created by atzubeli on 6/17/14.
 */
public class EmployerTest {

    Employer employer;

    PostedJobs jobs = new PostedJobs();

    JobManager manager = new JobManager(jobs, new JobApplications());

    Name theladders, software, designer;


    @Before
    public void initialize(){

        theladders = new Name("theladders");

        software = new Name("software");

        designer = new Name("designer");


        employer = new Employer(theladders, manager);

        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.getTime());

    }

    @Test
    public void postJobTest(){

        employer.postJob(software, false);

        employer.postJob(designer, true);


        Assert.assertTrue(jobs.readAll(employer).getSize() == 2);

    }

    @Test
    public void viewPostedJobsTest(){

        employer.postJob(software, false);

        employer.postJob(designer, true);

        Assert.assertTrue(employer.viewPostedJobs().getSize()==2);

    }


}
