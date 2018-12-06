package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ave database table.
 * 
 */
@Entity
@NamedQuery(name="Ave.findAll", query="SELECT a FROM Ave a")
public class Ave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_ave")
	private int idAve;

	private int edad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_baja")
	private Date fechaBaja;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Column(name="obs_inicial")
	private String obsInicial;

	private BigDecimal peso;

	private String sexaje;

	//bi-directional many-to-one association to Galpon
	@ManyToOne
	@JoinColumn(name="galpon")
	private Galpon galponBean;

	//bi-directional many-to-one association to Raza
	@ManyToOne
	@JoinColumn(name="raza")
	private Raza razaBean;

	public Ave() {
	}
	
	

	public Ave(int idAve, int edad, Date fechaBaja, Date fechaIngreso, String obsInicial, BigDecimal peso,
			String sexaje, Galpon galponBean, Raza razaBean) {
		super();
		this.idAve = idAve;
		this.edad = edad;
		this.fechaBaja = fechaBaja;
		this.fechaIngreso = fechaIngreso;
		this.obsInicial = obsInicial;
		this.peso = peso;
		this.sexaje = sexaje;
		this.galponBean = galponBean;
		this.razaBean = razaBean;
	}



	public Ave(int edad, Date fechaBaja, Date fechaIngreso, String obsInicial, BigDecimal peso, String sexaje,
			Galpon galponBean, Raza razaBean) {
		super();
		this.edad = edad;
		this.fechaBaja = fechaBaja;
		this.fechaIngreso = fechaIngreso;
		this.obsInicial = obsInicial;
		this.peso = peso;
		this.sexaje = sexaje;
		this.galponBean = galponBean;
		this.razaBean = razaBean;
	}



	public int getIdAve() {
		return this.idAve;
	}

	public void setIdAve(int idAve) {
		this.idAve = idAve;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getObsInicial() {
		return this.obsInicial;
	}

	public void setObsInicial(String obsInicial) {
		this.obsInicial = obsInicial;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getSexaje() {
		return this.sexaje;
	}

	public void setSexaje(String sexaje) {
		this.sexaje = sexaje;
	}

	public Galpon getGalponBean() {
		return this.galponBean;
	}

	public void setGalponBean(Galpon galponBean) {
		this.galponBean = galponBean;
	}

	public Raza getRazaBean() {
		return this.razaBean;
	}

	public void setRazaBean(Raza razaBean) {
		this.razaBean = razaBean;
	}

}