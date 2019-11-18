
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

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to create a new squad
        get("/squads/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads",(req,res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());



//        get("/hero",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "hero.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/hero",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Hero> hero = Hero.getAll();
//            model.put("hero",hero);
//            return new ModelAndView(model, "hero.hbs");
//        }, new HandlebarsTemplateEngine());
//        get("/new/:id",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            int idOfHero = Integer.parseInt(req.params(":id"));
//            Hero foundHero = Hero.getHeroById(idOfHero);
//            model.put("hero",foundHero);
//            return new ModelAndView(model, "hero-details.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/squad-form",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "squad-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/squad",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Squad> squads = Squad.getAllSquads();
//            model.put("squads",squads);
//            ArrayList<Hero> members = Hero.getAll();
//            model.put("heroes",members);
//            Squad newSquad = Squad.getSquadById(1);
//            model.put("allSquadMembers", newSquad.getSquadMembers());
//            return new ModelAndView(model, "squad.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/squad/new",(req,res)-> {
//            Map<String, Object> model = new HashMap<>();
//            String squadName = req.queryParams("squadName");
//            Integer size = Integer.parseInt(req.queryParams("size"));
//            String cause = req.queryParams("cause");
//            Squad newSquad = new Squad("name","cause",3);
//            req.session().attribute("item",squadName);
//            model.put("item",req.session().attribute("item"));
//            return new ModelAndView(model,"success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/new/hero",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            String name = req.queryParams("name");
//            Integer age = Integer.parseInt(req.queryParams("age"));
//            String power = req.queryParams("power");
//            String weakness = req.queryParams("weakness");
//            Hero newHero = new Hero(name,age,power,weakness);
//            req.session().attribute("item",name);
//            model.put("item",req.session().attribute("item"));
//            model.put("newHero",newHero);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/new/member/:squadId",(req,res)->{
//            Map<String, Object> model = new HashMap<>();
//            req.session().attribute("selectedSquad",req.params("squadId"));
//            model.put("selectedSquad", req.session().attribute("selectedSquad"));
//            model.put("item",1);
//            return new ModelAndView(model, "success.hbs");
//        },new HandlebarsTemplateEngine());
//
//        get("/squad/new/:id",(req,res)->{
//            Map<String, Object> model = new HashMap<>();
//            int id= Integer.parseInt(req.params(":id"));
//            Hero newMember = Hero.getHeroById(id);
//            Squad newSquad = Squad.getSquadById(1);
//            newSquad.setSquadMembers(newMember);
//            model.put("item", newMember.getName());
//            model.put("newHero",newSquad.getName());
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//    }

    }
}
