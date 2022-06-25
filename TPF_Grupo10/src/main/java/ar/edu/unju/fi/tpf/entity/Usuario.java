package ar.edu.unju.fi.tpf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USU_ID")
	private Long id;
	@Column(name = "USU_UNICO")
	private Long idActivo;
	@Column(name = "USU_NAME")
	private String username;
	@Column(name = "USU_PASS")
	private String password;
	@Column(name = "USU_ROLE")
	private String role;
	@Column(name = "USU_ACTIVO")
	private boolean status;

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdActivo() {
		return idActivo;
	}

	public void setIdActivo(Long idActivo) {
		this.idActivo = idActivo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", idActivo=" + idActivo + ", username=" + username + ", password=" + password
				+ ", role=" + role + ", status=" + status + "]";
	}
	
}
