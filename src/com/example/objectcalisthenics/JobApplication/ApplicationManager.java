package com.example.objectcalisthenics.JobApplication;


import com.example.objectcalisthenics.Jobs.Job;
import com.example.objectcalisthenics.User.Jobseeker;
import com.example.objectcalisthenics.Resumes.Resume;


/**
 * Created by atzubeli on 5/28/14.
 */
public class ApplicationManager {

    JobApplications applications = new JobApplications();




    public void apply(Job job, Jobseeker jobseeker, Resume resume) {

    }

    public void apply(Job job, Jobseeker jobseeker){

        if (job.requiresResume()) System.out.print("need resume");




    }

}
