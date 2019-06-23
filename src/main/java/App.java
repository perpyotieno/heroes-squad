import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
return new ModelAndView(model, "index.hbs");
        },new HandlebarsTemplateEngine());


        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "hero.hbs");
        },new HandlebarsTemplateEngine());

        post("/heros/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String specialPowers = request.queryParams("specialPowers");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, age, specialPowers, weakness);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heros/list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);

            return new ModelAndView(model, "heroesList.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heros/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Hero.clearAllPosts();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heros/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(request.params(":id"));
            Hero foundHero = Hero.findById(idOfHeroToFind);
            model.put("hero", foundHero);
            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heros/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHerotoEdit = Integer.parseInt(request.params("id"));
            Hero editHero = Hero.findById(idOfHerotoEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heros/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("name");
            int newAge = Integer.parseInt(req.queryParams("age"));
            String newSpecialPowers = req.queryParams("specialPowers");
            String newWeakness = req.queryParams("weakness");
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.findById(idOfHeroToEdit);
            editHero.update(newName, newAge, newSpecialPowers, newWeakness);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        get("/heros/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToDelete = Integer.parseInt(req.params("id"));
            Hero deleteHero = Hero.findById(idOfPostToDelete);
            deleteHero.deleteHero();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());



    }
}
