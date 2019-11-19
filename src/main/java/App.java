
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

       //show all posts
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get squad by id
        get("/squads/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfSquad=Integer.parseInt(req.params("id"));
            Squad foundSquad=Squad.getSquadById(idOfSquad);
            model.put("squads",foundSquad);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "squad-details.hbs");
        }, new HandlebarsTemplateEngine());

        //get hero by id
        get("/heroes/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfSquad=Integer.parseInt(req.params("id"));
            Squad foundSquad=Squad.getSquadById(idOfSquad);
            model.put("squads",foundSquad);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "hero-details.hbs");
        }, new HandlebarsTemplateEngine());


       //get all heroes
        get("/heroes",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());


       //get all squads
        get("/squads",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        //show new heroes form
        get("/heroes/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //show new squads form
        get("/squads/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //show individual hero
        get("/hero-details/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(req.params("id"));
            Hero foundHero = Hero.getHeroById(idOfHeroToFind);
            model.put("heroes",foundHero);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "hero-details.hbs");
        }, new HandlebarsTemplateEngine());

        //show individual squad
        get("/squad-details/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToFind = Integer.parseInt(req.params("id"));
            Squad foundSquad = Squad.getSquadById(idOfSquadToFind);
            model.put("squads",foundSquad);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "squad-details.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a hero
        get("/hero/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.getHeroById(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a hero
        get("/squad/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToEdit = Integer.parseInt(req.params("id"));
            Hero editSquad = Hero.getHeroById(idOfSquadToEdit);
            model.put("editSquad", editSquad);
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete an individual squuad
        get("/squads/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Squad deletePost = Squad.getSquadById(idOfSquadToDelete); //use it to find post
            deletePost.deleteSquadById();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete an individual hero
        get("/heroes/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Hero deleteHero = Hero.getHeroById(idOfHeroToDelete); //use it to find post
            deleteHero.deleteHeroById();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete all heroes
        get("/heroes/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Hero.clearAllPosts();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete all squads
        get("/squads/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Post.clearAllPosts();
            return new ModelAndView(model, "success.hbs");
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
            return new ModelAndView(model, "success.hbs");
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
            int idOfTaskToEdit = Integer.parseInt(req.params("id"));
            Squad squad = new Squad(name, cause, maxSize);
            Squad.updateSquadById(idOfTaskToEdit, squad);
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
