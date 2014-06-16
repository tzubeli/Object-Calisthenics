package com.example.objectcalisthenics.JobLists;

import com.example.objectcalisthenics.JobLists.AppliedJobs;
import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.JobLists.SavedJobs;
import com.example.objectcalisthenics.User.ID;

import java.util.Collection;


/**
 * Created by atzubeli on 5/30/14.
 */
public class JobListManager {

    private static RecordedMap saved = new SavedJobs();

    private static RecordedMap applied = new AppliedJobs();

    public static void createJobseekerLists(ID jobseekerId){

        saved.createKey(jobseekerId);

        applied.createKey(jobseekerId);

    }

    public static void saveJob(ID jobseekerId, ID jobId){


       saved.add(jobseekerId, jobId);

    }

    public static void unSaveJob(ID jobseekerId, ID jobId){

       saved.readAll(jobseekerId);

       saved.remove(jobseekerId, jobId);

    }

    public static Collection<ID> getSavedJobs(ID jobseekerId){

       return saved.readAll(jobseekerId);

    }

    public static Collection<ID> getAppliedJobs(ID jobseekerId){

        return applied.readAll(jobseekerId);
    }

}
