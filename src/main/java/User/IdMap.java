package main.java.User;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;


/**
 * Created by atzubeli on 6/16/14.
 */
public class IdMap {

    private static HashBiMap<ID, Object> biMap = HashBiMap.create();


    public static void put(ID key, Object value){

        biMap.put(key, value);
    }

    public static Object getValue(ID key){

        return biMap.get(key);

    }

    public static ID getKey(Object value){

        BiMap<Object, ID> map = biMap.inverse();
        return map.get(value);

    }

    public static int size(){

        return biMap.size();
    }
}
