package app;

import app.controllers.DogController;
import app.controllers.ErrorMessage;
import app.dtos.DogDTO;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    public static void main(String[] args){
        DogController dogController = new DogController();
        Javalin.create(config->{
            config.router.contextPath = "/api";
            config.router.apiBuilder(()->
            {
                path("dog", ()->{
                    get("/", (ctx)->ctx.json(dogController.getAll()));
//                           get("/demo", (ctx)->ctx.result("This is the demo endpoint"));
                    get("/{id}", (ctx)-> {
                        try {
                            DogDTO dog = dogController.getById(Integer.parseInt(ctx.pathParam("id")));
                            ctx.json(dog);

                        } catch (Exception ex){
                            ErrorMessage error = new ErrorMessage("No dog with that id");
                            ctx.status(404).json(error);
                        }

                    });
                    post("/", (ctx)->{
                        DogDTO incomingDog = ctx.bodyAsClass(DogDTO.class);
                        DogDTO returnedDog = dogController.create(incomingDog);
                        ctx.json(returnedDog);
                    });
//                           put("/{id}", (ctx)->{
//                               int id = Integer.parseInt(ctx.pathParam("id"));
//                               DogDTO incomingDog = ctx.bodyAsClass(DogDTO.class);
//                               for(int i = 0; i<dogs.size(); i++){
//                                   if(dogs.get(i).getId() == id){
//                                       incomingDog.setId(id);
//                                       dogs.set(i, incomingDog);
//                                   }
//                               }
//                               ctx.json(dogs.get(id-1));
//                           });
                });
            });

        }).start(7070);
    }

//    package app;
//
//import app.controllers.DogController;
//import app.controllers.ErrorMessage;
//import app.dtos.DogDTO;
//import io.javalin.Javalin;
//
//import static io.javalin.apibuilder.ApiBuilder.*;
//
//    public class Main {
//        public static void main(String[] args) {
//            DogController dogController = new DogController();
//            Javalin app = Javalin.create(config -> {
//                config.router.contextPath = "/api";
//            }).start(7070);
//
//            app.routes(() -> {
//                path("dog", () -> {
//                    get("/", ctx -> ctx.json(dogController.getAllDogs()));
//                    get("/{id}", ctx -> {
//                        try {
//                            DogDTO dog = dogController.getDogById(Integer.parseInt(ctx.pathParam("id")));
//                            ctx.json(dog);
//                        } catch (Exception ex) {
//                            ctx.status(404).json(new ErrorMessage("No dog with that ID"));
//                        }
//                    });
//                    post("/", ctx -> {
//                        DogDTO newDog = ctx.bodyAsClass(DogDTO.class);
//                        ctx.json(dogController.createDog(newDog));
//                    });
//                    put("/{id}", ctx -> {
//                        try {
//                            int id = Integer.parseInt(ctx.pathParam("id"));
//                            DogDTO updatedDog = ctx.bodyAsClass(DogDTO.class);
//                            ctx.json(dogController.updateDog(id, updatedDog));
//                        } catch (Exception ex) {
//                            ctx.status(404).json(new ErrorMessage("No dog with that ID"));
//                        }
//                    });
//                    delete("/{id}", ctx -> {
//                        int id = Integer.parseInt(ctx.pathParam("id"));
//                        if (dogController.deleteDog(id)) {
//                            ctx.status(204);
//                        } else {
//                            ctx.status(404).json(new ErrorMessage("No dog with that ID"));
//                        }
//                    });
//                });
//            });
//        }
//    }

}