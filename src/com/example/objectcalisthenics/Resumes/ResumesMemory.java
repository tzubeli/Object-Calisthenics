package com.example.objectcalisthenics.Resumes;

import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.User.ID;

import java.util.HashMap;

/**
 * Created by atzubeli on 6/12/14.
 */
public class ResumesMemory implements RecordedMap<Resume> {

    HashMap<ID, ResumeList> resumes = new HashMap<ID, ResumeList>();

    ResumeListFactory factory;

    public ResumesMemory(ResumeListFactory factory){

        this.factory = factory;
    }


    public void createKey(ID jobseekerId){

        resumes.put(jobseekerId, factory.create());

    }

    public void add(ID jobseekerId, Resume resume){

        ResumeList list = resumes.get(jobseekerId);

        list.create(resume);

    }

    public void remove(ID jobseekerId, Resume resume){

        ResumeList list = resumes.get(jobseekerId);

        list.delete(resume);

    }

    public ResumeList readAll(ID jobseekerId){

        return resumes.get(jobseekerId);

    }

    public void update(ID jobseekerId, Resume oldResume, Resume newResume){

        ResumeList list = resumes.get(jobseekerId);

        list.update(oldResume, newResume);

    }
}
