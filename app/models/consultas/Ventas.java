package models.consultas;

import java.util.List;

import javax.persistence.Entity;  
import javax.persistence.OneToOne;  

import models.Venta;
  
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.avaje.ebean.annotation.Sql;  

@Entity
@Sql
public class Ventas {

	Double total;
	Integer semana;
	Integer mes;
	
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	
	public void setSemana(Integer semana) {
		this.semana = semana; 
	}
	public Integer getSemana() {
		return semana;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Double getTotal() {
		return total;
	}

	public static List<models.consultas.Ventas> ventasPorSemana() {
		String sql = "select DATEPART(\"WEEK\", CONVERT(datetime, c.fech_coman)) as semana, SUM(dc.cant_prod_coman*dc.prec_prod_det) as total " +
					 "from comandas c inner join detalle_comanda dc on c.num_coman = dc.num_coman " +
					 "group by DATEPART(\"WEEK\", CONVERT(datetime, c.fech_coman))";
		RawSql rawSql = RawSqlBuilder
				.unparsed(sql)
				.columnMapping("semana", "semana")
				.columnMapping("total", "total")
				.create();
		Query<models.consultas.Ventas> query = Ebean.find(models.consultas.Ventas.class);  
	    query.setRawSql(rawSql);
	    return query.findList();
	}

	
	public static List<models.consultas.Ventas> ventasPorMes() {
		String sql = "select DATEPART(\"MONTH\", CONVERT(datetime, c.fech_coman)) as mes, SUM(dc.cant_prod_coman*dc.prec_prod_det) as total " +
					 "from comandas c inner join detalle_comanda dc on c.num_coman = dc.num_coman " +
					 "group by DATEPART(\"MONTH\", CONVERT(datetime, c.fech_coman))";
		RawSql rawSql = RawSqlBuilder
				.unparsed(sql)
				.columnMapping("mes", "mes")
				.columnMapping("total", "total")
				.create();
		Query<models.consultas.Ventas> query = Ebean.find(models.consultas.Ventas.class);  
	    query.setRawSql(rawSql);
	    return query.findList();
	}

}
