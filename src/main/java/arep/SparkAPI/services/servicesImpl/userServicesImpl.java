package arep.SparkAPI.services.servicesImpl;

import arep.SparkAPI.Persistance.dbPersistance;
import arep.SparkAPI.Persistance.Impl.dbPersistanceImpl;
import arep.SparkAPI.services.userServices;

public class userServicesImpl implements userServices {

    //Inyectar
    private  dbPersistance db = new dbPersistanceImpl() ;

    @Override
    public String registerUser(String name, String email) {
        
        Boolean registrado = db.registerUser(name, email);
        if(registrado){
            return " ha sido registrado como usuario.";
        }
        else{
            return " ya se encuentra registrado como usuario.";
        }
        
    }

    @Override
    public String[] getAllUsers() {
        return db.getAllUsers();
    }

    
    
}