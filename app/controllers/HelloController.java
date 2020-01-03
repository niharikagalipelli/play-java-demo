package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.HashMap;
import java.util.Map;

public class HelloController extends Controller {

    public Result doSomethingFancy(){
        return ok("hello from fancy");
    }
    public Result helloUser(String name) {
        String message="hello," +name+ " hi";
        return ok(message);
    }

    public Result helloUserWithDetails() {
        JsonNode requestJson=request().body().asJson();
        String firstName=null;
        String lastName=null;
        if (requestJson.has("first_name")) {
            firstName = requestJson.get("first_name").asText();
        }
        if(requestJson.has("last_name")) {
            lastName = requestJson.get("last_name").asText();
        }
        if(firstName!=null && lastName!=null)
        {
            String message="hello," +firstName+ " "+lastName;
            return ok(message);
        }
        return badRequest("provide both fields");


    }

    Map<String,String> a=new HashMap<String, String>();
    public Result putDetails(){
        JsonNode requestJson=request().body().asJson();
        String id=null;
        String name=null;
        id=requestJson.get("uid").asText();
        name=requestJson.get("Name").asText();
        a.put(id, name);
        return ok("hello"+a.get(id));

    }
    public Result getDetails(String id){

        if(a.get(id)!=null){
            String Name=a.get(id);
            return ok(Name);
        }
        else{
            return ok("ENTER IDtt" + a.get(id));
        }
    }
}
