package tests;


import com.example.objectcalisthenics.Jobs.Job;
import com.example.objectcalisthenics.Jobs.JobDescription;
import com.example.objectcalisthenics.Jobs.JobManager;
import com.example.objectcalisthenics.User.Employer;
import com.example.objectcalisthenics.User.Name;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by atzubeli on 6/17/14.
 */
public class EmployerTest {

    Employer employer;

    @Before
    public void initialize(){
        employer = new Employer(new JobManager());
        //JobDescription jobDescription = new JobDescription(new Name("Software Engineer"), false);

       // Job job = new Job(employer, jobDescription);

    }

    @Test
    public void postJobTest(){

        employer.postJob("software engineer", false);


    }


}
