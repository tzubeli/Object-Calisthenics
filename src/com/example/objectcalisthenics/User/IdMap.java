package com.example.objectcalisthenics.User;

import com.example.objectcalisthenics.User.ID;

import java.util.HashMap;

/**
 * Created by atzubeli on 6/16/14.
 */
public class IdMap {

    private static HashMap<ID, Object> idMap = new HashMap<ID, Object>();

    public static Object get(ID key){

        return idMap.get(key);
    }

    public static void put(ID key, Object value){

        idMap.put(key, value);
    }
}
