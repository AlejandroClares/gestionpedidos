package com.pgrsoft.gestionpedidos.backend.integration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="CLIENTES")
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = -54661L;

	@Id
    @TableGenerator(name = "CLIENTE_GENERATOR",
					table = "SECUENCIAS",
					pkColumnName = "SEQ_NAME",
					pkColumnValue = "CLIENTE_SEQ",
					valueColumnName = "SEQ_NUMBER",
					allocationSize = 10)
	
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "CLIENTE_GENERATOR")
	private Long id;
	
	private String nombre;
	
	@ElementCollection
	@CollectionTable(name="CONTACTOS_CLIENTE",joinColumns=@JoinColumn (name="ID_CLIENTE"))
	private List<ContactoDTO> contactos;
	
	public ClienteDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ContactoDTO> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactoDTO> contactos) {
		this.contactos = contactos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDTO other = (ClienteDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", nombre=" + nombre + ", contactos=" + contactos + "]";
	}
	
}
