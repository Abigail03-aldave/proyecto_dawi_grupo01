package com.cibertec.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.cibertec.bean.Cliente;
import com.cibertec.bean.Ubigeo;
import com.cibertec.dao.CapaDAOImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class ClienteAction extends ActionSupport {

	private static final Log log = LogFactory.getLog(ClienteAction.class);

	@Getter
	@Setter
	private Cliente c = new Cliente();

	@Getter
	@Setter
	private List<Ubigeo> lstUbigeo = new ArrayList<Ubigeo>();

	private Map<String, Object> session = ActionContext.getContext().getSession();

	@Action(value = "/registraCliente", results = {
			@Result(name = "success", location = "/intranetCrudCliente.jsp", type = "redirect") })
	public String registra() {
		log.info("En registrar Cliente");
		try {
			CapaDAOImpl service = new CapaDAOImpl();
			int s = service.insertarCliente(c);
			if (s > 0) {
				session.put("MENSAJE", "Registro exitoso");
			} else {
				session.put("MENSAJE", "Registro erróneo");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/cargaCategoria", results = { @Result(name = "success", type = "json") })
	public String cargaDeporte() {
		log.info("En carga deporte");
		try {
			ClienteServiceImpl service = new ClienteServiceImpl();
			lstCategoria = service.listaCategoria();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
