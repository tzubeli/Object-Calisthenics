package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.user.JobseekerInfo;
import org.joda.time.LocalDate;


/**
 * Created by atzubeli on 5/28/14.
 */
public class ApplicationManager {

    JobApplications applications = new JobApplications();

    ApplicationResult result = new ApplicationResult();


    public void apply(Job job, JobseekerInfo jobseekerInfo){

        LocalDate date = new LocalDate();

        ApplicationDetails details = new ApplicationDetails(jobseekerInfo, date);

        JobApplication application = new JobApplication(job, details);

        applications.add(job, application);

        //success stuff??

    }

}
