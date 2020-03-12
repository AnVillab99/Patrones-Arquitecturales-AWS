package arep.SparkAPI;

import com.google.gson.Gson;

import arep.SparkAPI.services.userServices;
import arep.SparkAPI.services.servicesImpl.userServicesImpl;

import static spark.Spark.*;

import java.util.Set;

public class SparkAPI {

    private static userServices uS = new userServicesImpl();

    public static void main(String[] args) {

        staticFiles.location("/static");
        Gson gson = new Gson();
        port(getPort());

        post("/registro", (req, res) -> {
            System.out.println("entrooooooooo");
            
            String[] raw = req.body().split(":");
            String[] values = raw[2].split("&");

            
            String response = uS.registerUser(values[0], values[1]);

            return gson.toJson(response);
            
            
			
            
        });
        get("/registro", (req, res) -> {
            System.out.println("entrooooooooo al get");
            return gson.toJson("ok");
            
            
			
            
        });
        }
        
        static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
        }

}