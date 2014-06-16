package com.example.objectcalisthenics.Resumes;

import com.example.objectcalisthenics.Collections.CRUDInterface;

import java.util.Collection;


/**
 * Created by atzubeli on 6/12/14.
 */
public interface ResumeList extends CRUDInterface<Resume> {


    public boolean create(Resume resume);
    

    public Resume read(int id);


    public Collection readAll();


    public void update(Resume oldResume, Resume newResume);


    public boolean delete(Resume resume);
}
