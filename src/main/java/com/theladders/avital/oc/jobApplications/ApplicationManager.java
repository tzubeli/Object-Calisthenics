package com.theladders.avital.oc.jobApplications;


import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.resumes.NoResume;
import com.theladders.avital.oc.resumes.RealResume;
import com.theladders.avital.oc.user.Jobseeker;
import com.theladders.avital.oc.user.JobseekerInfo;
import org.joda.time.LocalDate;


/**
 * Created by atzubeli on 5/28/14.
 */
public class ApplicationManager {

    JobApplications applications = new JobApplications();

    ApplicationResult result = new ApplicationResult();

    public void application(Job job, JobseekerInfo jobseekerInfo){


    }


    public void apply(ATSJob job, Jobseeker jobseeker, RealResume resume, JobListManager jobListManager) {


    }

    public void apply(Job job, Jobseeker jobseeker, JobListManager jobListManager){


        }


    public boolean createJobApplication(ATSJob job, JobseekerInfo jobseekerInfo){

        LocalDate date = new LocalDate();

        ApplicationDetails applicationDetails = new ApplicationDetails(jobseekerInfo, date);

        JobApplication application = new JobApplication(job, applicationDetails);

        applications.add(job, application);

        return true;

    }

    public void setResult(boolean status, ATSJob job){

        result.addResult(status, job);

    }

}
