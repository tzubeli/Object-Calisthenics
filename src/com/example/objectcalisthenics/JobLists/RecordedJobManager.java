package com.example.objectcalisthenics.JobLists;

import com.example.objectcalisthenics.JobLists.AppliedJobs;
import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.JobLists.SavedJobs;
import com.example.objectcalisthenics.User.ID;

import java.util.Collection;


/**
 * Created by atzubeli on 5/30/14.
 */
public class RecordedJobManager {

    private RecordedMap saved = new SavedJobs();

    private RecordedMap applied = new AppliedJobs();

    public void createJobseekerLists(ID jobseekerId){

        saved.createKey(jobseekerId);

        applied.createKey(jobseekerId);

    }

    public void saveJob(ID jobseekerId, ID jobId){


       saved.add(jobseekerId, jobId);

    }

    public void unSaveJob(ID jobseekerId, ID jobId){

       saved.readAll(jobseekerId);

       saved.remove(jobseekerId, jobId);

    }

    public Collection<ID> getSavedJobs(ID jobseekerId){

       return saved.readAll(jobseekerId);

    }

    public Collection<ID> getAppliedJobs(ID jobseekerId){

        return applied.readAll(jobseekerId);
    }

}
