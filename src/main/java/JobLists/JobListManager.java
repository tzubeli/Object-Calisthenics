package main.java.JobLists;

import main.java.Collections.ListWrapper;
import main.java.Jobs.Job;
import main.java.User.Jobseeker;


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


    public void saveJob(Jobseeker jobseeker, Job job){

       saved.add(jobseeker, job);

    }

    public void unSaveJob(Jobseeker jobseeker, Job job){

       saved.remove(jobseeker, job);

    }

    public void saveAppliedJob(Jobseeker jobseeker, Job job){

        applied.add(jobseeker, job);

        saved.remove(jobseeker, job);
    }



    public ListWrapper getSavedJobs(Jobseeker jobseeker){

       return saved.readAll(jobseeker);

    }

    public int getSizeApplied(Jobseeker jobseeker){

        return applied.readAll(jobseeker).getSize();

    }

    public int getSizeSaved(Jobseeker jobseeker){

        return saved.readAll(jobseeker).getSize();

    }


    public ListWrapper getAppliedJobs(Jobseeker jobseeker){

        return applied.readAll(jobseeker);
    }



}
