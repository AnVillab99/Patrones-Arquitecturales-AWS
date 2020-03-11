package arep.SparkAPI;

import com.google.gson.Gson;
import static spark.Spark.*;

import java.util.Set;

public class SparkAPI {
    public static void main(String[] args) {

        staticFiles.location("/static");
        Gson gson = new Gson();
        port(getPort());

        post("/registro", (req, res) -> {
            // res.type("application/json");
            // res.status(201);
            
            String[] calculado = req.body().split("&");
            
            
			return gson.toJson(calculado[1]);
            
        });
        }
        
        static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
        }

}