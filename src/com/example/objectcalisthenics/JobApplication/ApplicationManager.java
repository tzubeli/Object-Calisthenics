package com.example.objectcalisthenics.JobApplication;


import com.example.objectcalisthenics.User.Jobseeker;
import com.example.objectcalisthenics.Resumes.Resume;
import com.example.objectcalisthenics.Jobs.JReqJob;
import com.example.objectcalisthenics.User.ID;

/**
 * Created by atzubeli on 5/28/14.
 */
public class ApplicationManager {

    JobApplications applications = new JobApplications();




    public void apply(ID jobId, Jobseeker jobseeker, Resume resume){

        if (jobId.getValue() instanceof JReqJob) {  //does instanceOf violate the rules?

            new JobApplicationJReq(jobId, jobseeker, resume);
        }

        new JobApplicationATS(jobId, jobseeker);







    }

}
