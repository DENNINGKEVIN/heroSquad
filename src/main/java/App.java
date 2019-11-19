
import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {


    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);
       staticFileLocation("/public");


       //show home page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "index.hbs");
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
            ArrayList<Squad> squads = Squad.getAllSquads();
            model.put("squads",squads);
            model.put("heroes",Hero.getAll());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        //get squad by id
        get("/squads/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfSquad=Integer.parseInt(req.params("id"));
            Squad foundSquad=Squad.getSquadById(idOfSquad);
            model.put("foundSquad",foundSquad);
//            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "squad-details.hbs");
        }, new HandlebarsTemplateEngine());

        //get hero by id
//        get("/heroes/:id",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            int idOfHero=Integer.parseInt(req.params("id"));
//            Hero foundHero=Hero.getHeroById(idOfHero);
//            model.put("foundHero",foundHero);
////            model.put("squads",Squad.getAllSquads());
//            return new ModelAndView(model, "hero-details.hbs");
//        }, new HandlebarsTemplateEngine());

        //show new heroes form
        get("/posts/heroes/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //show new squads form
        get("/posts/squads/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //show individual hero
        get("/hero-details/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(req.params("id"));
            Hero foundHero = Hero.getHeroById(idOfHeroToFind);
            model.put("foundHero",foundHero);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "hero-details.hbs");
        }, new HandlebarsTemplateEngine());

        //show individual squad
        get("/squad-details/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToFind = Integer.parseInt(req.params("id"));
            Squad foundSquad = Squad.getSquadById(idOfSquadToFind);
            model.put("foundSquad",foundSquad);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "squad-details.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a hero
        get("/hero/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.getHeroById(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "hero-update.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a hero
        get("/squad/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToEdit = Integer.parseInt(req.params("id"));
            Hero editSquad = Hero.getHeroById(idOfSquadToEdit);
            model.put("editSquad", editSquad);
            return new ModelAndView(model, "squad-update.hbs");
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
            Hero deleteHero = Hero.getHeroById(idOfHeroToDelete); //use it to find hero
            deleteHero.deleteHeroById();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete all heroes
        get("/heroes/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Hero.clearAll();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete all squads
        get("/squads/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Squad.clearAll();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //process new squadform
        post("/posts/squads/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String cause = req.queryParams("cause");
            int maxSize = Integer.parseInt(req.queryParams("size"));
            Squad squad = new Squad(name, cause, maxSize);
//            Squad.add(squad);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //process new hero form
        post("/posts/heroes/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String power = req.queryParams("specialPower");
            String weakness = req.queryParams("weakness");
            int age = Integer.parseInt(req.queryParams("age"));
            int squadId = Integer.parseInt(req.queryParams("squadId"));
            Hero hero = new Hero(name, age, power, weakness, squadId);
//            Hero.addHero(hero);
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes",heroes);
            model.put("squads",Squad.getAllSquads());
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process a form to update a squad
        post("/squads/:id/update", (req, res) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String cause = req.queryParams("cause");
            int maxSize = Integer.parseInt(req.queryParams("maxSize"));
            Squad editSquad = new Squad(name, cause, maxSize);
            editSquad.update(name,cause,maxSize);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process a form to update a hero
        post("/heroes/:id/update", (req, res) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String power = req.queryParams("specialPower");
            String weakness = req.queryParams("weakness");
            int age = Integer.parseInt(req.queryParams("age"));
            int squadId = Integer.parseInt(req.queryParams("squadId"));
            Hero editHero = new Hero(name, age, power, weakness, squadId);
            editHero.update(name,age,power,weakness);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
