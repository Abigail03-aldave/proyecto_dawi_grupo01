package com.cibertec.dao;

import java.util.List;

import com.cibertec.bean.Opcion;
import com.cibertec.bean.Usuario;

public interface CapaDAO {

		
	//Seguridad
	public List<Usuario> login(Usuario bean) throws Exception;
	public List<Opcion> traerEnlacesDeUsuario(String idUsuario)	throws Exception ;
	
		
	
}
