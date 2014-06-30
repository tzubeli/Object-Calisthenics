import com.theladders.avital.oc.collections.ApplicationsPrinter;
import com.theladders.avital.oc.collections.PrintToCSVReport;
import com.theladders.avital.oc.collections.PrintToConsole;
import com.theladders.avital.oc.jobApplications.ApplicationDetails;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.jobs.JobATS;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.jobs.Jobs;
import com.theladders.avital.oc.resumes.NoResume;
import com.theladders.avital.oc.resumes.Resumes;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Jobseeker;
import com.theladders.avital.oc.user.JobseekerInfo;
import com.theladders.avital.oc.user.Name;
import org.joda.time.LocalDate;
import org.junit.Test;

/**
 * Created by atzubeli on 6/27/14.
 */
public class PrinterTest {


    @Test
    public void testCSVPrinter() {

        Employer theladders = new Employer(new Name("theladders"), new JobManager(new Jobs(), new Resumes()));

        Job software = new JobATS(theladders, new Name("engineer"));

        Jobseeker avital = new Jobseeker(new Name("Avital"));

        JobseekerInfo info = new JobseekerInfo(avital, new NoResume());

        ApplicationDetails details = new ApplicationDetails(info, new LocalDate());

        JobApplication application = new JobApplication(software, details);

        ApplicationsPrinter printer = new PrintToCSVReport();

        application.print(printer);
    }

    @Test
    public void testConsolePrinter(){

        Employer theladders = new Employer(new Name("theladders"), new JobManager(new Jobs(), new Resumes()));

        Job software = new JobATS(theladders, new Name("engineer"));

        Jobseeker avital = new Jobseeker(new Name("Avital"));

        JobseekerInfo info = new JobseekerInfo(avital, new NoResume());

        ApplicationDetails details = new ApplicationDetails(info, new LocalDate());

        JobApplication application = new JobApplication(software, details);

        ApplicationsPrinter printer = new PrintToConsole();

        application.print(printer);





 }

}
