package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.print.ListPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 6/12/14.
 */
public class ResumeList {


    List<Resume> resumes = new ArrayList<>();

    public boolean create(Resume resume){
        
        resumes.add(resume);

        return true;
    }

    public RealResume read(int id){

        return null;
    }

    public ResumeList readAll(){

        return this;
    }

    public void update(Resume oldResume, Resume newResume){

        int index = resumes.indexOf(oldResume);

        resumes.set(index, newResume);
    }

    public boolean contains(Resume resume){

        return resumes.contains(resume);
    }

    public boolean delete(Resume resume){

        return resumes.remove(resume);

    }

    public int getSize() {

        return resumes.size();
    }

    public void printResumes(ListPrinter printer){

        for (Resume resume : resumes){

            printer.print(resume.toString());
        }
    }
}
