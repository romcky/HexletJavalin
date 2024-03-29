package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;


public class HelloWorld {
    public static UserBase userBase = new UserBase();

    public static Javalin getUsers() {
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.fileRenderer(new JavalinJte());
        });
        app.get("/users", ctx -> {
            ctx.render("users.jte", model("userBase", userBase));
        });

        app.get("/users/{id}", ctx -> {
            try {
                int id = ctx.pathParamAsClass("id", Integer.class).get();
                User user = userBase.getUserById(id).orElseThrow(
                        () -> new NotFoundResponse("No such user id!")
                );
                ctx.render("user.jte", model("user", user));
            } catch (Exception exception) {
                throw new NotFoundResponse("Wrong id path!");
            }
        });
        return app;
    }
    public static Javalin getHello() {
        Javalin app = Javalin.create();
        app.get("/hello", ctx -> {
            String name = ctx.queryParam("name");
            ctx.contentType("text/html");
            String body = String.format("<h1>Hello, %s!</h1>",
                    name == null ? "World" : name);
            ctx.result(body);
        });
        return app;
    }

    public static void main(String[] args) {
        var app = getUsers();
        app.start(7070);
    }
}
