package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;


public class Acceso extends Security.Authenticator {
    
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("logeado");
    }
    
    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect("/login");
    }

}
