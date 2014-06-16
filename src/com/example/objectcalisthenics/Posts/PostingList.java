package com.example.objectcalisthenics.Posts;

import com.example.objectcalisthenics.Collections.CRUDInterface;
import com.example.objectcalisthenics.Posts.PostJob;

import java.util.Collection;

/**
 * Created by atzubeli on 6/13/14.
 */
public interface PostingList extends CRUDInterface<PostJob> {

    public boolean create(PostJob jobPosting );

    public PostJob read(int id);

    public Collection<PostJob> readAll();

    public void update(PostJob oldObject, PostJob newObject);

    public boolean delete(PostJob object);
}


