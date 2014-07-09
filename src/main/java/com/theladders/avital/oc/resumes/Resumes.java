package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.print.ListPrinter;
import com.theladders.avital.oc.user.Jobseeker;

import java.util.HashMap;
import java.util.Map;

/**
* Created by atzubeli on 6/12/14.
*/
public class Resumes{

    private Map<Jobseeker, ResumeList> resumes = new HashMap<>();


    private void createKey(Jobseeker jobseeker) {

        if (!resumes.containsKey(jobseeker))

            resumes.put(jobseeker, new ResumeList());
    }


    public void add(Jobseeker jobseeker, RealResume resume){

        createKey(jobseeker);

        ResumeList list = resumes.get(jobseeker);

        list.create(resume);

    }

    public Resume getOneResume(Jobseeker jobseeker, int index){

        ResumeList list = resumes.get(jobseeker);

        return list.getOneResume(index);

    }

    public void readAll(Jobseeker jobseeker, ListPrinter printer){

        ResumeList list = resumes.get(jobseeker);

        list.readAll().printResumes(printer);



    }







}
