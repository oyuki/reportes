package formas;

import play.data.validation.Constraints.Required;

public class Cliente {
	@Required public String nombre_cte;
    @Required public String ap_pat_cte;
	@Required public String rfc_cte;
	
	public String ap_mat_cte;
	public String calle_cte;
	public String num_calle_cte;
	public String colonia_cte;
	public String codp_cte;
	public String mun_cte;
	public String est_cte;
	public String tel_cte;
	public String email_cte;
}
//dar alta clientes