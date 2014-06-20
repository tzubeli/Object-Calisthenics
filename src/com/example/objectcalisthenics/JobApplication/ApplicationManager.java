package com.example.objectcalisthenics.JobApplication;


import com.example.objectcalisthenics.Jobs.Job;
import com.example.objectcalisthenics.Report.ApplicationReports;
import com.example.objectcalisthenics.User.Jobseeker;
import com.example.objectcalisthenics.Resumes.Resume;
import com.example.objectcalisthenics.User.JobseekerInfo;

import java.util.Calendar;
import java.util.Date;


/**
 * Created by atzubeli on 5/28/14.
 */
public class ApplicationManager {

    JobApplications applications = new JobApplications();
    ApplicationReports reports = new ApplicationReports();




    public void apply(Job job, Jobseeker jobseeker, Resume resume) {

        Calendar calendar = Calendar.getInstance();


        JobseekerInfo jobseekerDetails = new JobseekerInfo(jobseeker, resume);

        ApplicationDetails applicationDetails = new ApplicationDetails(jobseekerDetails, calendar.getTime(), reports );

        applications.add(job, applicationDetails);

    }

    public void apply(Job job, Jobseeker jobseeker){

        if (job.requiresResume()) System.out.print("need resume");




    }

}
