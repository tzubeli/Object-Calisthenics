package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.user.JobseekerInfo;
import org.joda.time.DateTime;

/**
 * Created by atzubeli on 5/28/14.
 */
public class ApplicationManager {

    private JobManager jobManager;

    public ApplicationManager(JobManager jobManager){

        this.jobManager = jobManager;
    }

    public void apply(Job job, JobseekerInfo jobseekerInfo){ //TODO

        DateTime date = new DateTime();

        ApplicationDetails details = new ApplicationDetails(jobseekerInfo, date);

        JobApplication application = new JobApplication(job, details);

        jobManager.addApplication(job, application);

    }

    public void failedApplication(Job job) {

        jobManager.addFailure(job);


    }



}
