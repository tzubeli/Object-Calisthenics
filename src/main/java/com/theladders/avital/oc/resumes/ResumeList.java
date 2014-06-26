package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.collections.CollectionPrinter;

import java.util.ArrayList;

/**
 * Created by atzubeli on 6/12/14.
 */
public class ResumeList {


    ArrayList<Resume> resumes = new ArrayList<>();

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

    public boolean delete(Resume resume){

        return resumes.remove(resume);

    }

    public void printCollection(CollectionPrinter printer){

        printer.print(resumes);

    }


    //TODO for testing only
    public ArrayList<Resume> getCollection() {

        return resumes;
    }

    public int getSize() {

        return resumes.size();
    }
}
