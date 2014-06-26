package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.user.Jobseeker;

import java.util.HashMap;

/**
* Created by atzubeli on 6/12/14.
*/
public class Resumes{

    HashMap<Jobseeker, ResumeList> resumes = new HashMap<Jobseeker, ResumeList>();


    public void createKey(Jobseeker jobseeker) {

        if (!resumes.containsKey(jobseeker))

            resumes.put(jobseeker, new ResumeList());
    }


    public void add(Jobseeker jobseeker, RealResume resume){

        ResumeList list = resumes.get(jobseeker);

        list.create(resume);

    }

    public void remove(Jobseeker jobseeker, RealResume resume){

        ResumeList list = resumes.get(jobseeker);

        list.delete(resume);

    }

    public ResumeList readAll(Jobseeker jobseeker){

        ResumeList list = resumes.get(jobseeker);

        return list.readAll();

    }

    public void update(Jobseeker jobseeker, RealResume oldResume, RealResume newResume){

        ResumeList list = resumes.get(jobseeker);

        list.update(oldResume, newResume);

    }




}
