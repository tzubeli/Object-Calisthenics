package com.theladders.avital.oc.user;

/**
 * Created by atzubeli on 6/13/14.
 */
public abstract class IdFactory {

    public static int id = 10000;

    public static ID createId(Object object){

        ID newId = new ID(++id);

        IdMap.put(newId, object);

        return newId;
    }
}
