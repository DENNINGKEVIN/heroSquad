
import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
       staticFileLocation("/public");

       Squad newSquad = new Squad("Avengers", "Fight Crime", 10);
       Squad.add(newSquad);
       Hero newHero =new Hero("Superman",30,"Lazer Eyes","Cryptonite",1);
       Hero.addHero(newHero);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/heroes",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero-details/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "hero-details.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            Squad.clearAll();
            res.redirect("/squads");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/heroes/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            Hero.clearAll();
            res.redirect("/squads");
            return null;
        }, new HandlebarsTemplateEngine());





        post("/posts/squads/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String cause = req.queryParams("cause");
            int maxSize = Integer.parseInt(req.queryParams("size"));
            Squad squad = new Squad(name, cause, maxSize);
            Squad.add(squad);
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


        post("/posts/heroes/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String power = req.queryParams("specialPower");
            String weakness = req.queryParams("weakness");         ;
            int age = Integer.parseInt(req.queryParams("age"));
            int squadId = Integer.parseInt(req.queryParams("squadId"));
            Hero hero = new Hero(name, age, power, weakness, squadId);
            Hero.addHero(hero);
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        post("/squads/:id/edit",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String cause = req.queryParams("cause");
            int maxSize = Integer.parseInt(req.queryParams("size"));
            Squad squad = new Squad(name, cause, maxSize);
            Squad.add(squad);
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        post("/heroes/:id/edit",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String power = req.queryParams("specialPower");
            String weakness = req.queryParams("weakness");         ;
            int age = Integer.parseInt(req.queryParams("age"));
            int squadId = Integer.parseInt(req.queryParams("squadId"));
            Hero hero = new Hero(name, age, power, weakness, squadId);
            Hero.addHero(hero);
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

    }
}
