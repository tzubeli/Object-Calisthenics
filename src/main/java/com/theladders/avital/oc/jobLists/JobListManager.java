package com.theladders.avital.oc.jobLists;

import com.theladders.avital.oc.collections.CollectionWrapper;
import com.theladders.avital.oc.jobs.ATSJob;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.user.Jobseeker;


/**
 * Created by atzubeli on 5/30/14.
 */
public class JobListManager {

    private SavedJobs saved = new SavedJobs();

    private AppliedJobs applied = new AppliedJobs();

    public void createJobseekerLists(Jobseeker jobseeker){

        saved.createKey(jobseeker);

        applied.createKey(jobseeker);

    }

    public void saveJob(Jobseeker jobseeker, ATSJob job){

       saved.add(jobseeker, job);

    }

    public void unSaveJob(Jobseeker jobseeker, ATSJob job){

       saved.remove(jobseeker, job);

    }

    public void saveAppliedJob(Jobseeker jobseeker, Job job){

        applied.add(jobseeker, job);

       // saved.remove(jobseeker, job); TODO check if contains
    }

    public int getSizeApplied(Jobseeker jobseeker){

        return applied.get(jobseeker).getSize();

    }

    public int getSizeSaved(Jobseeker jobseeker){

        return saved.readAll(jobseeker).getSize();

    }


    public JobList getAppliedJobs(Jobseeker jobseeker){

        return applied.get(jobseeker);
    }



}
