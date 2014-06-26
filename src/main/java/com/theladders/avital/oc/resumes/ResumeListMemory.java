package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.collections.CollectionPrinter;

import java.util.ArrayList;

/**
 * Created by atzubeli on 6/12/14.
 */
public class ResumeListMemory implements ResumeList{


    ArrayList<RealResume> resumes = new ArrayList<RealResume>();

    public boolean create(RealResume resume){
        
        resumes.add(resume);

        return true;

    }

    public RealResume read(int id){


        return null;

    }

    public ResumeListMemory readAll(){

        return this;

    }

    public void update(RealResume oldResume, RealResume newResume){

        int index = resumes.indexOf(oldResume);

        resumes.set(index, newResume);

    }

    public boolean delete(RealResume resume){

        return resumes.remove(resume);

    }

    public void printCollection(CollectionPrinter printer){

        printer.print(resumes);

    }


    //TODO for testing only
    public ArrayList<RealResume> getCollection() {

        return resumes;
    }

    public int getSize() {

        return resumes.size();
    }
}
