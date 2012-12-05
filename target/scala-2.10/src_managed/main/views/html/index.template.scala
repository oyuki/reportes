
package views.html

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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.19*/(""" 

"""),_display_(Seq[Any](/*3.2*/main("Welcome to Play 2.0")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""

<table class="table table-hover table-striped table-bordered">
  <caption>
    Titulo tabla!
  </caption>
	<thead>
		<tr>
			<th>Numero</th>
		</tr>
	</thead>
  <tbody>
    <tr class="error">
      <td> Error </td>
    </tr>
    <tr>
      <td> Contenido </td>
    </tr>
    <tr>
      <td> Contenido </td>
    </tr>
    <tr>
      <td> Contenido </td>
    </tr>
    <tr>
      <td> Contenido </td>
    </tr>
    <tr>
      <td> Contenido </td>
    </tr>
    <tr>
      <td> Contenido </td>
    </tr>
    <tr>
      <td> Contenido </td>
    </tr>
  </tbody>
</table>

""")))})),format.raw/*42.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.Html = apply(message)
    
    def f:((String) => play.api.templates.Html) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 27 23:10:05 CST 2012
                    SOURCE: /Users/ecruz/softr8/primeraApp/app/views/index.scala.html
                    HASH: 348082f50b8eb6152c2f34c72694acbb488ec0da
                    MATRIX: 723->1|817->18|855->22|890->49|929->51|1531->622
                    LINES: 26->1|29->1|31->3|31->3|31->3|70->42
                    -- GENERATED --
                */
            