
import com.example.objectcalisthenics.Jobs.JobManager;
import com.example.objectcalisthenics.Jobs.Jobs;
import com.example.objectcalisthenics.User.Employer;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.example.objectcalisthenics.User.IdMap;
import com.example.objectcalisthenics.User.Name;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * Created by atzubeli on 6/17/14.
 */
public class EmployerTest {

    Employer employer;

    Jobs jobs = new Jobs();


    @Before
    public void initialize(){

        employer = new Employer(new Name("theladders.com"), new JobManager());

        employer.postJob("software engineer", false, jobs);


        employer.postJob("developer", true, jobs);


    }

    @Test
    public void postJobTest(){


        Assert.assertTrue(jobs.readAll(IdMap.getKey(employer)).size() == 2);

    }

    @Test
    public void viewPostedJobsTest(){

        Assert.assertTrue(employer.viewPostedJobs().size()==2);

    }


}
