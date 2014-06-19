package com.example.objectcalisthenics.User;


/**
 * Created by atzubeli on 6/13/14.
 */
public class ID {

    int id;
    IdMap idMap = new IdMap();

    public ID(int id){

        this.id = id;

    }

    public Object getValue(){

        return idMap.getValue(this);


    }

    public String toString(){

        return getValue().toString();
    }

    public int getId(){
        return id;
    } //TODO get rid of this

}

