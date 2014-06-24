package main.java.JobApplication;


import main.java.JobLists.JobListManager;
import main.java.Jobs.Job;
import main.java.User.Employer;
import main.java.User.Jobseeker;
import main.java.Resumes.Resume;
import main.java.User.JobseekerInfo;

import java.util.Calendar;


/**
 * Created by atzubeli on 5/28/14.
 */
public class ApplicationManager {

    JobApplications applications = new JobApplications();

    SuccessAndFailure status = new SuccessAndFailure();


    public void apply(Job job, Jobseeker jobseeker, Employer employer, Resume resume, JobListManager jobListManager) {

        JobseekerInfo jobseekerInfo = new JobseekerInfo(jobseeker, resume);

        setSuccess(jobseeker, job, employer, jobListManager);

        CreateJobApplication(job, jobseekerInfo);

        }

    public void apply(Job job, Jobseeker jobseeker, Employer employer, JobListManager jobListManager){

        if (!job.requiresResume()) {  // TODO violating else rule?

            setSuccess(jobseeker, job, employer, jobListManager);

            JobseekerInfo jobseekerInfo = new JobseekerInfo(jobseeker, null);

            CreateJobApplication(job, jobseekerInfo);
        }

        if (job.requiresResume()) {

            System.out.println("Resume Required ");

            status.addFailure(job, employer);

        }
    }

    public void setSuccess(Jobseeker jobseeker, Job job, Employer employer, JobListManager jobListManager){

        jobListManager.saveAppliedJob(jobseeker, job);

        status.addSuccess(job, employer);

    }

    public void CreateJobApplication(Job job, JobseekerInfo jobseekerInfo){

        Calendar calendar = Calendar.getInstance();

        ApplicationDetails applicationDetails = new ApplicationDetails(jobseekerInfo, calendar.getTime());

        JobApplication application = new JobApplication(job, applicationDetails);

        applications.add(job, application);









    }

}
