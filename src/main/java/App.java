
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
    }
}
