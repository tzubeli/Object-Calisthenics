
import com.example.objectcalisthenics.Jobs.JobManager;
import com.example.objectcalisthenics.Jobs.PostedJobs;
import com.example.objectcalisthenics.User.Employer;

import com.example.objectcalisthenics.User.IdMap;
import com.example.objectcalisthenics.User.Name;
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

    JobManager manager = new JobManager(jobs);

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


        Assert.assertTrue(jobs.readAll(employer).size() == 2);

    }

    @Test
    public void viewPostedJobsTest(){

        employer.postJob(software, false);

        employer.postJob(designer, true);

        Assert.assertTrue(employer.viewPostedJobs().size()==2);

    }


}
