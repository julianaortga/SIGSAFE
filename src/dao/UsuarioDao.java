package dao;

import model.Usuario;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dao.GenericDao;
import util.Conexion;

public class UsuarioDao extends Conexion<Usuario> implements GenericDao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
	}

	public Usuario iniciarSession(String correo, String clave) {
		Usuario u = null;
		EntityManager em = Conexion.getEm();
		try {
			em.getTransaction().begin();
			TypedQuery<Usuario> query = em.createQuery(
					"SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasena = :contrasena", Usuario.class);
			query.setParameter("correo", correo);
			query.setParameter("contrasena", clave);
			u = query.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close(); // miremos a ver si así funciona
		}
		return u;
	}

}