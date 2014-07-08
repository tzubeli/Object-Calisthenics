package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.print.ListPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 6/12/14.
 */
public class ResumeList {


    private List<Resume> resumes = new ArrayList<>();

    public void create(Resume resume){
        
        resumes.add(resume);
    }

    public ResumeList readAll(){

        return this;
    }

    public Resume getOneResume(int index){

        return resumes.get(index);
    }

    public void printResumes(ListPrinter printer){

        for (Resume resume : resumes){

            printer.print(resume.toString());
        }
    }
}
