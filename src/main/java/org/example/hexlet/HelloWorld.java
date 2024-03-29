package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

public class HelloWorld {

    public static Javalin getUsers() {
        Javalin app = Javalin.create();
        app.get("/users/{id}/post/{postId}", ctx -> {
            try {
                int id = ctx.pathParamAsClass("id", Integer.class).get();
                int postId = ctx.pathParamAsClass("postId", Integer.class).get();
                ctx.result(String.format("id = %d, postId = %d", id, postId));
            } catch (Exception exception) {
                ctx.result("Wrong id or postId!");
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
