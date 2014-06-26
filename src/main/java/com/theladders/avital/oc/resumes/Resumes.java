package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.collections.CollectionWrapper;
import com.theladders.avital.oc.collections.RecordedMap;
import com.theladders.avital.oc.user.Jobseeker;

import java.util.HashMap;

/**
* Created by atzubeli on 6/12/14.
*/
public class Resumes implements RecordedMap<Jobseeker, RealResume> {

    HashMap<Jobseeker, ResumeList> resumes = new HashMap<Jobseeker, ResumeList>();

    ResumeListMemory list;

    public void createKey(Jobseeker jobseeker) {

        if (!resumes.containsKey(jobseeker))

            resumes.put(jobseeker, new ResumeListMemory());
    }


    public void add(Jobseeker jobseeker, RealResume resume){

        ResumeList list = resumes.get(jobseeker);

        list.create(resume);

    }

    public void remove(Jobseeker jobseeker, RealResume resume){

        ResumeList list = resumes.get(jobseeker);

        list.delete(resume);

    }

    public CollectionWrapper readAll(Jobseeker jobseeker){

        ResumeList list = resumes.get(jobseeker);

        return list.readAll();

    }

    public void update(Jobseeker jobseeker, RealResume oldResume, RealResume newResume){

        ResumeList list = resumes.get(jobseeker);

        list.update(oldResume, newResume);

    }




}
