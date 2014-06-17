package com.example.objectcalisthenics.Resumes;

import java.util.ArrayList;

/**
 * Created by atzubeli on 6/12/14.
 */
public class ResumeListMemory implements ResumeList{


    ArrayList<Resume> resumes = new ArrayList<Resume>();

    public boolean create(Resume resume){
        
        resumes.add(resume);

        return true;

    }

    public Resume read(int id){

        for (Resume resume : resumes)

            //two indents oops

            if (resume.hasId(id)) return resume;


        return null;

    }

    public ArrayList readAll(){

        return resumes;

    }

    public void update(Resume oldResume, Resume newResume){

        int index = resumes.indexOf(oldResume);

        resumes.set(index, newResume);

    }

    public boolean delete(Resume resume){

        return resumes.remove(resume);

    }

}
