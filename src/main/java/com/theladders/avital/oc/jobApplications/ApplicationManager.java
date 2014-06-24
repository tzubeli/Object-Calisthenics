package com.theladders.avital.oc.jobApplications;


import com.theladders.avital.oc.jobLists.JobListManager;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.user.Employer;
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




    public void apply(Job job, Jobseeker jobseeker, Employer employer, Resume resume, JobListManager jobListManager) {

        JobseekerInfo jobseekerInfo = new JobseekerInfo(jobseeker, resume);

        boolean status = verification(job, jobseekerInfo);

        }


    public void apply(Job job, Jobseeker jobseeker, Employer employer, JobListManager jobListManager){

         JobseekerInfo jobseekerInfo = job.createJobSeekerInfo(jobseeker);

         boolean status = verification(job, jobseekerInfo);

        }

    public void setResult(boolean status, Job job){

        result.addResult(status, job);

    }

    public boolean verification(Job job, JobseekerInfo jobseekerInfo){

        if (jobseekerInfo==null) return false;

        return createJobApplication(job, jobseekerInfo);

    }


    public boolean createJobApplication(Job job, JobseekerInfo jobseekerInfo){

        LocalDate date = new LocalDate();

        ApplicationDetails applicationDetails = new ApplicationDetails(jobseekerInfo, date);

        JobApplication application = new JobApplication(job, applicationDetails);

        applications.add(job, application);

        //jobListManager.saveAppliedJob(jobseeker, job);

        return true;



    }

}
