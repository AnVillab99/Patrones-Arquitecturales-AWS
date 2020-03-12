package arep.SparkAPI.Persistance.Impl;

import java.util.HashMap;
import java.util.Set;

import arep.SparkAPI.Persistance.dbPersistance;

public class dbPersistanceImpl implements dbPersistance{


    HashMap<String,String> db = new HashMap<String,String>();

    public dbPersistanceImpl(){

    }

    @Override
    public Boolean userExists(String email) {
        String name = db.get(email);
        if(name==null){return false;}
        else{ return true;}
    }

    @Override
    public Boolean registerUser(String name, String email) {
        Set<String> keys = db.keySet();
        if(userExists(email)){
            return false;
        }
        db.put(email, name);
        return true;
    }

    @Override
    public String[] getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

}