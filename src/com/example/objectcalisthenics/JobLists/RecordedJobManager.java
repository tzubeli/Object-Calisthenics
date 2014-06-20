package com.example.objectcalisthenics.JobLists;

import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.Jobs.Job;
import com.example.objectcalisthenics.User.ID;
import com.example.objectcalisthenics.User.IdMap;
import com.example.objectcalisthenics.User.Jobseeker;

import java.util.Collection;


/**
 * Created by atzubeli on 5/30/14.
 */
public class RecordedJobManager {

    private RecordedMap saved = new SavedJobs();

    private RecordedMap applied = new AppliedJobs();

    public void createJobseekerLists(Jobseeker jobseeker){


        saved.createKey(jobseeker);

        applied.createKey(jobseeker);

    }


    public void saveJob(Jobseeker jobseeker, Job job){


       saved.add(jobseeker, job);

    }

    public void unSaveJob(Jobseeker jobseeker, Job job){

       saved.readAll(jobseeker);

       saved.remove(jobseeker, job);

    }



    public Collection<ID> getSavedJobs(Jobseeker jobseeker){

       return saved.readAll(jobseeker);

    }


    public Collection<ID> getAppliedJobs(Jobseeker jobseeker){

        return applied.readAll(jobseeker);
    }



}
