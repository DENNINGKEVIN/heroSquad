
import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        get("/heros/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Hero.clearAll();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        post("/heros/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToDelete = Integer.parseInt(req.queryParams("id")); //pull id - must match route segment//
            Hero.deleteHeroById(idOfPostToDelete);
            res.redirect("/");
        }, new HandlebarsTemplateEngine());
    }

}
