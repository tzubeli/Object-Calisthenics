package com.theladders.avital.oc.collections;

import java.util.Collection;

/**
 * Created by atzubeli on 6/13/14.
 */
public interface CRUDInterface<K> {

    public boolean create(K object );

    public K read(int id);

    public Collection<K> readAll();

    public void update(K oldObject, K newObject);

    public boolean delete(K object);
}
