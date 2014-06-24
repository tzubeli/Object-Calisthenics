import main.java.JobApplication.ApplicationDetails;
import main.java.JobApplication.JobApplication;
import main.java.JobApplication.JobApplications;
import main.java.JobLists.JobListManager;
import main.java.Jobs.Job;
import main.java.Jobs.JobDescription;
import main.java.Jobs.JobManager;
import main.java.Jobs.PostedJobs;
import main.java.Report.CSVGenerator;
import com.example.objectcalisthenics.User.*;
import junit.framework.TestCase;
import main.java.User.*;

import java.util.Calendar;

public class TheLaddersTest extends TestCase {

    Jobseeker jay;
    Employer employer;
    Job job;
    JobListManager jobListManager = new JobListManager();
    PostedJobs jobs = new PostedJobs();
    TheLadders ladders = new TheLadders();
    JobApplications jobApplications = new JobApplications();



    public void testGetApplicationReport(){

        jay = new Jobseeker(new Name("Jay"), jobListManager);

        employer = new Employer(new Name("theladders"), new JobManager(jobs, jobApplications));

        job = new Job(employer, new JobDescription(new Name("developer"), false));

        JobseekerInfo info = new JobseekerInfo(jay, null);

        ApplicationDetails details = new ApplicationDetails(info, Calendar.getInstance().getTime());

        JobApplication application = new JobApplication(job, details);

        ladders.getApplicationReport(application, new CSVGenerator());






    }
}