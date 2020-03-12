package arep.SparkAPI.Persistance;

public interface dbPersistance{
    public Boolean userExists(String email);
    public Boolean registerUser(String name,String email);
    public String[] getAllUsers();
}