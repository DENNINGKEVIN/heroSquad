
import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        //get: show new post form
        get("/posts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newHero.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new post form
        post("/posts/new", (req, res) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<>();

            name = request.queryParams("name",0,"specialPower","weakness");
            Hero newPost = new Hero(name);
            model.put("post", newPost);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
