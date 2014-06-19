//package com.example.objectcalisthenics.Resumes;
//
//import com.example.objectcalisthenics.Collections.RecordedMap;
//import com.example.objectcalisthenics.User.ID;
//
//import java.util.Collection;
//import java.util.HashMap;
//
///**
// * Created by atzubeli on 6/12/14.
// */
//public class ResumesMemory implements RecordedMap<Resume> {
//
//    HashMap<ID, ResumeList> resumes = new HashMap<ID, ResumeList>();
//
//    ResumeListFactory factory;
//
//    public ResumesMemory(ResumeListFactory factory){
//
//        this.factory = factory;
//    }
//
//
//    public void createKey(ID jobseekerId){
//
//        if (!resumes.containsKey(jobseekerId))
//
//             resumes.put(jobseekerId, factory.create());
//
//    }
//
//    public void add(ID jobseekerId, Resume resume){
//
//        ResumeList list = resumes.get(jobseekerId);
//
//        list.create(resume);
//
//    }
//
//    public void remove(ID jobseekerId, Resume resume){
//
//        ResumeList list = resumes.get(jobseekerId);
//
//        list.delete(resume);
//
//    }
//
//    public Collection readAll(ID jobseekerId){
//
//        ResumeList list = resumes.get(jobseekerId);
//
//        return list.readAll();
//
//    }
//
//    public void update(ID jobseekerId, Resume oldResume, Resume newResume){
//
//        ResumeList list = resumes.get(jobseekerId);
//
//        list.update(oldResume, newResume);
//
//    }
//}
