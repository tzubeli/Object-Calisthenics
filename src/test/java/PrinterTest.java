import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.PrintToCSVReport;
import com.theladders.avital.oc.print.PrintToConsole;
import com.theladders.avital.oc.jobApplications.ApplicationDetails;
import com.theladders.avital.oc.jobApplications.ApplicationManager;
import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobs.*;
import com.theladders.avital.oc.resumes.NoResume;
import com.theladders.avital.oc.resumes.RealResume;
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

    JobManager jobManager;



    @Test
    public void testCSVPrinterOneApplication() {

        jobManager = new JobManager(new Jobs(), new Resumes());

        Employer theladders = new Employer(new Name("theladders"), jobManager);

        Job software = new JobATS(theladders, new Name("engineer"), jobManager);

        Jobseeker avital = new Jobseeker(new Name("Avital"));

        JobseekerInfo info = new JobseekerInfo(avital, new NoResume());

        ApplicationDetails details = new ApplicationDetails(info, new LocalDate());

        JobApplication application = new JobApplication(software, details);

        ApplicationsPrinter printer = new PrintToCSVReport();

        application.print(printer);
    }

    @Test
    public void testConsolePrinterOneApplication(){

        jobManager = new JobManager(new Jobs(), new Resumes());

        Employer theladders = new Employer(new Name("theladders"), jobManager);

        Job software = new JobATS(theladders, new Name("engineer"), jobManager);

        Jobseeker avital = new Jobseeker(new Name("Avital"));

        JobseekerInfo info = new JobseekerInfo(avital, new NoResume());

        ApplicationDetails details = new ApplicationDetails(info, new LocalDate());

        JobApplication application = new JobApplication(software, details);

        ApplicationsPrinter printer = new PrintToConsole();

        application.print(printer);


 }

    @Test
    public void testConsolePrinterApplicationsList(){

        jobManager = new JobManager(new Jobs(), new Resumes());

        ApplicationManager applicationManager = new ApplicationManager(jobManager);

        Employer theladders = new Employer(new Name("theladders"), jobManager);

        JobATS engineer = new JobATS(theladders, new Name("engineer"), jobManager);

        JobJReq design = new JobJReq(theladders, new Name("designer"), jobManager);

        Jobseeker avital = new Jobseeker(new Name("Avital"));

        Jobseeker jay = new Jobseeker(new Name("Jay"));

        avital.apply(engineer, theladders, applicationManager);

        jay.apply(engineer, theladders, applicationManager);

        avital.apply(design, theladders, new RealResume(avital, new Name("avital's resume")), applicationManager);

        ApplicationsList newList = theladders.getAllApplications();

        newList.toPrint();

        System.out.println("----");

        newList.printList(new PrintToConsole());


    }

}
