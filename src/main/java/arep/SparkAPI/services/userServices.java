package arep.SparkAPI.services;



public interface userServices{

    public String registerUser(String name,String email);

    public String[] getAllUsers();
    
}