
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
<head>
<title>"""),_display_(Seq[Any](/*7.9*/title)),format.raw/*7.14*/("""</title>
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.46*/routes/*8.52*/.Assets.at("stylesheets/main.css"))),format.raw/*8.86*/("""">
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.46*/routes/*9.52*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*9.95*/("""">
<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*10.51*/routes/*10.57*/.Assets.at("images/favicon.png"))),format.raw/*10.89*/("""">
<script src=""""),_display_(Seq[Any](/*11.15*/routes/*11.21*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*11.66*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*12.63*/("""" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<div class="span12">
			<div class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Opciones</a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					<li>
					  <a href="/clientes/nuevo">Nuevo Cliente!</a>
					</li>
					<li>
					 <a href="/clientes">Clientes</a>
					</li>
          <li>
           <a href="/proveedores">Proveedores</a>
          </li>
				</ul>
			</div>
		</div>
		<div class="span12">"""),_display_(Seq[Any](/*32.24*/content)),format.raw/*32.31*/("""</div>
	</div>
</body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.Html = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 04 23:01:38 CST 2012
                    SOURCE: /Users/ecruz/softr8/primeraApp/app/views/main.scala.html
                    HASH: 8146b48bc997e22adbc29cbdd39e560f5600cadf
                    MATRIX: 727->1|834->31|909->72|935->77|1024->131|1038->137|1093->171|1176->219|1190->225|1254->268|1343->321|1358->327|1412->359|1465->376|1480->382|1547->427|1632->476|1647->482|1711->524|2281->1058|2310->1065
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|60->32|60->32
                    -- GENERATED --
                */
            