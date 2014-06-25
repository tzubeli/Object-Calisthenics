package com.theladders.avital.oc.jobApplications;


import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.user.Jobseeker;
import com.theladders.avital.oc.resumes.Resume;
import com.theladders.avital.oc.user.JobseekerInfo;
import org.joda.time.LocalDate;


/**
 * Created by atzubeli on 5/28/14.
 */
public class ApplicationManager {

    JobApplications applications = new JobApplications();

    ApplicationResult result = new ApplicationResult();


    public void apply(ATSJob job, Jobseeker jobseeker, Resume resume, JobListManager jobListManager) {

        JobseekerInfo jobseekerInfo = new JobseekerInfo(jobseeker, resume);

        boolean status = verification(job, jobseekerInfo);

        if (status) jobListManager.saveAppliedJob(jobseeker, job);

        setResult(status, job);

    }

    public void apply(ATSJob job, Jobseeker jobseeker, JobListManager jobListManager){

        JobseekerInfo jobseekerInfo = job.createJobSeekerInfo(jobseeker);

        boolean status = verification(job, jobseekerInfo);

        if (status) jobListManager.saveAppliedJob(jobseeker, job);

        setResult(status, job);

        }

    public boolean verification(ATSJob job, JobseekerInfo jobseekerInfo){

        if (jobseekerInfo==null) return false;

        return createJobApplication(job, jobseekerInfo);

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
