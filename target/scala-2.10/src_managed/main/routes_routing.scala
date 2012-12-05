// @SOURCE:/Users/ecruz/softr8/primeraApp/conf/routes
// @HASH:9c306c5cba61ca4974247f359728db7b52899b11
// @DATE:Tue Dec 04 23:01:38 CST 2012


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Clientes_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("clientes"))))
        

// @LINE:9
private[this] lazy val controllers_Clientes_nuevo2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("clientes/nuevo"))))
        

// @LINE:10
private[this] lazy val controllers_Clientes_crear3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("clientes"))))
        

// @LINE:13
private[this] lazy val controllers_Proveedores_index4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("proveedores"))))
        

// @LINE:17
private[this] lazy val controllers_Assets_at5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+"""))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """clientes""","""controllers.Clientes.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """clientes/nuevo""","""controllers.Clientes.nuevo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """clientes""","""controllers.Clientes.crear()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """proveedores""","""controllers.Proveedores.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""" , Routes.prefix + ""))
   }
}
        

// @LINE:8
case controllers_Clientes_index1(params) => {
   call { 
        invokeHandler(controllers.Clientes.index(), HandlerDef(this, "controllers.Clientes", "index", Nil,"GET", """""" , Routes.prefix + "clientes"))
   }
}
        

// @LINE:9
case controllers_Clientes_nuevo2(params) => {
   call { 
        invokeHandler(controllers.Clientes.nuevo(), HandlerDef(this, "controllers.Clientes", "nuevo", Nil,"GET", """""" , Routes.prefix + "clientes/nuevo"))
   }
}
        

// @LINE:10
case controllers_Clientes_crear3(params) => {
   call { 
        invokeHandler(controllers.Clientes.crear(), HandlerDef(this, "controllers.Clientes", "crear", Nil,"POST", """""" , Routes.prefix + "clientes"))
   }
}
        

// @LINE:13
case controllers_Proveedores_index4(params) => {
   call { 
        invokeHandler(controllers.Proveedores.index(), HandlerDef(this, "controllers.Proveedores", "index", Nil,"GET", """ Proveedores""" , Routes.prefix + "proveedores"))
   }
}
        

// @LINE:17
case controllers_Assets_at5(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""" , Routes.prefix + "assets/$file<.+>"))
   }
}
        
}
    
}
        