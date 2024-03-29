package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {

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
        var app = getHello();
        app.start(7070);
    }
}
