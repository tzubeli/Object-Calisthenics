package user;

import com.theladders.avital.oc.jobApplications.ApplicationDetails;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobApplications.JobApplications;
import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.jobs.JobDescription;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.jobs.PostedJobs;
import com.theladders.avital.oc.report.CSVGenerator;
import com.theladders.avital.oc.user.*;
import junit.framework.TestCase;
import org.joda.time.LocalDate;

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

        ApplicationDetails details = new ApplicationDetails(info, new LocalDate());

        JobApplication application = new JobApplication(job, details);

        ladders.getApplicationReport(application, new CSVGenerator());






    }
}