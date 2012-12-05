
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Cliente],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(clientes: List[Cliente]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.27*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Clientes")/*5.18*/ {_display_(Seq[Any](format.raw/*5.20*/("""

  <table class="table table-striped table-bordered">
    <caption> Clientes </caption>
    <thead>
       <tr>
         <th> Nombre </th>
         <th> Apellido Paterno </th>
         <th> RFC </th>
       </tr>
    </thead>
    
    <tbody>
      """),_display_(Seq[Any](/*18.8*/clientes/*18.16*/.map/*18.20*/ { cliente =>_display_(Seq[Any](format.raw/*18.33*/("""
        <tr>
          <td>"""),_display_(Seq[Any](/*20.16*/cliente/*20.23*/.nombre_cte)),format.raw/*20.34*/("""</td>
          <td>"""),_display_(Seq[Any](/*21.16*/cliente/*21.23*/.ap_pat_cte)),format.raw/*21.34*/("""</td>
          <td>"""),_display_(Seq[Any](/*22.16*/cliente/*22.23*/.rfc_cte)),format.raw/*22.31*/("""</td>
        </tr>
      """)))})),format.raw/*24.8*/("""
    </tbody>
  </table>
""")))})))}
    }
    
    def render(clientes:List[Cliente]): play.api.templates.Html = apply(clientes)
    
    def f:((List[Cliente]) => play.api.templates.Html) = (clientes) => apply(clientes)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 04 21:48:06 CST 2012
                    SOURCE: /Users/ecruz/softr8/primeraApp/app/views/clientes/index.scala.html
                    HASH: df495d2f05cc6d4e2df1dd986951df977dbd6ffb
                    MATRIX: 739->1|857->26|885->45|921->47|945->63|984->65|1270->316|1287->324|1300->328|1351->341|1416->370|1432->377|1465->388|1522->409|1538->416|1571->427|1628->448|1644->455|1674->463|1732->490
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|46->18|46->18|46->18|46->18|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|52->24
                    -- GENERATED --
                */
            