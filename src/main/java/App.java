import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.Map;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/index.vtl");

      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/new-stylist", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/new-stylist.vtl");
      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());

      String name = request.queryParams("stylistName");
      Stylist newStylist = new Stylist(name);
      newStylist.save();
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/new-client", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/new-client.vtl");
      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());

      String name = request.queryParams("clientName");
      int phone = Integer.parseInt(request.queryParams("clientPhone"));
      int stylist_id = Integer.parseInt(request.queryParams("stylistId"));
      Client newClient = new Client(name, phone, stylist_id);
      newClient.save();
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/client/:id/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/edit-client.vtl");
      model.put("client", Client.find(Integer.parseInt(request.params(":id"))));
      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/client/:id/edit-client-success", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/edit-client-success.vtl");
      Client client = Client.find(Integer.parseInt(request.params(":id")));
      String name = request.queryParams("clientName");
      int phone = Integer.parseInt(request.queryParams("clientPhone"));
      int stylist_id = Integer.parseInt(request.queryParams("stylistId"));
      client.update(name, phone, stylist_id);
      model.put("clients", Client.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/client/:id/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      Client client = Client.find(Integer.parseInt(request.params(":id")));
      client.delete();
      model.put("clients", Client.all());
      model.put("template", "templates/delete-client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylist/:id/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/edit-stylist.vtl");
      model.put("stylist", Stylist.find(Integer.parseInt(request.params(":id"))));
      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylist/:id/edit-stylist-success", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/edit-stylist-success.vtl");
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      String name = request.queryParams("stylistName");
      stylist.update(name);
      model.put("stylists", Stylist.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    post("/stylist/:id/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      stylist.delete();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/delete-stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
