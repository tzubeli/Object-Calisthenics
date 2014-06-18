package com.example.objectcalisthenics.Collections;

import com.example.objectcalisthenics.User.ID;

import java.util.Collection;

/**
 * Created by atzubeli on 6/12/14.
 */
public interface RecordedMap<K> {

    public void createKey(ID id);

    public void add(ID id, K object);

    public void remove(ID id, K object);

    public Collection<ID> readAll(ID id);



}
