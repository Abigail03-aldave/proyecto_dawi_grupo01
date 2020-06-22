package com.cibertec.dao;

import java.util.List;

import com.cibertec.bean.Cliente;
import com.cibertec.bean.Opcion;
import com.cibertec.bean.Usuario;

public interface CapaDAO {

		
	//Seguridad
	public List<Usuario> login(Usuario bean) throws Exception;
	public List<Opcion> traerEnlacesDeUsuario(String idUsuario)	throws Exception ;
	//Cliente
	public List<Cliente> traerClientes()throws Exception ;	
	public List<Cliente> traerCliente(int idCliente)throws Exception ;	
	public int insertarCliente(Cliente c)throws Exception ;	
	public int actualizarCliente(Cliente c)throws Exception ;	
	public int eliminarCliente(int idCliente)throws Exception ;	
}
