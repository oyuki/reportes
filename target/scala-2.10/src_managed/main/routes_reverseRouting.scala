// @SOURCE:/Users/ecruz/softr8/primeraApp/conf/routes
// @HASH:9c306c5cba61ca4974247f359728db7b52899b11
// @DATE:Tue Dec 04 23:01:38 CST 2012


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:17
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers {

// @LINE:10
// @LINE:9
// @LINE:8
class ReverseClientes {
    

// @LINE:9
def nuevo(): Call = {
   Call("GET", Routes.prefix + { Routes.defaultPrefix } + "clientes/nuevo")
}
                                                

// @LINE:10
def crear(): Call = {
   Call("POST", Routes.prefix + { Routes.defaultPrefix } + "clientes")
}
                                                

// @LINE:8
def index(): Call = {
   Call("GET", Routes.prefix + { Routes.defaultPrefix } + "clientes")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", Routes.prefix)
}
                                                
    
}
                          

// @LINE:13
class ReverseProveedores {
    

// @LINE:13
def index(): Call = {
   Call("GET", Routes.prefix + { Routes.defaultPrefix } + "proveedores")
}
                                                
    
}
                          

// @LINE:17
class ReverseAssets {
    

// @LINE:17
def at(file:String): Call = {
   Call("GET", Routes.prefix + { Routes.defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:17
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:10
// @LINE:9
// @LINE:8
class ReverseClientes {
    

// @LINE:9
def nuevo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Clientes.nuevo",
   """
      function() {
      return _wA({method:"GET", url:"""" + Routes.prefix + { Routes.defaultPrefix } + """" + "clientes/nuevo"})
      }
   """
)
                        

// @LINE:10
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Clientes.crear",
   """
      function() {
      return _wA({method:"POST", url:"""" + Routes.prefix + { Routes.defaultPrefix } + """" + "clientes"})
      }
   """
)
                        

// @LINE:8
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Clientes.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + Routes.prefix + { Routes.defaultPrefix } + """" + "clientes"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + Routes.prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:13
class ReverseProveedores {
    

// @LINE:13
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Proveedores.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + Routes.prefix + { Routes.defaultPrefix } + """" + "proveedores"})
      }
   """
)
                        
    
}
              

// @LINE:17
class ReverseAssets {
    

// @LINE:17
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + Routes.prefix + { Routes.defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:17
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.ref {

// @LINE:10
// @LINE:9
// @LINE:8
class ReverseClientes {
    

// @LINE:9
def nuevo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Clientes.nuevo(), HandlerDef(this, "controllers.Clientes", "nuevo", Seq(), "GET", """""""",  Routes.prefix + "clientes/nuevo")
)
                      

// @LINE:10
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Clientes.crear(), HandlerDef(this, "controllers.Clientes", "crear", Seq(), "POST", """""""",  Routes.prefix + "clientes")
)
                      

// @LINE:8
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Clientes.index(), HandlerDef(this, "controllers.Clientes", "index", Seq(), "GET", """""""",  Routes.prefix + "clientes")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """" Home page"""",  Routes.prefix + "")
)
                      
    
}
                          

// @LINE:13
class ReverseProveedores {
    

// @LINE:13
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Proveedores.index(), HandlerDef(this, "controllers.Proveedores", "index", Seq(), "GET", """" Proveedores"""",  Routes.prefix + "proveedores")
)
                      
    
}
                          

// @LINE:17
class ReverseAssets {
    

// @LINE:17
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """" Map static resources from the /public folder to the /assets URL path"""",  Routes.prefix + "assets/$file<.+>")
)
                      
    
}
                          
}
                  
      