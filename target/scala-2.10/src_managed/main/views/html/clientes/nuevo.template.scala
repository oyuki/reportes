
package views.html.clientes

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object nuevo extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[formas.Cliente],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(formaCliente: Form[formas.Cliente]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.38*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Nuevo Cliente")/*5.23*/ {_display_(Seq[Any](format.raw/*5.25*/("""
  
  """),_display_(Seq[Any](/*7.4*/form(action = routes.Clientes.crear)/*7.40*/ {_display_(Seq[Any](format.raw/*7.42*/("""
     """),_display_(Seq[Any](/*8.7*/inputText(
        field = formaCliente("nombre_cte"),
        args = '_label -> "Nombre"
     ))),format.raw/*11.7*/("""

     """),_display_(Seq[Any](/*13.7*/inputText(
        field = formaCliente("ap_pat_cte"),
        args = '_label -> "Apellido Paterno"
     ))),format.raw/*16.7*/("""

     """),_display_(Seq[Any](/*18.7*/inputText(
        field = formaCliente("rfc_cte"),
        args = '_label -> "RFC"
     ))),format.raw/*21.7*/("""
     
     <p class="buttons">
       <input type="submit" value="Guardar">
     </p>
  """)))})),format.raw/*26.4*/("""

""")))})))}
    }
    
    def render(formaCliente:Form[formas.Cliente]): play.api.templates.Html = apply(formaCliente)
    
    def f:((Form[formas.Cliente]) => play.api.templates.Html) = (formaCliente) => apply(formaCliente)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 04 21:17:29 CST 2012
                    SOURCE: /Users/ecruz/softr8/primeraApp/app/views/clientes/nuevo.scala.html
                    HASH: 236745fd3a3d798d52a26e0f305a9416873fd116
                    MATRIX: 746->1|875->37|903->56|939->58|968->79|1007->81|1048->88|1092->124|1131->126|1172->133|1289->229|1332->237|1459->343|1502->351|1613->441|1734->531
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|36->8|39->11|41->13|44->16|46->18|49->21|54->26
                    -- GENERATED --
                */
            