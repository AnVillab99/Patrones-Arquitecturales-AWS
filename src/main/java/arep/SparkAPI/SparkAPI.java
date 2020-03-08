package arep.SparkAPI;

import com.google.gson.Gson;
import static spark.Spark.*;

public class SparkAPI{
    public static void main(String[] args) {
        
        
        staticFiles.location("/static");
        Gson gson = new Gson();
        port(getPort());
        


        post("/registrar/:name", (req, res) -> {
            //res.type("application/json");
            //res.status(201);
            
            String calculado = req.params(":name");
            System.out.println(calculado);
            System.out.println(calculado);
			return gson.toJson(calculado);
            
        });
        }
        
        static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
        }

}