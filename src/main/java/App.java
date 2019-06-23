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
        get("/heros/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(request.params(":id"));
            Hero foundHero = Hero.findById(idOfHeroToFind);
            model.put("hero", foundHero);
            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
