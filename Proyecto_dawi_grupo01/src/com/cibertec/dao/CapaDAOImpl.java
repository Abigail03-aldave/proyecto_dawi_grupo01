package com.cibertec.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cibertec.bean.Cliente;
import com.cibertec.bean.Opcion;
import com.cibertec.bean.Usuario;

public class CapaDAOImpl implements CapaDAO{

	SqlSessionFactory sqlMapper = null;
	{
		String archivo = "ConfiguracionIbatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(archivo);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//
	@Override
	public List<Usuario> login(Usuario bean) throws Exception {
		List<Usuario> lista = new ArrayList<Usuario>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_login", bean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}
	
	@Override
	public List<Opcion> traerEnlacesDeUsuario(String idUsuario) throws Exception {
		List<Opcion> lista = new ArrayList<Opcion>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_traerEnlacesDeUsuario", idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}
	/*Cliente*/

	@Override
	public List<Cliente> traerClientes() throws Exception {
		List<Cliente> lista = new ArrayList<Cliente>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_traerClientes");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}

	@Override
	public List<Cliente> traerCliente(int idCliente) throws Exception {
		List<Cliente> lista = new ArrayList<Cliente>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_traerClientes",idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}

	@Override
	public int insertarCliente(Cliente c) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.insert("SQL_inserta_cliente", c);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}

	@Override
	public int actualizarCliente(Cliente c) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.update("SQL_actualizar_cliente", c);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}

	@Override
	public int eliminarCliente(int idCliente) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			 session = sqlMapper.openSession();
			 salida = session.delete("SQL_eliminar_cliente", idCliente);
			 session.commit();
		} catch (Exception e) {
			 e.printStackTrace();
			 session.rollback();
		} finally{
			 session.close();
		}
		return salida;
	}
	
}
