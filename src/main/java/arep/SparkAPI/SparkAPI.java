package arep.SparkAPI;

import com.google.gson.Gson;

import arep.SparkAPI.services.userServices;
import arep.SparkAPI.services.servicesImpl.userServicesImpl;

import static spark.Spark.*;



public class SparkAPI {

    private static userServices uS = new userServicesImpl();

    public static void main(String[] args) {

        staticFiles.location("/static");
        Gson gson = new Gson();
        port(getPort());
        options("/*",
        (request, response) -> {

            String accessControlRequestHeaders = request
                    .headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers",
                        accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request
                    .headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods",
                        accessControlRequestMethod);
            }

            return "OK";
        });

     before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        // after((Filter) (request, response) -> {
        //     response.header("Access-Control-Allow-Origin", "*");
        //     response.header("Access-Control-Allow-Methods", "*");
        // });
        System.out.println("ya?");
        
        post("/registro", (req, res) -> {
            System.out.println("entrooooooooo");
            
            String[] raw = req.body().split(":");
            String[] values = raw[2].split("&");

            
            String response = uS.registerUser(values[0], values[1]);

            return gson.toJson(response);
            
            
			
            
        });
        get("/users", (req, res) -> {
            String[] users = uS.getAllUsers();
            String ans="";
            for (String s : users) {
                String[] info = s.split("&");
                ans += "<tr><td>" + info[1] + "</td><td>" + info[0] + "</td></tr>";
            }
            return gson.toJson(ans);

            
        });
        }
        
        static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
        }

}