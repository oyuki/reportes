
package views.html.proveedores

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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[formas.proveedores.Filtro],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(formaFiltros: Form[formas.proveedores.Filtro]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.49*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Proveedores")/*5.21*/ {_display_(Seq[Any](format.raw/*5.23*/("""
  """),_display_(Seq[Any](/*6.4*/form(action = routes.Proveedores.index)/*6.43*/ {_display_(Seq[Any](format.raw/*6.45*/("""
	    <div class="span12">
	      <div class="span4">
	        """),_display_(Seq[Any](/*9.11*/inputText(
            field = formaFiltros("clave_proveed"),
            args = '_label -> "Clave"
          ))),format.raw/*12.12*/("""
	      </div>
	      <div class="span4">
          """),_display_(Seq[Any](/*15.12*/inputText(
            field = formaFiltros("nombre_proveed"),
            args = '_label -> "Nombre"
          ))),format.raw/*18.12*/("""
        </div>
      </div>
      <div class="span12">
        <div class="span4">
          """),_display_(Seq[Any](/*23.12*/inputText(
            field = formaFiltros("rfc_proveed"),
            args = '_label -> "RFC"
          ))),format.raw/*26.12*/("""
        </div>
        <div class="span4">
          <input type="submit" value="Filtrar">
        </div>
	    </div>
	""")))})),format.raw/*32.3*/("""

  <table class="table table-striped table-bordered">
    <caption> Clientes </caption>
    <thead>
       <tr>
         <th> Clave </th>
         <th> Nombre </th>
         <th> RFC </th>
       </tr>
    </thead>
    
    <tbody>
    </tbody>
  </table>
""")))})))}
    }
    
    def render(formaFiltros:Form[formas.proveedores.Filtro]): play.api.templates.Html = apply(formaFiltros)
    
    def f:((Form[formas.proveedores.Filtro]) => play.api.templates.Html) = (formaFiltros) => apply(formaFiltros)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 04 23:27:24 CST 2012
                    SOURCE: /Users/ecruz/softr8/primeraApp/app/views/proveedores/index.scala.html
                    HASH: db31ae5c2b4f98ca8a0a4a9f98942e80017285a4
                    MATRIX: 760->1|900->48|928->67|964->69|991->88|1030->90|1068->94|1115->133|1154->135|1253->199|1386->310|1475->363|1610->476|1741->571|1870->678|2022->799
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|34->6|34->6|34->6|37->9|40->12|43->15|46->18|51->23|54->26|60->32
                    -- GENERATED --
                */
            