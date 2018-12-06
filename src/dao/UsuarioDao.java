package dao;

import model.Usuario;
import dao.GenericDao;
import util.Conexion;

public class UsuarioDao extends Conexion<Usuario> implements GenericDao<Usuario>  {

	public UsuarioDao () {
		super(Usuario.class);
	}
}