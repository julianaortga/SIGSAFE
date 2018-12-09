package dao;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dao.GenericDao;
import util.Conexion;

public class UsuarioDao extends Conexion<Usuario> implements GenericDao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
	}

	public Usuario iniciarSession(String usuario, String clave) {
		try {
			EntityManager em = Conexion.getEm();
			em.getTransaction().begin();
			TypedQuery<Usuario> query = em.createQuery(
					"SELECT u FROM usuario u WHERE u.correo = :usuario AND u.clave = :contrasena", Usuario.class);
			query.setParameter("correo", usuario);
			query.setParameter("clave", clave);
			return query.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}