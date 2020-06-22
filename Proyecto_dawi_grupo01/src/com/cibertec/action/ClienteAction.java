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
	private Ubigeo u = new Ubigeo();
	private String id;
	@Getter
	@Setter
	private List<Ubigeo> lstUbigeo = new ArrayList<Ubigeo>();
	@Getter
	@Setter
	private List<Cliente> lstCliente = new ArrayList<Cliente>();
	private Map<String, Object> session = ActionContext.getContext().getSession();

	@Action(value="/consultaCliente",results={@Result(name="success", location="/intranetCrudCliente.jsp")})
	public String listar(){
		log.info("En listar Cliente");	
		CapaDAOImpl service = new CapaDAOImpl();
		try {
			lstCliente =  service.traerClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
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
	@Action(value="/eliminaCliente",results={@Result(name="success", location="/intranetCrudCliente.jsp", type = "redirect")	})
	public String elimina(){
		log.info("En eliminar Cliente");
		try {
			CapaDAOImpl service = new CapaDAOImpl();
			int i=service.eliminarCliente(Integer.parseInt(id));
			if (i > 0) {
				session.put("MENSAJE", "Eliminacion exitosa");
			} else {
				session.put("MENSAJE", "Eliminacion errónea");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value="/actualizaCliente",results={@Result(name="success", location="/intranetCrudCliente.jsp", type = "redirect")})
	public String actualiza(){
		log.info("En actualizar Cliente");	
		try {
			CapaDAOImpl service = new CapaDAOImpl();
			int i=service.actualizarCliente(c);
			if (i > 0) {
				session.put("MENSAJE", "Actualizacion exitosa");
			} else {
				session.put("MENSAJE", "Actualizacion errónea");
			}
		} catch (Exception e) {e.printStackTrace();}
		return SUCCESS;
	}
	@Action(value = "/cargaUbigeo", results = { @Result(name = "success", type = "json") })
	public String cargaUbigeo() {
		log.info("En carga ubigeo");
		try {
			CapaDAOImpl service = new CapaDAOImpl();
			lstUbigeo = service.traerUbigeos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
